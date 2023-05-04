package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Heartbeat;
import it.polimi.ingsw.Network.Message.Message;

import java.io.*;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

public class SocketClient implements MatchClient {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean isConnected;

    public SocketClient(){
        isConnected = true;
    }

    /**
     * connects the client to the server via socket
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void connectToServer() throws RemoteException{
        try {
            socket = new Socket("localhost", 1099);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        }catch (IOException e){
            System.err.println("Error connecting to server: " + e.getMessage());

        }
        isConnected = true;
        heartbeat();
    }

    /**
     * disconnects the client from the server
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void disconnectFromServer() throws RemoteException {
        try {
            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            System.err.println("Error disconnecting from server: " + e.getMessage());
        }
        isConnected = false;
    }

    /**
     * sends message to the server via socket
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void sendMessage(Message message) throws RemoteException {
        try {
            //serialize message
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
            objStream.writeObject(message);
            objStream.flush();
            byte[] data = byteStream.toByteArray();
            //send message to server
            output.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error sending message to server: " + e.getMessage());
        }
    }

    /**
     * gets message from the server via socket
     * @throws RemoteException if a communication error occurs
     */
    @Override
    public void getMessage(Message message) throws RemoteException {
        try {
            //receive message from server
            byte[] data = (byte[]) input.readObject();
            //deserialize message
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInput in = new ObjectInputStream(bis);
            Message receivedMessage = (Message) in.readObject();
            System.out.println("Received message from server: " + message.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error receiving message from server: " + e.getMessage());
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
