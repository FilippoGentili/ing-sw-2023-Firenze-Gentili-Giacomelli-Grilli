package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.RemoteException;

public abstract class MatchServer {
    public abstract boolean checkConnection() throws RemoteException;

    public abstract void disconnectClient() throws IOException;

    public abstract void sendMessage(Message message) throws RemoteException;
}
