package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerHandler extends Remote {

    void receiveMessage(Message message) throws RemoteException, InterruptedException;
    void login(String username, RMIClientHandler connection) throws IOException, InterruptedException;
    void disconnectMe() throws RemoteException;
}
