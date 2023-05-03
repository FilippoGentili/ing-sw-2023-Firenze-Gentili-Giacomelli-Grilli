package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface of the server which will be used
 * by the client. Methods which are invoked by the client
 */

public interface MatchServer extends Remote {

    /**
     * connects the client to the server
     * @param client that will be connected
     * @throws RemoteException if a communication error occurs
     */
    void connectClient(RMIClient client) throws RemoteException;

    /**
     * Disconnects the client from the server
     * @param client that will be disconnected
     * @throws RemoteException if a communication error occurs
     */
    void disconnectClient(RMIClient client) throws RemoteException;

    /**
     * Sends a message to the client
     * @param message that the server sends to the client
     * @throws RemoteException if a communication error occurs
     */
    void sendMessage(Message message) throws RemoteException;

    /**
     * method used to receive messages from the clients
     * @param message sent from client
     * @throws RemoteException if a communication error occurs
     */
    void getMessage(Message message) throws RemoteException;
}