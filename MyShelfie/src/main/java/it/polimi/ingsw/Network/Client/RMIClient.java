package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient implements MatchClient {
    RMIServer server;
    public RMIClient() throws RemoteException {

    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        MatchServer server = (MatchServer) registry.lookup("//localhost/MatchServer");
        MatchClient client = new MatchClientImpl(new RMIClient(), (RMIServer) server);
        client.notifyConnection();
    }

    public void setServer(RMIServer server) {
        this.server = server;
    }

    public RMIServer getServer() {
        return server;
    }

    @Override
    public void notifyConnection() throws RemoteException {
        try {
            server.connectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    @Override
    public void notifyDisconnection() throws RemoteException {
        try {
            server.disconnectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error disconnecting from server: " + e.getMessage());
        }
    }

    @Override
    public void notifyMessageSent(Message message) throws RemoteException {
        server.sendMessage(message);
    }
}

