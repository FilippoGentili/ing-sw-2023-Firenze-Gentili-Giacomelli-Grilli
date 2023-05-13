package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

public class RMIClientHandlerImpl extends UnicastRemoteObject implements RMIClientHandler {


    protected RMIClientHandlerImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        switch (message.getMessageType()){
            case LOGIN_REQUEST:
                break;
            case NUM_OF_PLAYERS_REPLY:
                break;
            case CHOSEN_TILES_REPLY:
                break;
            case COLUMN_REPLY:
                break;
            case ORDERED_TILES_REPLY:
                break;
        }
    }

    @Override
    public void disconnectClient() throws RemoteException {

    }

    @Override
    public void showMessage(String message) throws RemoteException {

    }
    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {

    }

    @Override
    public void nicknameRequest() throws RemoteException {
    }

    @Override
    public void askNumberOfPlayers() throws RemoteException {

    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {

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
