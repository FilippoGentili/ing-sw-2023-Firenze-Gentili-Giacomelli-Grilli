package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIClientHandlerImpl extends UnicastRemoteObject implements RMIClientHandler {


    protected RMIClientHandlerImpl() throws RemoteException {
        super();
    }

    @Override
    public void showMessage(String message) throws RemoteException {

    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {

    }

    @Override
    public void nicknameRequest() throws RemoteException {
        System.out.println("Insert your nickname:");
    }

    @Override
    public void askNumberOfPlayers() throws RemoteException {

    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {

    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException {

    }

    @Override
    public void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException {

    }

    @Override
    public void someoneDisconnected(String nickname) throws RemoteException {

    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void showBookshelf(Player player) throws RemoteException {

    }

    @Override
    public void showCommonGoalCards(Game game) throws RemoteException{

    }

    @Override
    public void showPersonalGoalCard(Player player) throws Exception {

    }
}
