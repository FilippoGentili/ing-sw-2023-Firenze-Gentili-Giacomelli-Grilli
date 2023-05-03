package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;

import java.io.*;
import java.net.Socket;
import java.rmi.RemoteException;

public class SocketClient implements MatchClient {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public SocketClient(){
    }

    @Override
    public void connectToServer() throws RemoteException{
        try {
            socket = new Socket("localhost", 1099);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        }catch (IOException e){
            System.err.println("Error connecting to server: " + e.getMessage());

        }
    }

    @Override
    public void disconnectFromServer() throws RemoteException {
        try {
            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            System.err.println("Error disconnecting from server: " + e.getMessage());
        }
    }

    @Override
    public void sendMessage(Message message) {
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

}
