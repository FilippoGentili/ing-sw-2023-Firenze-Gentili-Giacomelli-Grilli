package it.polimi.ingsw.Network.Client.Socket;

import it.polimi.ingsw.Network.Client.Chat;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.ChatMessage;
import it.polimi.ingsw.Network.Message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Timer;

public class SocketClientChat extends Chat implements Runnable{
    private transient Socket chat;
    private final String address;
    private transient ObjectOutputStream outputChat;
    private transient ObjectInputStream inputChat;
    private static final int HEARTBEAT = 10000;
    private transient Thread thread;

    public SocketClientChat(String address, DisconnectionHandler disconnectionHandler){
        super(disconnectionHandler);
        this.address = address;
    }

    public void connectChat() {
        try {
            this.chat = new Socket();
            this.chat.connect(new InetSocketAddress(address, 49671), HEARTBEAT);
            this.outputChat = new ObjectOutputStream(chat.getOutputStream());
            this.inputChat = new ObjectInputStream(chat.getInputStream());

            this.thread = new Thread(this);
            thread.start();
            Client.LOGGER.info(() ->"Socket client started on port 1098");
        }catch (IOException e){
            Client.LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void disconnectMe() throws RemoteException {

    }

    @Override
    public void sendChatMessage(ChatMessage message) {

    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                ChatMessage message = (ChatMessage) inputChat.readObject();
                if(message!=null && message.getMessageType() != MessageType.PING){
                    synchronized (messageQueue){
                        messageQueue.add(message);
                    }
                }else if(message!=null && message.getMessageType().equals(MessageType.PING)){
                    super.timer.cancel();
                    super.timer = new Timer();
                    super.timer.schedule(new PingTimer(super.disconnectionHandler), HEARTBEAT);
                }
            } catch (IOException e) {
                try {
                    disconnectMe();
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
