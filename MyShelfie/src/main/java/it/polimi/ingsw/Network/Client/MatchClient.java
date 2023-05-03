package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchClient extends Remote {

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
     * sends message from client to the server
     * @param message that will be sent
     * @throws RemoteException if a communication error occurs
     */
    void sendMessage(Message message) throws RemoteException;

    /**
     * receive message from the server
     * @param message that is received
     * @throws RemoteException if a communication error occurs
     */
    void getMessage(Message message) throws RemoteException;
}
