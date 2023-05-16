package it.polimi.ingsw.Network.Server.Socket;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

public class SocketServer {

    private final Server server;
    private final int port;
    ServerSocket serverSocket;

    public SocketServer(Server server, int port){
        this.server = server;
        this.port = port;
    }

    public void startSocketServer(){
        try {
            serverSocket = new ServerSocket(port);
            Server.LOGGER.info(() -> "Socket server started on port 49674");
        } catch (IOException e) {
            Server.LOGGER.severe("Error while starting server");
        }
    }

    public  void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();

                client.setSoTimeout(5000);

                ConnectionSocket connectionSocket = new ConnectionSocket(this, client);
                Thread thread = new Thread(connectionSocket, "connectionSocket" + client.getInetAddress());
                thread.start();
            } catch (IOException e) {
                Server.LOGGER.severe("Connection lost");
            }
        }
    }

    public void addClient(String nickname, Connection connection) throws RemoteException {
        server.addClient(nickname, connection);
    }

    public void receiveMessage(Message message) {
        server.receiveMessage(message);
    }

    public void clientDisconnection(Connection connection) throws RemoteException {
        server.clientDisconnection(connection);
    }

    public void sendMessage(Message message, String nickname) throws RemoteException {
        server.sendMessage(message,nickname);
    }

    public void handleMessage(Message message) throws RemoteException {
        server.handleMessage(message);
    }
}
