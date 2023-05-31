package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.VirtualView;

import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static it.polimi.ingsw.Model.GameState.*;

public class GameController {
    private Game game;
    private GameState gameState;
    private  int numOfPlayers;
    private Player currentPlayer;
    private Player firstPlayer;
    private InputController inputController;
    private ArrayList<Player> players;
    private Map<Player, VirtualView> virtualViewMap;
    private final Server server;
    private boolean lastRound = false;
    private boolean firstTurn = true;

    private Lock lock = new ReentrantLock();


    /**
     * constructor
     */
    public GameController(Server server) {
        this.game = new Game();
        this.server = server;
        this.players = new ArrayList<>();
        //this.numOfPlayers = num;
        this.inputController = new InputController(this, server);
        setGameState(LOGIN);
        //virtualViewMap = new HashMap<>();
    }

    /**
     * this method receives the message from the client and decides what method must be called based on
     * the actual state of the game
     * @param message
     * @throws RemoteException
     */
    public synchronized void forwardMessage(Message message) throws InterruptedException {

        switch (gameState) {
            case LOGIN:
                if(message.getMessageType()==MessageType.NUM_OF_PLAYERS_REPLY) {
                    NumOfPlayersReply numOfPlayersReply = (NumOfPlayersReply) message;
                    setNumOfPlayers(message);
                    game.setNumOfPlayers(numOfPlayersReply.getNumOfPlayers());
                    game.getCommonGoal1().setDelta(numOfPlayersReply.getNumOfPlayers());
                    game.getCommonGoal2().setDelta(numOfPlayersReply.getNumOfPlayers());
                    //server.sendMessage(new GenericMessage("The number of players is set. Now wait for other players to connect!"),message.getNickname());
                    server.sendMessage(new WaitingRoomMessage(numOfPlayersReply.getNumOfPlayers(), virtualViewMap.size()), message.getNickname());
                    //restoreMatchElements();
                }else {
                    Server.LOGGER.severe("Message from the client is not the number of players");
                }
                break;
            case PLAY:
                handleGame(message);
                break;
            case END:
                EndTurn();
                break;
            default:
                Server.LOGGER.severe("Error while receiving message");
        }
    }

    /**
     * this method decides if a client who wants to play the game can be admitted or not. If he is the first player,
     * this method asks what is the number of players.
     * @param nickname nickname of the player
     * @param vv virtual view of the player
     * @throws RemoteException
     */
    public synchronized void handleLogin(String nickname, VirtualView vv) throws InterruptedException {
        Player player = new Player(this.game);

        if (numOfPlayers == 0) {
            addVirtualView(player, vv);
            players.add(player);
            player.setNickname(nickname);
            game.addPlayer(player);
            server.sendMessage(new LoginResult(nickname, true, true), nickname);
            server.sendMessage(new NumOfPlayersRequest(), nickname);
            server.sendMessage(new LoginReply(nickname), nickname);
        } else if (virtualViewMap.size() < numOfPlayers) {
            if (inputController.checkNickname(nickname, vv)) {
                addVirtualView(player, vv);
                players.add(player);
                player.setNickname(nickname);
                game.addPlayer(player);
                server.sendMessage(new LoginResult(nickname, true, true), nickname);
                server.sendMessage(new LoginReply(nickname), nickname);
                //server.sendMessage(new WaitingRoomMessage(numOfPlayers, virtualViewMap.size()), nickname);
                server.broadcastMessage(new WaitingRoomMessage(numOfPlayers, virtualViewMap.size()));

                if (virtualViewMap.size() == numOfPlayers)
                    startGame();
            } else
                vv.loginResult(false, true, nickname);
        } else if (virtualViewMap.size() == numOfPlayers) {
            vv.loginResult(true, false, nickname);
            vv.getConnection().disconnectClient();
        }
    }


    /**
     * this method is called when the game is already started and a message from the client arrives. It decides what
     * method must be called based on the type of the message.
     * @param message
     * @throws RemoteException
     */
    public void handleGame(Message message) {

        switch (message.getMessageType()){
            case CHOSEN_TILES_REPLY:
                chooseTiles(message);
                break;
            case COLUMN_REPLY:
                SelectedColumn(message);
                break;
            case ORDERED_TILES_REPLY:
                InsertTiles(message);
                break;
            case DISCONNECTION_REQUEST:
                handleDisconnection(message);
                break;
            case INDEX_TILES:
                removeTilesFromLivingRoom(message);
                break;

        }
    }


