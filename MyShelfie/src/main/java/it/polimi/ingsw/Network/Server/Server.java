package it.polimi.ingsw.Network.Server;


import it.polimi.ingsw.Network.Client.SocketClient;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.MatchClientImpl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<MatchClient> listOfClients = new ArrayList<>();

    /**
     * method to start the RMI Server on port 1099
     */
    public static void startRMIServer(){
        try{
            MatchServerImpl obj = new MatchServerImpl();
            MatchServer server/*stub*/ = (MatchServer) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/MatchServer", server);
            System.out.println("RMI Server started");
        }catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method to start the Socket Server on port 1099
     */
    public static void startSocketServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(1099);
            System.out.println("Server Socket started");
            new Thread(() -> {
                while (true) {
                    try {
                        Server server = new Server();
                        Socket socket = serverSocket.accept();
                        SocketClient socketClient = new SocketClient();
                        MatchClientImpl matchClient = new MatchClientImpl(socketClient, server);
                        listOfClients.add(matchClient);
                        System.out.println("Socket client connected");
                    } catch (IOException e) {
                        System.err.println("Error accepting socket connection: " + e.getMessage());
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * connects RMIClient to server
     * @param matchClient client that will be connected
     */
    public void connectClient(MatchClientImpl matchClient) {
        listOfClients.add(matchClient);
        System.out.println("The client is connected to the server");
    }

    /**
     * disconnects RMIClient from the server
     * @param matchClient client that is being disconnected
     */
    public void disconnectClient(MatchClientImpl matchClient) {
        listOfClients.remove(matchClient);
        System.out.println("The client has been disconnected from the server");
    }

    /**
     * sends RMIMessage from server to client
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
     * server gets RMIMessage from client
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