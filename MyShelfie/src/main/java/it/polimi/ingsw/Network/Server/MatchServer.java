package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Message;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface of the client which will be used
 * by server. Methods which are invoked by the client
 */

public interface MatchServer extends Remote {

/**
 * Returns the connection status.
 *
 * @return true if the client is still connected
 */
    void connectClient(RMIClient client) throws RemoteException;

    /**
     * Disconnects from the client
     */
    void disconnectClient(RMIClient client) throws RemoteException;

    /**
     * Sends a message to the client
     *
     * @param message
     */
    void sendMessage(Message message) throws RemoteException;
}
