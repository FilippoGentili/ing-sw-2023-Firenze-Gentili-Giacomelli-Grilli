package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Message;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {

    private ArrayList<RMIClient> clients;

    public MatchServerImpl() throws RemoteException {
        super();
        clients = new ArrayList<>();
    }

    /**
     * Implementation of the connection of the client
     * @param client that will be connected
     * @throws RemoteException
     */
    @Override
    public void connectClient(RMIClient client) throws RemoteException{
        clients.add(client);
    }

    /**
     * Implementation of the disconnection of the client
     * @param client that will be disconnected
     * @throws RemoteException
     */
    @Override
    public void disconnectClient(RMIClient client) throws RemoteException{
        clients.remove(client);
    }

    /**
     * Implementation of the sending of the message
     * @param message that the server sends to the client
     * @throws RemoteException
     */
    @Override
    public void sendMessage(Message message) throws RemoteException{
        for(MatchClient client: clients)
            client.notifyMessageSent(message);
    }

}
