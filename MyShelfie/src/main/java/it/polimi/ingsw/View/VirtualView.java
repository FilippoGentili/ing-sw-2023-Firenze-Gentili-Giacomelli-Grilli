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

public class VirtualView implements View, Observer {

    private final Connection connection;

    public VirtualView(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void update(Message message) throws RemoteException {
        connection.sendMessage(message);
    }

    @Override
    public void nicknameRequest() throws RemoteException {
        connection.sendMessage(new LoginReply(false, true));
    }

    @Override
    public void showMessage(String message) throws RemoteException {
        connection.sendMessage(new GenericMessage(message));
    }

    @Override
    public void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException {
        connection.sendMessage(new MatchInfo(listOfPlayers, player.getNickname()));
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) throws RemoteException {
        connection.sendMessage(new LivingRoomMessage(livingRoom));
    }

    @Override
    public void showBookshelf(Player player) throws RemoteException {
        connection.sendMessage(new BookshelfMessage(player));  //BookshelfMessage da creare
    }

    @Override
    public void showCommonGoalCards(Game game) {

    }

    @Override
    public void showPersonalGoalCard(Player player) throws Exception {

    }

    @Override
    public void updateGameState(Player player, Game game) {

    }

    @Override
    public void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) throws RemoteException {
        connection.sendMessage(new WaitingRoomMessage(maxPlayers, numOfPlayersConnected));
    }

    @Override
    public void someoneDisconnected(String nickname) throws RemoteException {
        connection.sendMessage(new DisconnectionReply(nickname));
    }

    @Override
    public void askNumberOfPlayers() throws RemoteException {
        connection.sendMessage(new NumOfPlayersRequest());   //da creare
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {
        connection.sendMessage(new ColumnRequest(AvailableColumns)); //da sistemare gestione request e reply perche non coincidono
    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {
        connection.sendMessage(new ChosenTilesRequest(livingRoom));
    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException {
        connection.sendMessage(new OrderedTilesRequest(chosenTiles));
    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {
        this.connection.sendMessage(new LoginResult(nickname, validNickname, connection));
    }

    @Override
    public void showWinner(String winner) throws RemoteException {
        connection.sendMessage(new WinnerMessage(winner));
    }
}
