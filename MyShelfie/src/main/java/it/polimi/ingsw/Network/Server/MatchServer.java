package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchServer extends Remote {

    boolean checkConnection() throws RemoteException;

    void disconnectClient() throws IOException;

    void sendMessage(Message message) throws RemoteException;
}
