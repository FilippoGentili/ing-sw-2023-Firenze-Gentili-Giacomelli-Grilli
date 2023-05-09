package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class MatchServerSocket implements MatchServer,Runnable{

    private final Socket client;
    private final SocketServer socketServer;
    private boolean connected;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    public MatchServerSocket(SocketServer socketServer, Socket client){
        this.client = client;
        this.socketServer = socketServer;
        this.connected = true;

        try{
            this.in = new ObjectInputStream(client.getInputStream());
            this.out = new ObjectOutputStream(client.getOutputStream());
        }catch (IOException e){

        }
    }

    public void clientConnection() throws IOException{
        Server.LOGGER.info("" + client.getInetAddress() + "connected");

        try{
            Message message = (Message) in.readObject();

            if(message != null){
                if(message.getMessageType() == MessageType.LOGIN_RESULT){
                    socketServer.addClient(message.getNickname(),this);
                }
                socketServer.forwardMessage(message);
            }
        }catch (ClassNotFoundException e){

        }
    }


    @Override
    public void connectClient(Client client) throws RemoteException {

    }

    @Override
    public void sendMessage(Message message) throws RemoteException {

    }

    @Override
    public void disconnectClient(Client client) throws RemoteException {

    }

    @Override
    public void getMessage() {

    }


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                clientConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
