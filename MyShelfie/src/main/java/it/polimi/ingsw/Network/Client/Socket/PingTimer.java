package it.polimi.ingsw.Network.Client.Socket;

import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;

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
