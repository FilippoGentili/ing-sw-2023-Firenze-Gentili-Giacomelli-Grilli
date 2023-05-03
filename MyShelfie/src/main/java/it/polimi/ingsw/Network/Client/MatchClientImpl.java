package it.polimi.ingsw.Network.Client;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Server;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchClientImpl extends UnicastRemoteObject implements MatchClient {

    private final MatchClient client;
    private final Server server;

    public MatchClientImpl(MatchClient client, Server server) throws RemoteException {
        super();
        this.client = client;
        this.server = server;
    }


    /**
     * method called by the server to connect the client
     * @throws RemoteException
     */
    @Override
    public void connectToServer() throws RemoteException{
        server.connectClient(this);
    }

    /**
     * method called by the server to disconnect the client
     * @throws RemoteException
     */
    @Override
    public void disconnectFromServer() throws RemoteException {
        server.disconnectClient(this);
    }

    /**
     * Implementation of the method that sends the message to the server
     * @param message that the client sends
     * @throws RemoteException
     */
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

    /**
     * Implementation of the method that gets the message from the server
     * @param message that the client sends
     * @throws RemoteException
     */
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