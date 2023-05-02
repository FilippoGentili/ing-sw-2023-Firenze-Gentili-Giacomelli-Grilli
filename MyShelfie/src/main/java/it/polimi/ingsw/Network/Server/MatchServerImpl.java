package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {

    private ArrayList<RMIClient> clients;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public MatchServerImpl() throws RemoteException {
        super();
        clients = new ArrayList<>();
        try {
            this.output = new ObjectOutputStream(clients.getOutputStream());
            this.input = new ObjectInputStream(clients.getInputStream());
        }catch (IOException e){
            //qualcosa
        }

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
     * Implementation of the method that sends the message to the client
     * @param message that the server sends to the client
     * @throws RemoteException
     */
    @Override
    public void sendMessage(Message message) throws RemoteException{
        for(MatchClient client: clients)
            client.getMessage(message);
    }

    /**
     * Implementation of the method that gets the message from the client
     * @param message sent from client
     * @throws RemoteException
     */
    @Override
    public void getMessage(Message message) throws  RemoteException{

    }

}
