package it.polimi.ingsw.Network.Server;


import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.MatchClientImpl;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServer{
    private List<MatchClient> listOfClients = new ArrayList<>();
    public static void main(String[] args){
        try{
            MatchServerImpl obj = new MatchServerImpl();
            MatchServer server/*stub*/ = (MatchServer) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/MatchServer", server);
        }catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * connects client to server
     * @param matchClient client that will be connected
     */
    public void connectClient(MatchClientImpl matchClient) {
        listOfClients.add(matchClient);
        System.out.println("The client is connected to the server");
    }

    /**
     * disconnects client from the server
     * @param matchClient client that is being disconnected
     */
    public void disconnectClient(MatchClientImpl matchClient) {
        listOfClients.remove(matchClient);
        System.out.println("The client has been disconnected from the server");
    }

    /**
     * sends message from server to client
     * @param message sent
     */
    public void sendMessage(Message message) {
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
     * server gets message from client
     * @param message received
     */
    public void getMessage(Message message){
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
