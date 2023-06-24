package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerHandler extends Remote {
    /**
     * Receives message from the client and handles it in the rmi server
     * @param message received from the client
     * @throws RemoteException
     * @throws InterruptedException
     */
    void receiveMessage(Message message) throws RemoteException, InterruptedException;

    /**
     * Handles the login when rmi connection is chosen
     * @param username selected by the rmi client
     * @param connection rmiClientHandler of the client
     * @throws IOException
     * @throws InterruptedException
     */
    void login(String username, RMIClientHandler connection) throws IOException, InterruptedException;
    void disconnectMe() throws RemoteException;
}
