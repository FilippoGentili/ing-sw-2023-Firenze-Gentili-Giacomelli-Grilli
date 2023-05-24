package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Player;
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
    transient DisconnectionHandler disconnectionHandler;
    transient Timer timer;

    private String username;

    public final transient ArrayList<Message> messageQueue;

    public Client(DisconnectionHandler disconnectionHandler){
        this.messageQueue = new ArrayList<>();
        this.disconnectionHandler = disconnectionHandler;
        this.timer = new Timer();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public abstract void connection() throws IOException;

    public abstract void disconnect();

    public abstract void sendMessage(Message message) throws RemoteException;

    /**
     * Method used to get the entire messageQueue and clear it
     * @return
     */
    public ArrayList<Message> receiveMessages(){
        ArrayList<Message> messages;

        synchronized(messageQueue){
            messages = new ArrayList<>(List.copyOf(messageQueue));
            messageQueue.clear();
        }
        return messages;
    }
}
