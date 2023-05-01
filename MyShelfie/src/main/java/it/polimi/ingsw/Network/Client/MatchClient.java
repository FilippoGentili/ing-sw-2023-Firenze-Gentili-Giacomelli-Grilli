package it.polimi.ingsw.Network.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchClient extends Remote {
    void notifyConnection() throws RemoteException;
    void notifyDisconnection() throws RemoteException;
    void notifyMessageSent() throws RemoteException;
}

