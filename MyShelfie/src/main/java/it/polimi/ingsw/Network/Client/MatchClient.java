package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * this interface will be sent to the server, enabling server to send messages to client
 */

public interface MatchClient extends Remote {

    /**
     * Sends a message from server to client
     *
     * @param message
     * @throws RemoteException
     */
    void sendMessage(Message message) throws RemoteException;


    void ping() throws RemoteException;

    /**
     * connects client to the server
     * @throws RemoteException if a communication error occurs
     */
    void connectToServer() throws RemoteException;

    /**
     * disconnects client from the server
     * @throws RemoteException if a communication error occurs
     */
    void disconnectFromServer() throws RemoteException;


    /**
     * checks if the connection is up
     * @throws RemoteException if a communication error occurs
     */
    void heartbeat() throws RemoteException;


}
