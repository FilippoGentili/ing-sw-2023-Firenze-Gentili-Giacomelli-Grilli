package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface of the client which will be used
 * by server. Methods which are invoked by the client
 */

public interface MatchServer extends Remote {

/**
 * connects the client to the server
 *
 */
    void connectClient(RMIClient client) throws RemoteException;

    /**
     * Disconnects the client from the server
     */
    void disconnectClient(RMIClient client) throws RemoteException;

    /**
     * Sends a message to the client
     * @param message that the server sends to the client
     */
    void sendMessage(Message message) throws RemoteException;

    /**
     * @param message sent from client
     */
    void getMessage(Message message) throws RemoteException;
}
