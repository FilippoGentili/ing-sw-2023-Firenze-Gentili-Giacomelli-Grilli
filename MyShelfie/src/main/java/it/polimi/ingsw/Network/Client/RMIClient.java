package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.io.*;
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
        client.connectToServer();
    }

    public void setServer(RMIServer server) {
        this.server = server;
    }

    public RMIServer getServer() {
        return server;
    }

    @Override
    public void connectToServer() throws RemoteException {
        try {
            server.connectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    @Override
    public void disconnectFromServer() throws RemoteException {
        try {
            server.disconnectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error disconnecting from server: " + e.getMessage());
        }
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        try {
            //serialize message
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(message);
            objectStream.flush();
            byte[] data = byteStream.toByteArray();
            //send message to server
            server.getMessage(message);
        } catch (IOException e) {
            System.err.println("Error sending message to server: " + e.getMessage());
        }
    }

    @Override
    public void getMessage(Message message) throws RemoteException {
        try {
            //deserialize message
            byte[] data = message.getData();
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInput in = new ObjectInputStream(bis);
            Message receivedMessage = (Message) in.readObject();
            System.out.println("Received message: " + receivedMessage.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error receiving message: " + e.getMessage());
        }
    }

}

