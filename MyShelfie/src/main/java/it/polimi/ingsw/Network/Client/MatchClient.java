package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchClient extends Remote {
    void connectToServer() throws RemoteException;
    void disconnectFromServer() throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void getMessage(Message message) throws RemoteException;
}

