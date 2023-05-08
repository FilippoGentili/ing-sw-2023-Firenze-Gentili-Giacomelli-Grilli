package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import javax.management.remote.rmi.RMIConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {
    private final transient Server server;
    private transient RMIConnection rmiSession;

    MatchServerImpl(Server server) throws RemoteException{
        this.server = server;
    }
    @Override
    public void connect(String username, RMIClient client) throws RemoteException {
        rmiSession
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        server.onMessage(message);
    }

    @Override
    public void disconnect() throws RemoteException {

    }
}
