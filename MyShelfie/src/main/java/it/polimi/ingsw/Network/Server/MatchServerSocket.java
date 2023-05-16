package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Network.Server.Socket.SocketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class MatchServerSocket implements MatchServer, Runnable{
    private final SocketServer socketServer;
    private final Socket client;
    private boolean connected;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private final Object inputLock;
    private final Object outputLock;

    public MatchServerSocket(SocketServer socketServer, Socket client){
        this.client = client;
        this.socketServer = socketServer;
        this.connected = true;
        this.inputLock = new Object();
        this.outputLock = new Object();

        try{
            this.input = new ObjectInputStream(client.getInputStream());
            this.output = new ObjectOutputStream(client.getOutputStream());
        }catch (IOException e){
            Server.LOGGER.severe("Server down");
        }
    }

    public void clientMessageHandler() {
        Server.LOGGER.info("" + client.getInetAddress() + " connected");

        try{
            Message message = (Message) input.readObject();

            if(message != null){
                if(message.getMessageType() == MessageType.LOGIN_REQUEST){
                    socketServer.addClient(message.getNickname(),this);
                }else {
                    socketServer.forwardMessage(message);
                }
            }
        }catch (ClassNotFoundException | IOException e){
            Server.LOGGER.severe("Connection could not be established");
        }
    }

    @Override
    public boolean checkConnection() throws RemoteException {
        return connected;
    }

    @Override
    public void disconnectClient() {
        if(connected){
            try {
                if (!client.isClosed()) {
                    client.close();
                }
            }catch (IOException e){
                Server.LOGGER.severe(e.getMessage());
            }
            connected = false;
            Thread.currentThread().interrupt();

            try {
                socketServer.clientDisconnection(this);
            }catch (IOException e){
                Server.LOGGER.severe("Connection problems");
            }
        }
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        try{
            synchronized(outputLock){
                output.writeObject(message);
                output.reset();
                Server.LOGGER.info(() -> "Sent: " + message);
            }
        } catch(IOException e) {
            Server.LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void run() {
        clientMessageHandler();
    }

    /*
    @Override
    public void ping(){

    }

     */


    @Override
    public void receiveMessage(Message message) throws RemoteException {
        socketServer.receiveMessage(message);
    }

}
