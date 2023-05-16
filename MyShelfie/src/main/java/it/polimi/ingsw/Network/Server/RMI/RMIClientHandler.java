package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClientHandler extends Remote {
    void sendMessage(Message message) throws RemoteException;
    void disconnectClient() throws RemoteException;
}
