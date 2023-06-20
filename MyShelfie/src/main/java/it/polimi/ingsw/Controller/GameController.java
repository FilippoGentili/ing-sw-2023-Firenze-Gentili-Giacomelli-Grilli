package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Persistence.GameSaved;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.VirtualView;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;

import static it.polimi.ingsw.Model.GameState.*;

public class GameController implements Serializable {

    private static final long serialVersionUID = -4469014821443887480L;
    private final Game game;
    private GameState gameState;
    private  int numOfPlayers;
    private Player currentPlayer;
    private Player firstPlayer;
    private final transient InputController inputController;
    private ArrayList<Player> players;
    private transient Map<Player, VirtualView> virtualViewMap;
    private final transient Server server;
    private boolean lastRound = false;
    private boolean firstTurn = true;
    private boolean firstLogin = true;
    private ArrayList<String> returnPlayers = new ArrayList<>();
    private Message lastMessage;


    /**
     * constructor use to create a new game
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
     * this constructor is called when a saved game must be reloaded
     */
    public GameController(Server server, GameController savedGameController) {
        this.game = savedGameController.getGame();
        this.gameState = savedGameController.getGameState();
        this.numOfPlayers = savedGameController.getNumOfPlayers();
        this.currentPlayer = savedGameController.getCurrentPlayer();
        this.firstPlayer = savedGameController.getFirstPlayer();
        this.inputController = new InputController(this, server);
        this.players = savedGameController.getPlayers();
        this.virtualViewMap = savedGameController.getVirtualViewMap();
        this.lastRound = savedGameController.isLastRound();
        this.firstTurn = savedGameController.isFirstTurn();
        this.firstLogin = savedGameController.isFirstLogin();
        this.lastMessage = savedGameController.getLastMessage();
        this.server = server;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public Player getFirstPlayer(){
        return firstPlayer;
    }

    public boolean isLastRound(){
        return lastRound;
    }

    public boolean isFirstTurn(){
        return firstTurn;
    }

    public boolean isFirstLogin(){
        return firstLogin;
    }

    /**
     * this method receives the message from the client and decides what method must be called based on
     * the actual state of the game
     * @param message
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
                    server.sendMessage(new StartingChatMessage(),message.getNickname());
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
     */
    public synchronized void handleLogin(String nickname, VirtualView vv) throws InterruptedException {
        Player player = new Player(this.game);

        if (numOfPlayers == 0) {
            if(!firstLogin) {
                server.sendMessage(new LoginResult(nickname,false,false),nickname);
                handleDisconnection(new DisconnectionRequest(nickname));
            }else {
                firstLogin = false;
                addVirtualView(player, vv);
                players.add(player);
                player.setNickname(nickname);
                game.addPlayer(player);
                server.sendMessage(new LoginResult(nickname, true, true), nickname);
                server.sendMessage(new NumOfPlayersRequest(), nickname);
                server.sendMessage(new LoginReply(nickname), nickname);
            }
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
                server.sendMessage(new StartingChatMessage(),nickname);

                if (virtualViewMap.size() == numOfPlayers)
                    startGame();
            } else
                server.sendMessage(new LoginResult(nickname,false,true),nickname);
        } else if (virtualViewMap.size() == numOfPlayers) {
            server.sendMessage(new LoginResult(nickname,true,false),nickname);
            handleDisconnection(new DisconnectionRequest(nickname));
        }
    }

    /**
     * this method is called when the game is already started and a message from the client arrives. It decides what
     * method must be called based on the type of the message.
     */
    public void handleGame(Message message) {

        lastMessage = message;
        GameSaved.saveGame(this);

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
        this.numOfPlayers = numOfPlayersReply.getNumOfPlayers();
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
        if(firstTurn){
            firstTurn = false;
        }

        ArrayList<Player> scoreBoard = game.getScoreBoard(game.getPlayers());
        server.broadcastMessage(new ScoreBoardMessage(scoreBoard));

        restoreMatchElements();

        for(Player player : players){
            if(!player.equals(currentPlayer))
                server.sendMessage(new GenericMessage("It's the turn of " + currentPlayer.getNickname()),player.getNickname());
            else {
                server.sendMessage(new GenericMessage("It's your turn, " + currentPlayer.getNickname() + "!"), player.getNickname());
                server.broadcastMessage((new TurnMessage(player, MessageType.Turn_Message)));
            }
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
            removeTilesFromLivingRoom(message);
            ArrayList<Tile> TemporaryChosenTiles = new ArrayList<>();

            TemporaryChosenTiles.addAll(chosen);

            currentPlayer.setChosenTiles(TemporaryChosenTiles);
            ArrayList<Integer> availableColumns = currentPlayer.getBookshelf().getFreeColumns(chosen.size());

            server.sendMessage(new ColumnRequest(availableColumns, currentPlayer),currentPlayer.getNickname());
        }else{
            server.sendMessage(new ChosenTilesRequest(game.getLivingRoom()),currentPlayer.getNickname());
        }
    }

