package it.polimi.ingsw.Network.Server.Socket;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Network.Message.Ping;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class ConnectionSocket extends Connection implements Runnable{

    private final SocketServer socketServer;
    private final Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Object inputLock = new Object();
    private Object outputLock = new Object();
    private Thread thread;

    private boolean connected;

    public ConnectionSocket(SocketServer socketServer, Socket socket){
        this.socketServer=socketServer;
        this.socket=socket;
        this.connected = true;


        try{
            synchronized(inputLock){
                this.input = new ObjectInputStream(socket.getInputStream());
            }
            synchronized (outputLock){
                this.output = new ObjectOutputStream(socket.getOutputStream());
            }
        } catch(IOException e){
            Server.LOGGER.severe(e.getMessage());
        }

        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try{
                synchronized (inputLock){
                    Message message = (Message) input.readObject();
                    if(message != null){
                        if(message.getMessageType().equals(MessageType.LOGIN_REQUEST)){
                            socketServer.login(message.getNickname(), this);
                        }else socketServer.handleMessage(message);
                    }
                }
            } catch (ClassNotFoundException e) {
                Server.LOGGER.severe(e.getMessage());
            } catch (IOException e){
                disconnectClient();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void disconnectClient() {
        if(checkConnection()){
            try {
                if (!socket.isClosed()) {
                    socket.close();
                }
            }catch (IOException e){
                Server.LOGGER.severe(e.getMessage());
            }
            isConnected = false;
            Thread.currentThread().interrupt();

            try {
                socketServer.clientDisconnection(this);
            }catch (IOException e){
                Server.LOGGER.severe("Connection problems");
            }
        }
    }

    @Override
    public void sendMessage(Message message){
        if(isConnected){
            try{
                synchronized (outputLock){
                    output.writeObject(message);
                    output.reset();
                }
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
                disconnectClient();
            }
        }
    }

    @Override
    public void ping() throws RemoteException {
        sendMessage(new Ping());
    }

}
