package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Message;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {

    private ArrayList<RMIClient> clients;
    private ArrayList<Player> players;

    public MatchServerImpl() throws RemoteException {

        clients = new ArrayList<>();
    }

    @Override
    public void connectClient(RMIClient client) throws RemoteException{
        clients.add(client);
    }

    @Override
    public void disconnectClient(RMIClient client) throws RemoteException{
        clients.remove(client);
    }

    @Override
    public void sendMessage(Message message) throws RemoteException{

    }







}
