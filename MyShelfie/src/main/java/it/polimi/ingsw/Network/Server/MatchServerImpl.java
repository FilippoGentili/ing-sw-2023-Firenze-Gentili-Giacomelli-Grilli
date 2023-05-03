package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {

    @Serial
    private static final long serialVersionUID = 2646967431577448909L;
    private ArrayList<RMIClient> listOfClients = new ArrayList<>();

    public MatchServerImpl() throws RemoteException {
        super();
    }

    /**
     * Implementation of the connection of the client
     * @param client that will be connected
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public synchronized void connectClient(RMIClient client) throws RemoteException{
        listOfClients.add(client);
        System.out.println("Client connected");
    }

    /**
     * Implementation of the disconnection of the client
     * @param client that will be disconnected
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public synchronized void disconnectClient(RMIClient client) throws RemoteException{
        listOfClients.remove(client);
        System.out.println("Client disconnected");

    }

    /**
     * Implementation of the method that sends the message to the client
     * @param message that the server sends to the client
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public synchronized void sendMessage(Message message) throws RemoteException{
        for (MatchClient client : listOfClients) {
            try {
                //serialize message
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
                objStream.writeObject(message);
                objStream.flush();
                byte[] data = byteStream.toByteArray();
                //send message to client
                client.getMessage(message);
            } catch (IOException e) {
                System.err.println("Error sending message to client: " + e.getMessage());
            }
        }
    }

    /**
     * Implementation of the method that gets the message from the client
     * @param message sent from client
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void getMessage(Message message) throws  RemoteException{
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