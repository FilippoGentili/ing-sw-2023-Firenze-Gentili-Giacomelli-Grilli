package it.polimi.ingsw.Network.Client;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Server;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Timer;
import java.util.TimerTask;

public class MatchClientImpl extends UnicastRemoteObject implements MatchClient {

    @Serial
    private static final long serialVersionUID = -1560260263161329165L;
    private final MatchClient client;
    private boolean isConnected;
    private final Server server;

    public MatchClientImpl(MatchClient client, Server server) throws RemoteException {
        super();
        this.client = client;
        this.server = server;
        isConnected = true;
    }

    /**
     * checks connection between client and server
     */
    public void heartbeat() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isConnected) {
                    try {
                        Message Heartbeat= new Heartbeat();
                        sendMessage(Heartbeat);
                    } catch (RemoteException e) {
                        System.err.println("Error sending heartbeat message: " + e.getMessage());
                        isConnected = false;
                        try {
                            disconnectFromServer();
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } else {
                    timer.cancel();
                }
            }
        }, 0, 10000);
    }

    /**
     * method called by the server to connect the client
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void connectToServer() throws RemoteException{
        server.connectClient(this);
        isConnected = true;
        heartbeat();
    }

    /**
     * method called by the server to disconnect the client
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void disconnectFromServer() throws RemoteException {
        server.disconnectClient(this);
        isConnected = false;
    }

    /**
     * Implementation of the method that sends the message to the server
     * @param message that the client sends
     * @throws RemoteException if a communication error occurs
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
     * @throws RemoteException if a communication error occurs
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