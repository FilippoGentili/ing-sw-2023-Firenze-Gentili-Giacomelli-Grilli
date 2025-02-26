package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.rmi.RemoteException;

public class ConnectionRMI extends Connection {
    private final RMIClientHandler rmiClientHandler;
    private final Server server;

    /**
     * Constructor of RMIConnection
     * @param rmiClientHandler
     * @param server
     */
    ConnectionRMI(RMIClientHandler rmiClientHandler, Server server){
        this.rmiClientHandler = rmiClientHandler;
        this.server = server;
    }
    @Override
    public void disconnectClient(){

        if (checkConnection()) {
            isConnected = false;

            try {
                rmiClientHandler.disconnectMe();
            } catch (RemoteException e) {
                //
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
            disconnectClient();
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
