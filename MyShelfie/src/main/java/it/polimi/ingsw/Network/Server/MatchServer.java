package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Message;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Remote interface of the client which will be used
 * by server. Methods which are invoked by the client
 */

public interface MatchServer extends Remote {

/**
 * Returns the connection status.
 *
 * @return true if the client is still connected
 */
    boolean checkConnection();

    /**
     * Disconnects from the client
     */
    void disconnect();

    /**
     * Sends a message to the client
     *
     * @param message
     */
    void sendMessage(Message message);
}
