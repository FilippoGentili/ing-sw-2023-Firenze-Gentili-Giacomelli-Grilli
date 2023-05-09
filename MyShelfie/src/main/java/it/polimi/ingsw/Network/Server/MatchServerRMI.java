package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerRMI extends UnicastRemoteObject implements MatchServer {
    private static final long serialVersionUID = -8871984387622564437L;
    private final transient Server server;

    private ArrayList<Client> listOfClients = new ArrayList<>();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean connected;


    public MatchServerRMI(Server server) throws RemoteException{
        this.server = server;
        this.connected = true;
    }

    public void connectClient(Client client) throws RemoteException {
        listOfClients.add(client);
    }

    @Override
    public boolean checkConnection() throws RemoteException {
        return connected;
    }

    @Override
    public void disconnectClient(Client client) throws RemoteException {
        listOfClients.remove(client);
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {

    }

}
