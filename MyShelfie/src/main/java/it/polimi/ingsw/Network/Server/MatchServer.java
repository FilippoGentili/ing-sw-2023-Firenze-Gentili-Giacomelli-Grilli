package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.RMIClient;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchServer extends Remote {

    void connectClient(Client client) throws RemoteException;

    void sendMessage(Message message) throws RemoteException;

    void disconnectClient(Client client) throws RemoteException;

    //void getMessage();
}
