package it.polimi.ingsw.Network.Server.Socket;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionChat implements Runnable{
    private final SocketChat socketChat;
    private final Socket socket;
    private Thread threadChat;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Object inputLock = new Object();
    private Object outputLock = new Object();
    private boolean isConnected;

    public ConnectionChat(SocketChat socketChat, Socket socket){
        this.socketChat = socketChat;
        this.socket = socket;
        this.isConnected = true;

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

        threadChat = new Thread(this);
        threadChat.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (inputLock) {
                    Message message = (Message) input.readObject();
                    if (message != null) {
                        if (message.getMessageType().equals(MessageType.CHAT_MESSAGE)) {
                            socketChat.broadcastMessage(message);
                        } else {
                            Server.LOGGER.severe("Message not chat_message");
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                Server.LOGGER.severe(e.getMessage());
            } catch (IOException e) {
                //
            }
        }
    }

    public void sendMessage(Message message){
        if(isConnected){
            try{
                synchronized (outputLock){
                    output.writeObject(message);
                    output.reset();
                }
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            }
        }
    }
}
