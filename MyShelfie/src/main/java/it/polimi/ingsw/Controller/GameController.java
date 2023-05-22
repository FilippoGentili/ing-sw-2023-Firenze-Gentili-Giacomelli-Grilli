package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.GameState;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.VirtualView;

import java.rmi.RemoteException;
import java.util.*;

import static it.polimi.ingsw.Model.Game.endGameTrigger;
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

    /**
     * constructor
     */
    public GameController(Server server){
        this.game = new Game();
        this.server = server;
        this.players = new ArrayList<>();
        //this.numOfPlayers = num;
        this.inputController = new InputController(this, virtualViewMap);
        setGameState(LOGIN);
        //virtualViewMap = new HashMap<>();
    }

    /**
     * this method receives the message from the client and decides what method must be called based on
     * the actual state of the game
     * @param message
     * @throws RemoteException
     */
    public void forwardMessage(Message message) throws RemoteException {

        switch (gameState) {
            case LOGIN:
                if(message.getMessageType()==MessageType.NUM_OF_PLAYERS_REPLY) {
                    setNumOfPlayers(message);
                    server.sendMessage(new GenericMessage("The number of players is set. Now wait for other players to connect!"),message.getNickname());
                    restoreMatchElements();
                }else {
                    Server.LOGGER.severe("Message from the client is not the number of players");
                }
                break;
            case PLAY:
                handleGame(message);
                break;
        }
    }

    /**
     * this method decides if a client who wants to play the game can be admitted or not. If he is the first player,
     * this method asks what is the number of players.
     * @param nickname nickname of the player
     * @param vv virtual view of the player
     * @throws RemoteException
     */
    public void handleLogin(String nickname, VirtualView vv) throws RemoteException {
        Player player = new Player();

        if(numOfPlayers==0){
            addVirtualView(player, vv);
            players.add(player);
            player.setNickname(nickname);
            game.addPlayer(player);
            server.sendMessage(new LoginResult(nickname,true,true),nickname);
            server.sendMessage(new NumOfPlayersRequest(), nickname);
        }else if(virtualViewMap.size() < numOfPlayers){
            if (inputController.checkNickname(nickname, vv)) {
                addVirtualView(player, vv);
                players.add(player);
                player.setNickname(nickname);
                game.addPlayer(player);
                server.sendMessage(new LoginResult(nickname,true,true),nickname);

                if(virtualViewMap.size() == numOfPlayers)
                    startGame();
            } else
                vv.loginResult(false, true, nickname);
        }else if(virtualViewMap.size()==numOfPlayers){
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
    public void handleGame(Message message) throws RemoteException {

        switch (message.getMessageType()){
            case CHOSEN_TILES_REPLY:
                chooseTiles(message);
                break;
            case COLUMN_REPLY:
                SelectedColumn(message);
                break;
            case ORDERED_TILES_REPLY:
                InsertTiles(message);
        }
    }

    public void startGame() throws RemoteException {
        setGameState(PLAY);
        game.initializeLivingRoom();
        currentPlayer = game.pickFirstPlayer();
        firstPlayer = currentPlayer;
        broadcastShowMessage("Game started!");
        newTurn();
    }

    public void setNumOfPlayers(Message message){
        NumOfPlayersReply numOfPlayersReply = (NumOfPlayersReply) message;
        int num = numOfPlayersReply.getNumOfPlayers();
        this.numOfPlayers = num;
    }

    /**
     * This method set the currentPlayer who is going play the turn
     */
    public void nextPlayer(){
        int indexPlayer = players.indexOf(currentPlayer);

        if(indexPlayer+1 < players.size())
            currentPlayer = players.get(indexPlayer + 1);
        else
            currentPlayer = players.get(0);

        setCurrentPlayer(currentPlayer);
    }

    /**
     * this method initializes a new turn.
     */
    public void newTurn() throws RemoteException {
        //yourTurn(gameController.getCurrentPlayer());
        if(firstTurn){
            firstTurn = false;
        }else{
            nextPlayer();
        }
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
    public void chooseTiles(Message message) throws RemoteException {
        ChosenTilesReply chosenTilesMessage = (ChosenTilesReply) message;
        ArrayList<Tile> chosen = chosenTilesMessage.getChosenTiles();

        if(inputController.livingRoomChosenTiles(chosenTilesMessage)){
            ArrayList<Tile> TemporaryChosenTiles = new ArrayList<>();

            for(int i=0; i<chosen.size(); i++)
                TemporaryChosenTiles.add(chosen.get(i));

            currentPlayer.setChosenTiles(TemporaryChosenTiles);
            ArrayList<Integer> availableColumns = new ArrayList<>();
            availableColumns = currentPlayer.getBookshelf().getFreeColumns(chosen.size());

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
    public void SelectedColumn(Message message) throws RemoteException {
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
    public void InsertTiles(Message message) throws RemoteException {
        OrderedTilesReply orderedTilesReply = (OrderedTilesReply) message;
        ArrayList<Tile> chosenTiles = orderedTilesReply.getOrderedTiles();

        currentPlayer.InsertTiles(chosenTiles, currentPlayer.getChosenColumn());

        CheckCommonGoal(currentPlayer);
        /*EndTurn(); //vanno messi qui o in un'altra classe del server?*/
    }

    /**
     * this method check if the player has reached the common goals. if he did, he receives his points, otherwise nothing
     * happens.
     * @param player the player whose library must be checked.
     */
    public void CheckCommonGoal(Player player) throws RemoteException {

        if(game.getCommonGoal1().check(player.getBookshelf()) && !player.getPointscg1()){
            server.sendMessage(new GenericMessage("Congratulations! You reached the first common Goal! You earn "
                    + game.getCommonGoal1().getValue() + " points!"),currentPlayer.getNickname());

            player.setScore(player.getScore()+ Game.getCommonGoal1().getValue());
            String newScore = String.valueOf(player.getScore());
            broadcastShowMessage(newScore);
            Game.getCommonGoal1().updateValue();
            player.setPointscg1();
        }

        if(game.getCommonGoal2().check(player.getBookshelf()) && !player.getPointscg2()){
            server.sendMessage(new GenericMessage("Congratulations! You reached the second common Goal! You earn "
                    + game.getCommonGoal1().getValue() + " points!"),currentPlayer.getNickname());
            player.setScore(player.getScore()+Game.getCommonGoal2().getValue());
            String newScore = String.valueOf(player.getScore());
            broadcastShowMessage(newScore);
            Game.getCommonGoal2().updateValue();
            player.setPointscg2();
        }

        EndTurn();
    }

    /**
     * this method handles the last actions of the turn: it checks if che current player has finished his bookshelf.
     * If he has, "endGameTrigger" is called and the last round starts. If he hasn't, a new turn start with another player.
     * If it already was the round, the method check if it was the last turn
     */
    public void EndTurn() throws RemoteException {

        if(lastRound){
            int currPlayer = players.indexOf(currentPlayer);
            if(players.get(currPlayer+1).getLastPlayer()) {
                findWinner();
            }else{
                server.sendMessage(new GenericMessage("Your turn ended."),currentPlayer.getNickname());
                nextPlayer();
                restoreMatchElements();
                newTurn();
            }
        }else{
            if (currentPlayer.getBookshelf().fullBookshelf()) {

                for(Player player : players){
                    server.sendMessage(new GenericMessage("" + currentPlayer.getNickname() +
                            " finished his bookshelf! Last Round!"),player.getNickname());
                }

                server.sendMessage(new GenericMessage("You earn one points for finishing your " +
                        "bookshelf before the other players."), currentPlayer.getNickname());

                endGameTrigger(currentPlayer.getBookshelf(), currentPlayer);
                restoreMatchElements();
                lastRound(); //da rivedere
            } else {
                server.sendMessage(new GenericMessage("Your turn ended."),currentPlayer.getNickname());
                nextPlayer();
                restoreMatchElements();
                newTurn(); //da rivedere
            }
        }
    }

    /**
     * beginning of the last round
     */
    public void lastRound() throws RemoteException {
        lastRound = true;
        newTurn();
    }

    /**
     * this method tells all the player who has won the game.
     */
    public void findWinner() throws RemoteException {
        Player winner = new Player();

        winner = game.getWinner();

        for(Player player : players){
            if(player.getNickname().equals(winner.getNickname()))
                server.sendMessage(new GenericMessage("Congratulations! " +
                        "You won the game!"),player.getNickname());
            else
                server.sendMessage(new GenericMessage("You lost :( " +
                        winner.getNickname() + " won the game!"),player.getNickname());
        }

        setGameState(END);
    }

    public void restoreMatchElements() throws RemoteException {
        for(Player player : players){
            server.sendMessage(new LivingRoomMessage(game.getLivingRoom()),player.getNickname());
            for(Player otherPlayer : players){
                if(!otherPlayer.equals(player))
                    server.sendMessage(new GameStateMessage(otherPlayer,game),player.getNickname());
            }
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

    public void addVirtualView(Player player, VirtualView vv){
        if(numOfPlayers==0){
            virtualViewMap = new HashMap<>();
        }
        virtualViewMap.put(player, vv);
        game.addObserver(vv);
        game.getLivingRoom().addObserver(vv);
        player.getBookshelf().addObserver(vv);
    }

    public void removeVirtualView(String nickname){
        VirtualView vv = virtualViewMap.remove(nickname);
        game.removeObserver(vv);
        game.getLivingRoom().removeObserver(vv);
        for(Player player : players)
            if(player.getNickname().equals(nickname))
                player.getBookshelf().removeObserver(vv);
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
    public void broadcastShowMessage(String message) throws RemoteException {
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

}