    /**
     * this method checks if the column chosen by the client is valid. If it's not, it asks the user to select another
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

            server.sendMessage(new ColumnRequest(availableColumns, currentPlayer),currentPlayer.getNickname());
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
        players.remove(getPlayerByNickname(message.getNickname()));
        game.removePlayer(getPlayerByNickname(message.getNickname()));
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
            server.sendMessage(new UpdateGuiPointsMessage(game), currentPlayer.getNickname());
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
            server.sendMessage(new UpdateGuiPointsMessage(game), currentPlayer.getNickname());
            player.setPointscg2();
        }else{
            if(!player.getPointscg2())
                server.sendMessage(new GenericMessage("You haven't reached the second common goal. No points for you >:("),currentPlayer.getNickname());
        }

        EndTurn();
    }

    public void removeTilesFromLivingRoom(Message message){
        ChosenTilesReply indexMessage = (ChosenTilesReply) message;
        ArrayList<Tile> chosen = indexMessage.getChosenTiles();

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
            lastRound();
        }else{
            if (currentPlayer.getBookshelf().fullBookshelf()) {

                server.sendMessage(new GenericMessage("You earn one points for finishing your " +
                        "bookshelf before the other players."), currentPlayer.getNickname());

                for(Player player : players){
                    server.sendMessage(new GenericMessage("" + currentPlayer.getNickname() +
                            " finished his bookshelf! Last Round!"),player.getNickname());
                }

                game.endGameTrigger(currentPlayer.getBookshelf(), currentPlayer);
                lastRound();

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
        if(!lastRound) lastRound = true;

        int currPlayer = players.indexOf(currentPlayer);
        if(currPlayer == players.size()-1){
            if(players.get(0).equals(firstPlayer)){
                setGameState(END);
                findWinner();
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
            if (players.get(currPlayer + 1).equals(firstPlayer)) {
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
    }

    /**
     * this method tells all the player who has won the game.
     */
    public void findWinner() {
        Player winner;

        restoreMatchElements();
        game.assignPoints(game.getPlayers());
        winner = game.getWinner();

        ArrayList<Player> scoreBoard = game.getScoreBoard(game.getPlayers());
        server.broadcastMessage(new ScoreBoardMessage(scoreBoard));
        server.broadcastMessage(new WinnerMessage(winner.getNickname(), game));


        for(Player player : players){
            if(player.getNickname().equals(winner.getNickname())) {
                server.sendMessage(new GenericMessage("Congratulations! " + "You won the game!"), player.getNickname());
            }else {
                server.sendMessage(new GenericMessage("You lost :( " + winner.getNickname() + " won the game!"), player.getNickname());
            }
            System.out.println("Write 'exit' to leave the game.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            while(!input.equalsIgnoreCase("exit")) {
                System.out.println("Invalid statement!");
                input = scanner.nextLine().trim();
            }
            if(input.equalsIgnoreCase("exit")) {
                endGame(player);
            }
        }
    }

    public void endGame(Player player){
        if(gameState == END){
                server.sendMessage(new DisconnectionReply(player.getNickname()), player.getNickname());
        }
    }

    public void restoreMatchElements() {
        for(Player player : players){
                    server.sendMessage(new GameStateMessage(player,game),player.getNickname());
        }
    }

    public void addVirtualView(Player player, VirtualView vv) {
        if(numOfPlayers==0){
            virtualViewMap = new HashMap<>();
        }
        virtualViewMap.put(player, vv);
    }

    public void removeVirtualView(String nickname) {
        virtualViewMap.remove(getPlayerByNickname(nickname));
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

    public boolean waitingForPlayers(){
        if(gameState == GameState.LOGIN) return true;
        else return false;
    }

    /**
     * sends message to all the clients
     * @param message message to send
     */
    public void broadcastShowMessage(String message) {
        for(Player player : players){
            server.sendMessage(new GenericMessage(message),player.getNickname());
        }
    }

    public Player getPlayerByNickname(String nickname){
        for(Player player : players)
            if(player.getNickname().equals(nickname))
                return player;
        return null;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Message getLastMessage(){
        return lastMessage;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void addingPlayersAgain(String username){
        returnPlayers.add(username);

        if(returnPlayers.size() == players.size()) {
            restoreMatchElements();
            Server.LOGGER.log(Level.INFO, "{0}", new Object[]{game.getLivingRoom()});
            handleGame(lastMessage);
        }
    }

    public ArrayList<String> getReturnPlayers(){
        return returnPlayers;
    }

}

