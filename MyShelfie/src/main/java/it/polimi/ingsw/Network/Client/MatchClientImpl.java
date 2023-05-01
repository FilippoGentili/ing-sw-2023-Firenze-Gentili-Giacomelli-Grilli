package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Message.Message;
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
     * method called by the server to notify updates in the game
     * @param message
     * @throws RemoteException
     */
    @Override
    public void update(Message message) throws RemoteException {
        client.update(message);
    }

    /**
     * method called by the server to notify updates in the game and it is necessery to update the view
     * @param state of the player
     * @throws RemoteException
     */
    @Override
    public void updateState(State state) throws RemoteException {
        client.updateState(state);
    }

    /**
     * notifies the serer that a new client is connected
     * @throws RemoteException
     */
    public void notifyConnection() throws RemoteException{
        server.addClient(this);
    }

    /**
     * notifies the server that the client has left the game
     * @throws RemoteException
     */
    @Override
    public void notifyDisconnection() throws RemoteException {
        server.removeClient(this);
    }


    /**
     * notifies the client that the game has started
     * @throws RemoteException
     */
    @Override
    public void notifyGameStarted() throws RemoteException{

    }

    /**
     * notifies that the client has selected tiles
     * @param row
     * @param col
     * @throws RemoteException
     */
    @Override
    public void notifyTileSelected(int row, int col) throws RemoteException{

    }

    /**
     * notifies that the state of the client has been updated
     * @param state
     * @throws RemoteException
     */
    @Override
    public void notifyStateUpdate(State state) throws RemoteException{

    }

    /**
     * notifies the client that the game is over
     * @param winner
     * @throws RemoteException
     */
    @Override
    public void notifyGameOver(String winner) throws RemoteException {

    }
}
