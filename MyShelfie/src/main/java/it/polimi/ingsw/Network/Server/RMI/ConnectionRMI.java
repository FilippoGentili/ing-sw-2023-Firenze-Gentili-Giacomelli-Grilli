package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.rmi.RemoteException;

public class ConnectionRMI extends Connection {
    private final RMIClientHandler rmiClientHandler;
    private final Server server;

    ConnectionRMI(RMIClientHandler rmiClientHandler, Server server){
        this.rmiClientHandler = rmiClientHandler;
        this.server = server;
    }
    @Override
    public void disconnectClient() {

    }

    /**
     * this method is used to send message to the client
     * @param message
     */
    @Override
    public void sendMessage(Message message) throws RemoteException {
        rmiClientHandler.receiveMessage(message);
    }

    @Override
    public void ping() {

    }
}
