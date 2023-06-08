package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Observer.Observer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class VirtualView implements View, Observer {

    private final Connection connection;

    public VirtualView(Connection connection){
        this.connection = connection;
    }

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
    public void startChat() {

    }

    @Override
    public void showChatMessage(ChatMessage message) {

    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns)  {
        connection.sendMessage(new ColumnRequest(AvailableColumns)); //da sistemare gestione request e reply perche non coincidono
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
    public void showWinner(String winner) {
        connection.sendMessage(new WinnerMessage(winner));
    }

    @Override
    public void handleDisconnection(String nickname) {
        connection.sendMessage(new DisconnectionReply(nickname));
        try {
            connection.disconnectClient();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
