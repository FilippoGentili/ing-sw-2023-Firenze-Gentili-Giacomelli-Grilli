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

    /**
     * Constructor of abstract client, a message queue is created and a timer is set
     * @param disconnectionHandler
     * @throws RemoteException
     */
    public Client(DisconnectionHandler disconnectionHandler) throws RemoteException {
        this.messageQueue = new ArrayList<>();
        this.disconnectionHandler = disconnectionHandler;
        this.timer = new Timer();
    }

    /**
     * @return client username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username is set for the player that chose it
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Creates the connection client-server. Depending on the type of connection, it will be through the registry or
     * a socket
     * @throws IOException
     */
    public abstract void connection() throws IOException;

    /**
     * Disconnects the client, calling the implementation of the method in server and setting server instance in client
     * to null
     * @throws RemoteException
     */
    public abstract void disconnectMe() throws RemoteException;

    /**
     * @param message that has to be sent
     */
    public abstract void sendMessage(Message message);

    /**
     * Method used to get the entire messageQueue and clear it
     * @return the received messages
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
