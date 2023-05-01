package it.polimi.ingsw.Network.Client;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchClientImpl extends UnicastRemoteObject implements MatchClient {

    private final RMIClient client;
    private final RMIServer server;


    public MatchClientImpl(RMIClient client, RMIServer server) throws RemoteException {
        super();
        this.client = client;
        this.server = server;
    }


    /**
     * notifies the serer that a new client is connected
     * @throws RemoteException
     */
    @Override
    public void notifyConnection() throws RemoteException{
        server.connectClient(this);
    }

    /**
     * notifies the server that the client has left the game
     * @throws RemoteException
     */
    @Override
    public void notifyDisconnection() throws RemoteException {
        server.disconnectClient(this);
    }

    @Override
    public void notifyMessageSent(Message message) throws RemoteException {
        server.sendMessage(message);
    }
}
