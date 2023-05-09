package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class MatchServerSocket implements MatchServer{

    private final Socket client;
    private final SocketServer socketServer;
    private boolean connected;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    private final Object inputLock;
    private final Object outputLock;

    public MatchServerSocket(SocketServer socketServer, Socket client){
        this.client = client;
        this.socketServer = socketServer;
        this.connected = true;
        this.inputLock = new Object();
        this.outputLock = new Object();

        try{
            this.in = new ObjectInputStream(client.getInputStream());
            this.out = new ObjectOutputStream(client.getOutputStream());
        }catch (IOException e){
            Server.LOGGER.severe("Server down");
        }
    }

    public void connectClient() {
        Server.LOGGER.info("" + client.getInetAddress() + " connected");

        try{
            Message message = (Message) in.readObject();

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
    public void disconnectClient() throws IOException {
        if(connected){
            if(!client.isClosed()){
                client.close();
            }
            connected = false;
            Thread.currentThread().interrupt();

            socketServer.clientDisconnection(this);
        }
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        try{
            synchronized(outputLock){
                out.writeObject(message);
                out.reset();
                Server.LOGGER.info(() -> "Sent: " + message);
            }
        } catch(IOException e) {
            Server.LOGGER.severe(e.getMessage());
        }
    }

}
