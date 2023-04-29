package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Message;
import it.polimi.ingsw.Observer.Observable;

import java.util.logging.Logger;

public abstract class RMIClient extends Observable {

    public static final Logger LOGGER = Logger.getLogger(RMIClient.class.getName());

    /**
     * client sens message to the server
     * @param message
     */
    public abstract void sendMessage(Message message);

    /**
     * client recives message from the server
     * @param message
     */
    public abstract void getMessage(Message message);

    /**
     * client disconnects from the server
     */
    public abstract void disconnect();

    /**
     * ping to see if the connection is stable
     * @param stable
     */
    public abstract void pingHeartBeat(boolean stable);

}
