package it.polimi.ingsw.network;

import it.polimi.ingsw.network.client.SocketClient;
import it.polimi.ingsw.network.server.SocketServer;

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


