package it.polimi.ingsw.Network.Client;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchClientImpl extends UnicastRemoteObject implements MatchClient {

    private final RMIClient client;
    private final RMIServer server;
    private ObjectInputStream input;
    private ObjectOutputStream output;

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
    public void connectToServer() throws RemoteException{
        server.connectClient(this);
    }

    /**
     * notifies the server that the client has left the game
     * @throws RemoteException
     */
    @Override
    public void disconnectFromServer() throws RemoteException {
        server.disconnectClient(this);
    }

    /**
     * Implementation of the method that sends the message to the server
     * @param message that the client sends
     * @throws RemoteException
     */
    @Override
    public void sendMessage(Message message) throws RemoteException {
    }

    /**
     * Implementation of the method that gets the message from the server
     * @param message that the client sends
     * @throws RemoteException
     */
    @Override
    public void getMessage(Message message) throws RemoteException {
        server.sendMessage(message);

    }
}
