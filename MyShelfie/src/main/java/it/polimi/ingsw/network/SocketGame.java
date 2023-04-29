package it.polimi.ingsw.Network;

import it.polimi.ingsw.Network.Client.SocketClient;
import it.polimi.ingsw.Network.Server.SocketServer;

public class SocketGame {
    private SocketServer server;
    private SocketClient client;

    public SocketGame(int port) {
        server = new SocketServer(port);
        client = new SocketClient("localhost", port);
    }

    public void start() {
        server.start();
    }

    public void sendToServer(Object message) {
        server.sendMessage(message);
    }

}


