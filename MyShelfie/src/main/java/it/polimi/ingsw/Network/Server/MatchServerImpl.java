package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import javax.management.remote.rmi.RMIConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {
    private static final long serialVersionUID = -8871984387622564437L;
    private final transient Server server;
    private ArrayList<Client>

    MatchServerImpl(Server server) throws RemoteException{
        this.server = server;
    }
    @Override
    public void connectClient(Client client) throws RemoteException {

    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        server.sendMessage(message);
    }

    @Override
    public void disconnectClient() throws RemoteException {
    }
}
