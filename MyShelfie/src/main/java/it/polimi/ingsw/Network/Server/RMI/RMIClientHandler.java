package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClientHandler extends Remote {

    void showMessage(String message) throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void updateNumberOfPlayers(Message message) throws RemoteException;
    void updateChosenTiles(Message message) throws RemoteException;
    void updateChosenColumn(Message message) throws RemoteException;
    void updateOrderedTiles(Message message) throws RemoteException;
    void disconnectClient() throws RemoteException;
}