    public void startGame() {
        setGameState(PLAY);
        game.initializeLivingRoom();
        game.setPersonalGoalCard();
        ArrayList<Tile> chosen = game.getBag().extract(game.numberOfTiles());
        game.getLivingRoom().insertTiles(chosen);
        currentPlayer = game.pickFirstPlayer();
        firstPlayer = currentPlayer;
        server.broadcastMessage(new GameStartedMessage(game));
        newTurn();
    }

    public synchronized void setNumOfPlayers(Message message){
        NumOfPlayersReply numOfPlayersReply = (NumOfPlayersReply) message;
        int num = numOfPlayersReply.getNumOfPlayers();
        this.numOfPlayers = num;
    }

    /**
     * This method set the currentPlayer who is going play the turn
     */
    public void nextPlayer(){
        int indexPlayer = players.indexOf(currentPlayer);

        if(indexPlayer+1 >= players.size())
            this.currentPlayer = players.get(0);
        else
            this.currentPlayer = players.get(indexPlayer + 1);

    }

    /**
     * this method initializes a new turn.
     */
    public void newTurn() {
        //yourTurn(gameController.getCurrentPlayer());
        if(firstTurn){
            firstTurn = false;
        }

        ArrayList<Player> scoreBoard = game.getScoreBoard(game.getPlayers());
        server.broadcastMessage(new ScoreBoardMessage(scoreBoard));

        restoreMatchElements();

        for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()){
            if(!map.getKey().equals(currentPlayer))
                map.getValue().showMessage("It's the turn of " + currentPlayer.getNickname());
            else
                map.getValue().showMessage("It's your turn, " + currentPlayer.getNickname() + "!");
        }

