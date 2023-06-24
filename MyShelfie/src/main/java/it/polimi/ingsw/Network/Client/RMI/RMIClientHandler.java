package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used to allow the server to send message to the client
 */

public interface RMIClientHandler extends Remote {
    /**
     * Receives messages from the server and adds them to the client message queue
     * @param message received from the client
     * @throws RemoteException
     */
    void receiveMessage(Message message) throws RemoteException;

    /**
     * Handles disconnection of the rmi client
     * @throws RemoteException
     */
    void disconnectMe() throws RemoteException;

    /**
     * A timer checks the state of the connection
     * @throws RemoteException
     */
    void ping() throws RemoteException;
}
