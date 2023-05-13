package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.NumOfPlayersReply;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;

public class RMIClientHandlerImpl extends UnicastRemoteObject implements RMIClientHandler {
    private final transient RMIServer server;

    protected RMIClientHandlerImpl(RMIServer server) throws RemoteException {
        super();
        this.server = server;
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        switch (message.getMessageType()) {
            case LOGIN_REQUEST:
                break;
            case NUM_OF_PLAYERS_REPLY:
                updateNumberOfPlayers(message);
                break;
            case CHOSEN_TILES_REPLY:
                updateChosenTiles(message);
                break;
            case COLUMN_REPLY:
                updateChosenColumn(message);
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

    public void updateNumberOfPlayers(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    @Override
    public void updateChosenTiles(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    @Override
    public void updateChosenColumn(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    @Override
    public void updateOrderedTiles(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

}
