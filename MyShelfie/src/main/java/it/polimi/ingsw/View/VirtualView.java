package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Observer.Observer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class VirtualView implements View, Observer {

    private final MatchServer matchServer;

    public VirtualView(MatchServer matchServer){
        this.matchServer = matchServer;
    }

    public MatchServer getMatchServer() {
        return matchServer;
    }

    @Override
    public void update(Message message) throws RemoteException {
        matchServer.sendMessage(message);
    }

    @Override
    public void nicknameRequest() throws RemoteException {
        matchServer.sendMessage(new LoginReply(false, true));
    }

    @Override
    public void showMessage(String message) throws RemoteException {
        matchServer.sendMessage(new GenericMessage(message));
    }

    @Override
    public void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException {
        matchServer.sendMessage(new MatchInfo(listOfPlayers, player.getNickname()));
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) throws RemoteException {
        matchServer.sendMessage(new LivingRoomMessage(livingRoom));
    }

    @Override
    public void showBookshelf(Player player) throws RemoteException {
        matchServer.sendMessage(new BookshelfMessage(player));  //BookshelfMessage da creare
    }

    @Override
    public void showCommonGoalCards(Game game) {

    }

    @Override
    public void showPersonalGoalCard(Player player) throws Exception {

    }

    @Override
    public void someoneDisconnected(String nickname) throws RemoteException {
        matchServer.sendMessage(new DisconnectionReply(nickname));
    }

    @Override
    public void askNumberOfPlayers() throws RemoteException {
        matchServer.sendMessage(new NumOfPlayersRequest());   //da creare
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {
        matchServer.sendMessage(new ColumnRequest(AvailableColumns)); //da sistemare gestione request e reply perche non coincidono
    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {
        matchServer.sendMessage(new ChosenTilesRequest(livingRoom));
    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException {
        matchServer.sendMessage(new OrderedTilesRequest(chosenTiles));
    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {
        matchServer.sendMessage(new LoginResult(nickname, validNickname, connection));
    }
}
