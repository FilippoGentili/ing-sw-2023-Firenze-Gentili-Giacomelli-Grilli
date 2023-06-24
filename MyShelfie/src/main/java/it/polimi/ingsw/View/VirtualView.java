package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Observer.Observer;

import java.io.Serial;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class VirtualView implements View, Observer, Serializable {

    @Serial
    private static final long serialVersionUID = -1283988823487689171L;
    private final Connection connection;

    /**
     * Constructor of virtual view
     * @param connection chosen by the client
     */
    public VirtualView(Connection connection){
        this.connection = connection;
    }

    /**
     * @return type of connection
     */
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void update(Message message) {
        connection.sendMessage(message);
    }

    @Override
    public void nicknameRequest() {

    }

    @Override
    public Chat getChat() {
        return null;
    }

    @Override
    public void showMessage(String message) {
        connection.sendMessage(new GenericMessage(message));
    }

    @Override
    public void showScoreboard(ArrayList<Player> scoreboard) {
        connection.sendMessage(new ScoreBoardMessage(scoreboard));
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom)  {
        connection.sendMessage(new LivingRoomMessage(livingRoom));
    }

    @Override
    public void showBookshelf(Player player)  {
        connection.sendMessage(new BookshelfMessage(player));
    }

    @Override
    public void showCommonGoalCards(Game game) {

    }

    @Override
    public void showPersonalGoalCard(Player player) {

    }


    @Override
    public void updateGameState(Player player, Game game)  {
        connection.sendMessage(new GameStateMessage(player, game));
    }

    @Override
    public void showGameStarted(Game game) {
        connection.sendMessage(new GameStartedMessage(game));
    }


    @Override
    public void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) {
        connection.sendMessage(new WaitingRoomMessage(maxPlayers, numOfPlayersConnected));
    }

    @Override
    public void someoneDisconnected(String nickname)  {
        connection.sendMessage(new DisconnectionReply(nickname));
    }

    @Override
    public void askNumberOfPlayers() {
        connection.sendMessage(new NumOfPlayersRequest());   //da creare
    }

    @Override
    public void showChatMessages(Chat chat) {
        connection.sendMessage(new GenericMessage("ciao"));
    }

    /*@Override
    public void sendChatMessage(String sender, String receiver, String message){

    }*/
    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns, Player player)  {
        connection.sendMessage(new ColumnRequest(AvailableColumns, player)); //da sistemare gestione request e reply perche non coincidono
    }

    @Override
    public void TilesRequest(LivingRoom livingRoom)  {
        connection.sendMessage(new ChosenTilesRequest(livingRoom));
    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles)  {
        connection.sendMessage(new OrderedTilesRequest(chosenTiles));
    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) {
        this.connection.sendMessage(new LoginResult(nickname, validNickname, connection));
    }

    @Override
    public void showWinner(String winner, Game game) {
        connection.sendMessage(new WinnerMessage(winner, game));
    }

    @Override
    public void handleDisconnection() {

    }

    public void handleDisconnection(String nickname) {
        connection.sendMessage(new DisconnectionReply(nickname));
        try {
            connection.disconnectClient();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateGuiCommonGoalCardPoints(Game game, int previousPoints1, int previousPoints2){
    }

    @Override
    public void endGame(ArrayList<Player> scoreboard, String winner) {

    }

    @Override
    public void turnDisplay(Player player) {
    }

    @Override
    public void welcomeBack(String nickname) {

    }
}
