package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchServer extends Remote {

    boolean checkConnection() throws RemoteException;

    void disconnectClient(Client client) throws RemoteException;

    void sendMessage(Message message) throws RemoteException;
}
