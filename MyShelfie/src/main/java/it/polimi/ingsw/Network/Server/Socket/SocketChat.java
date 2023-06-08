package it.polimi.ingsw.Network.Server.Socket;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketChat extends Thread{
    private final Server server;
    private final int port;
    private ServerSocket serverSocket;
    private final List<ConnectionChat> connectionList;

    public SocketChat(Server server, int port){
        this.server = server;
        this.port = port;
        this.connectionList = new ArrayList<>();
    }

    public void startSocketChat(){
        try {
            serverSocket = new ServerSocket(port);
            start();
            Server.LOGGER.info(() -> "Socket chat started on port ");

        } catch (IOException e) {
            Server.LOGGER.severe("Error while starting server");
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();
                ConnectionChat conn = new ConnectionChat(this,client);
                connectionList.add(conn);
            } catch (IOException e) {
                Server.LOGGER.severe("Connection lost");
            }
        }
    }

    public void broadcastMessage(Message message){
        for(ConnectionChat connection : connectionList){
            connection.sendMessage(message);
        }
    }
}
