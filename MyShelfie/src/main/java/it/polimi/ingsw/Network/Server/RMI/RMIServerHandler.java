package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerHandler extends Remote {

    /**
     * this method sends a message to the server
     * @param message
     * @throws RemoteException
     */
    void receiveMessage(Message message) throws RemoteException;
}
