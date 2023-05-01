package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchClient extends Remote {
    void notifyConnection() throws RemoteException;
    void notifyDisconnection() throws RemoteException;
    void notifyMessageSent(Message message) throws RemoteException;
}

