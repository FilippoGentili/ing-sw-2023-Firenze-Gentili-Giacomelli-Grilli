package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchClientImpl extends UnicastRemoteObject implements MatchClient {

    private final RMIClient client;

    public MatchClientImpl(RMIClient client) throws RemoteException {
        super();
        this.client = client;
    }

    @Override
    public void update(Message message) throws RemoteException {
        client.update(message);
    }

    @Override
    public void updateState(State state) throws RemoteException {
        client.updateState(state);
    }

    @Override
    public void notifyDisconnection() throws RemoteException {
        client.notifyDisconnection();
    }

    @Override
    public void notifyPlayerAdded(Player player) throws RemoteException{

    }

    @Override
    public void notifyPlayerRemoved(Player player) throws RemoteException{

    }

    @Override
    public void notifyGameStarted() throws RemoteException{

    }

    @Override
    public void notifyTileSelected(int row, int col) throws RemoteException{

    }

    @Override
    public void notifyStateUpdate(State state) throws RemoteException{

    }

    @Override
    public void notifyGameOver(String winner) throws RemoteException {

    }
}
