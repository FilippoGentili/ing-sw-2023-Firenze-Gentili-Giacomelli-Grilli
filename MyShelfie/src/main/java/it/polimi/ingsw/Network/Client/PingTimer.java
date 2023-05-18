package it.polimi.ingsw.Network.Client;

import java.util.TimerTask;

public class PingTimer extends TimerTask {

    private DisconnectionHandler disconnectionHandler;
    @Override
    public void run() {
        disconnectionHandler.handleDisconnection();
    }

    public PingTimer(DisconnectionHandler disconnectionHandler){
        super();
        this.disconnectionHandler=disconnectionHandler;
    }
}
