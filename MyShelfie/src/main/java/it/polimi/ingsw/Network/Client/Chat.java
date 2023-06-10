package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.ChatMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public abstract class Chat {

    public final transient ArrayList<ChatMessage> messageQueue;
    protected transient DisconnectionHandler disconnectionHandler;
    protected transient Timer timer;

    protected Chat(DisconnectionHandler disconnectionHandler) {
        this.messageQueue = new ArrayList<>();
        this.disconnectionHandler = disconnectionHandler;
        this.timer = new Timer();
    }

    public abstract void connectChat();
    public abstract void disconnectMe() throws RemoteException;
    public abstract void sendChatMessage(ChatMessage message);

    public ArrayList<ChatMessage> receiveMessages(){
        ArrayList<ChatMessage> messages;

        synchronized(messageQueue){
            messages = new ArrayList<>(List.copyOf(messageQueue));
            messageQueue.clear();
        }
        return messages;
    }
}