        server.sendMessage(new ChosenTilesRequest(game.getLivingRoom()),currentPlayer.getNickname());
    }

    /**
     * This method receives the tiles chosen from the current Player on the livingRoom. If the selection is valid,
     * it asks the client to select the column, otherwise it asks to select the tiles again.
     * @param message tiles the client chose
     */
    public void chooseTiles(Message message) {
        ChosenTilesReply chosenTilesMessage = (ChosenTilesReply) message;
        ArrayList<Tile> chosen = chosenTilesMessage.getChosenTiles();

        if(inputController.livingRoomChosenTiles(chosenTilesMessage)){
            ArrayList<Tile> TemporaryChosenTiles = new ArrayList<>();

            TemporaryChosenTiles.addAll(chosen);

            currentPlayer.setChosenTiles(TemporaryChosenTiles);
            ArrayList<Integer> availableColumns = currentPlayer.getBookshelf().getFreeColumns(chosen.size());

            server.sendMessage(new ColumnRequest(availableColumns),currentPlayer.getNickname());
        }else{
            server.sendMessage(new ChosenTilesRequest(game.getLivingRoom()),currentPlayer.getNickname());
        }
    }

    /**
     * this method check if the column chosen by the client is valid. If it's not, it asks the user to select another
     * column, otherwise it asks him to order the tiles he has already chosen.
     * @param message
     */
    public void SelectedColumn(Message message) {
        ColumnReply chosenColumn = (ColumnReply) message;
        int chosen = chosenColumn.getColumn();

        if(inputController.selectedColumn(chosenColumn)){
            currentPlayer.setChosenColumn(chosen);

            server.sendMessage(new OrderedTilesRequest(currentPlayer.getChosenTiles()),currentPlayer.getNickname());
        }else{
            ArrayList<Integer> availableColumns;
            availableColumns = currentPlayer.getBookshelf().getFreeColumns(currentPlayer.getChosenTiles().size());

            server.sendMessage(new ColumnRequest(availableColumns),currentPlayer.getNickname());
        }
    }

    /**
     * this method receives the ordered tiles and inserts them in the bookshelf of the currentPlayer.
     * @param message
     */
    public void InsertTiles(Message message) {
        OrderedTilesReply orderedTilesReply = (OrderedTilesReply) message;
        ArrayList<Tile> chosenTiles = orderedTilesReply.getOrderedTiles();

        currentPlayer.getBookshelf().insertTiles(chosenTiles, currentPlayer.getChosenColumn());

        CheckCommonGoal(currentPlayer);
        /*EndTurn(); //vanno messi qui o in un'altra classe del server?*/
    }

    public void handleDisconnection(Message message) {
        DisconnectionRequest disconnectionRequest = (DisconnectionRequest) message;
        server.sendMessage(new DisconnectionReply(disconnectionRequest.getDisconnectedUser()),message.getNickname());
    }



    /**
     * this method check if the player has reached the common goals. if he did, he receives his points, otherwise nothing
     * happens.
     * @param player the player whose library must be checked.
     */
    public void CheckCommonGoal(Player player) {

        if(game.getCommonGoal1().check(player.getBookshelf()) && !player.getPointscg1()){
            server.sendMessage(new GenericMessage("Congratulations! You reached the first common Goal! You earn "
                    + game.getCommonGoal1().getValue() + " points!"),currentPlayer.getNickname());

            player.setScore(player.getScore()+ game.getCommonGoal1().getValue());
            String newScore = String.valueOf(player.getScore());
            broadcastShowMessage(newScore);
            game.getCommonGoal1().updateValue();
            player.setPointscg1();
        }else{
            if(!player.getPointscg1())
                server.sendMessage(new GenericMessage("You haven't reached the first common goal. No points for you >:("),currentPlayer.getNickname());
        }

        if(game.getCommonGoal2().check(player.getBookshelf()) && !player.getPointscg2()){
            server.sendMessage(new GenericMessage("Congratulations! You reached the second common Goal! You earn "
                    + game.getCommonGoal2().getValue() + " points!"),currentPlayer.getNickname());
            player.setScore(player.getScore()+game.getCommonGoal2().getValue());
            String newScore = String.valueOf(player.getScore());
            broadcastShowMessage(newScore);
            game.getCommonGoal2().updateValue();
            player.setPointscg2();
        }else{
            if(!player.getPointscg2())
                server.sendMessage(new GenericMessage("You haven't reached the second common goal. No points for you >:("),currentPlayer.getNickname());
        }

        EndTurn();
    }

    public void removeTilesFromLivingRoom(Message message){
        IndexMessage indexMessage = (IndexMessage) message;
        ArrayList<Tile> chosen = indexMessage.getChosen();

        if(game.getLivingRoom().checkValid(chosen)){
            for(Tile tile : chosen){
                game.getLivingRoom().setTile(new Tile(TileType.NULL), tile.getRow(), tile.getCol());
                game.getLivingRoom().decrementNumberOfTiles();
            }
        }
    }

    /**
     * this method handles the last actions of the turn: it checks if che current player has finished his bookshelf.
     * If he has, "endGameTrigger" is called and the last round starts. If he hasn't, a new turn start with another player.
     * If it already was the round, the method check if it was the last turn
     */
    public void EndTurn() {

        if(lastRound){
            int currPlayer = players.indexOf(currentPlayer);
            if(currPlayer == players.size()-1){
                if(players.get(0).getLastPlayer()){
                    findWinner();
                    setGameState(END);
                }else{
                    server.sendMessage(new GenericMessage("Your turn ended."), currentPlayer.getNickname());
                    nextPlayer();
                    if (game.getLivingRoom().checkEmptyLivingRoom()) {
                        ArrayList<Tile> chosen = game.getBag().extract(game.numberOfTiles());
                        game.getLivingRoom().insertTiles(chosen);
                    }
                    newTurn();
                }
            }else {
                if (players.get(currPlayer + 1).getLastPlayer()) {
                    setGameState(END);
                    findWinner();
                } else {
                    server.sendMessage(new GenericMessage("Your turn ended."), currentPlayer.getNickname());
                    nextPlayer();
                    if (game.getLivingRoom().checkEmptyLivingRoom()) {
                        ArrayList<Tile> chosen = game.getBag().extract(game.numberOfTiles());
                        game.getLivingRoom().insertTiles(chosen);
                    }
                    newTurn();
                }
            }
        }else{
            if (currentPlayer.getBookshelf().fullBookshelf()) {

                for(Player player : players){
                    server.sendMessage(new GenericMessage("" + currentPlayer.getNickname() +
                            " finished his bookshelf! Last Round!"),player.getNickname());
                }

                server.sendMessage(new GenericMessage("You earn one points for finishing your " +
                        "bookshelf before the other players."), currentPlayer.getNickname());

                game.endGameTrigger(currentPlayer.getBookshelf(), currentPlayer);
                nextPlayer();
                if(game.getLivingRoom().checkEmptyLivingRoom()){
                    ArrayList<Tile> chosen = game.getBag().extract(game.numberOfTiles());
                    game.getLivingRoom().insertTiles(chosen);
                }
                lastRound(); //da rivedere
            } else {
                server.sendMessage(new GenericMessage("Your turn ended."),currentPlayer.getNickname());
                nextPlayer();
                if(game.getLivingRoom().checkEmptyLivingRoom()){
                    ArrayList<Tile> chosen = game.getBag().extract(game.numberOfTiles());
                    game.getLivingRoom().insertTiles(chosen);
                }
                newTurn(); //da rivedere
            }
        }
    }

    /**
     * beginning of the last round
     */
    public void lastRound() {
        lastRound = true;
        newTurn();
    }

    /**
     * this method tells all the player who has won the game.
     */
    public void findWinner() {
        Player winner;

        game.assignPoints(game.getPlayers());
        winner = game.getWinner();
        /*HashMap<String, Integer> ranking;

        ranking = getScoreBoard();

        for(Player player : players){
            server.sendMessage(new ScoreBoardMessage(ranking),player.getNickname());
        }*/

        for(Player player : players){
            if(player.getNickname().equals(winner.getNickname()))
                server.sendMessage(new GenericMessage("Congratulations! " +
                        "You won the game!"),player.getNickname());
            else
                server.sendMessage(new GenericMessage("You lost :( " +
                        winner.getNickname() + " won the game!"),player.getNickname());
        }

        endGame();

    }

    public void endGame(){
        if(gameState == END){
            ArrayList<Player> scoreBoard = game.getScoreBoard(game.getPlayers());
            server.broadcastMessage(new ScoreBoardMessage(scoreBoard));
            for(Player player : players){
                server.sendMessage(new DisconnectionReply(player.getNickname()), player.getNickname());
            }
        }
    }

    public void restoreMatchElements() {
        for(Player player : players){
                    server.sendMessage(new GameStateMessage(player,game),player.getNickname());
        }
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public boolean isFull(){
        if(game.getPlayers().size() == numOfPlayers)
            return true;
        else return false;
    }

    public void addVirtualView(Player player, VirtualView vv) {
        if(numOfPlayers==0){
            virtualViewMap = new HashMap<>();
        }
        virtualViewMap.put(player, vv);
        /*game.addObserver(vv);
        game.getLivingRoom().addObserver(vv);
        player.getBookshelf().addObserver(vv);*/
    }

    public void removeVirtualView(String nickname) {
        VirtualView vv = virtualViewMap.remove(nickname);
        /*game.removeObserver(vv);
        game.getLivingRoom().removeObserver(vv);
        for(Player player : players)
            if(player.getNickname().equals(nickname))
                player.getBookshelf().removeObserver(vv);*/
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Game getGame() {
        return game;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

    public Map<Player,VirtualView> getVirtualViewMap(){
        return virtualViewMap;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean waitingForPlayers(){
        if(gameState == GameState.LOGIN) return true;
        else return false;
    }

    /**
     * sends message to all the virtualView of the clients
     * @param message message to send
     */
    public void broadcastShowMessage(String message) {
        for(Player player : players){
            server.sendMessage(new GenericMessage(message),player.getNickname());
        }
    }

    public void broadcastMessage(Message message) {
        for(Player player : players){
            server.sendMessage(message,player.getNickname());
        }
    }

    /*public HashMap<String, Integer> getScoreBoard(){
        HashMap<String, Integer> scoreBoard = new HashMap<>();

        for(Player player : players){
            scoreBoard.put(player.getNickname(), player.getScore());
        }
        return scoreBoard;
    }*/

    public Player getPlayerByNickname(String nickname){
        for(Player player : players)
            if(player.getNickname().equals(nickname))
                return player;
        return null;
    }

}

