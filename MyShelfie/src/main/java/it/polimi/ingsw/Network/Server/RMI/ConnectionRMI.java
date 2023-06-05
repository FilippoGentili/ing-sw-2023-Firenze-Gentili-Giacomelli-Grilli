package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Client.Socket.PingTimer;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.rmi.RemoteException;
import java.util.Timer;

public class ConnectionRMI extends Connection {
    private final RMIClientHandler rmiClientHandler;
    private final Server server;

    ConnectionRMI(RMIClientHandler rmiClientHandler, Server server){
        this.rmiClientHandler = rmiClientHandler;
        this.server = server;
    }
    @Override
    public void disconnectClient(){

        if (isConnected) {
            isConnected = false;

            try {
                rmiClientHandler.disconnectMe();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }

            server.clientDisconnection(this);
        }

    }

    @Override
    public void sendMessage(Message message) {
        try {
            rmiClientHandler.receiveMessage(message);
        }catch (RemoteException e){
            Server.LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void ping() {
        try {
            rmiClientHandler.ping();
        } catch (RemoteException e) {
            disconnectClient();
        }
    }
}
