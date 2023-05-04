package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.Server;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Timer;
import java.util.TimerTask;

public class RMIClient implements MatchClient {
    Server server;
    private boolean isConnected;

    public RMIClient() throws RemoteException {
        isConnected = true;

    }

    /**
     * establish connection with the server
     * @param args
     * @throws RemoteException if a communication error occurs
     */
    public static void main(String[] args) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            MatchServer server = (MatchServer) registry.lookup("//localhost/MatchServer");
            MatchClient client = new MatchClientImpl(new RMIClient(), (Server) server);
            client.connectToServer();
        }catch (NotBoundException e){
            System.err.println("MatchServer is not bound to the registry: " + e.getMessage());
        }
    }

    /**
     * gets the server
     * @param server that is set
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * sets the server
     * @return the server
     */
    public Server getServer() {
        return server;
    }

    /**
     * connects client to the server
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void connectToServer() throws RemoteException {
        try {
            server.connectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    /**
     * disconnects client from the server
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void disconnectFromServer() throws RemoteException {
        try {
            server.disconnectClient(new MatchClientImpl(this, server));
        } catch (RemoteException e) {
            System.err.println("Error disconnecting from server: " + e.getMessage());
        }
    }

    /**
     * sends message to the server
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
     * receive message from the server
     * @param message that is received
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

    /**
     * checks connection between client and server every 10 seconds
     */
    @Override
    public void heartbeat() throws RemoteException{
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

}
