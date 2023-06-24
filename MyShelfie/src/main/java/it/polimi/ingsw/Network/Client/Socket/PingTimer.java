package it.polimi.ingsw.Network.Client.Socket;

import java.util.TimerTask;

/**
 * Class used to create a timer specifically for ping
 */
public class PingTimer extends TimerTask {

    private DisconnectionHandler disconnectionHandler;
    @Override
    public void run() {
        disconnectionHandler.handleDisconnection();
    }

    /**
     * Instantiates a disconnection handler to always be ready to handle disconnections
     * @param disconnectionHandler
     */
    public PingTimer(DisconnectionHandler disconnectionHandler){
        super();
        this.disconnectionHandler=disconnectionHandler;
    }
}
