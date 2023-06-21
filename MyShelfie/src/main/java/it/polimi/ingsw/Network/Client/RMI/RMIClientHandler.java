package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used to allow the server to send message to the client
 */

public interface RMIClientHandler extends Remote {

    void receiveMessage(Message message) throws RemoteException;

    void disconnectMe() throws RemoteException;

    void ping() throws RemoteException;
}
