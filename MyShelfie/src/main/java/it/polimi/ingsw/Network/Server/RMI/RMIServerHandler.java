package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClient;
import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServerHandler extends Remote {

    /**
     * this method sends a message to the server
     * @param message
     * @throws RemoteException
     */
    void receiveMessage(Message message) throws RemoteException;
    void login(String username, RMIClientHandler connection) throws IOException;
}
