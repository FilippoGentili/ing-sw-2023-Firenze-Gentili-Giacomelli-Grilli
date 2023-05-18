package it.polimi.ingsw.Network.Client;

import java.util.TimerTask;

public class Timer extends TimerTask {

    private DisconnectionHandler disconnectionHandler;
    @Override
    public void run() {
        disconnectionHandler.handleDisconnection();
    }

    public Timer(DisconnectionHandler disconnectionHandler){
        super();
        this.disconnectionHandler=disconnectionHandler;
    }
}
