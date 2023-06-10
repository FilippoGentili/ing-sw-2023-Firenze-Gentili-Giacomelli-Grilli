package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

public abstract class Client extends UnicastRemoteObject {

    public static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    private static final long serialVersionUID = -3679938076760254410L;
    protected transient DisconnectionHandler disconnectionHandler;
    protected transient Timer timer;
    private String username;
    public final transient ArrayList<Message> messageQueue;


    public Client(DisconnectionHandler disconnectionHandler) throws RemoteException {
        //super();
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

    public abstract void disconnectMe() throws RemoteException;

    public abstract void sendMessage(Message message);

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
