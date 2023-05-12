package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.View.Cli;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Client extends Observable implements Serializable {

    public static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    private static final long serialVersionUID = -3679938076760254410L;

    private String username;
    final transient ArrayList<Message> messageQueue;

    public Client(){
        this.messageQueue = new ArrayList<>();
    }

    public abstract void disconnect();

    public abstract void sendMessage(Message message) throws RemoteException;

    public abstract void pinger(boolean on);
    public abstract void readMessage();

    /**
     * Method used when the client is RMI and receives a message
     * @param message
     */
    public void readMessage(Message message){
        synchronized (messageQueue){
            messageQueue.add(message);
        }

        try {
            notifyObserver(message);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used to get the entire messageQueue and clear it
     * @return
     */
    public ArrayList<Message> receiveMessages(){
        ArrayList<Message> messages;

        synchronized(messageQueue){
            messages=new ArrayList<>(List.copyOf(messageQueue));
            messageQueue.clear();
        }
        return messages;
    }

}
