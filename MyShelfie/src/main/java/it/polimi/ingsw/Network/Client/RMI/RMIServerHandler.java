package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerHandler extends Remote {
    void sendMessage(Message message) throws RemoteException;
    void disconnect() throws RemoteException;
}
