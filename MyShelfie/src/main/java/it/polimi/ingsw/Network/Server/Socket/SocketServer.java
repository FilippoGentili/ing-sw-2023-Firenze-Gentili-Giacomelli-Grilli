package it.polimi.ingsw.Network.Server.Socket;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class SocketServer extends Thread{

    private final Server server;
    private final int port;
    private ServerSocket serverSocket;

    /**
     * Constructor of Socket server
     * @param server of the game
     * @param port socket port, set to 1098
     */
    public SocketServer(Server server, int port){
        this.server = server;
        this.port = port;
    }

    /**
     * Starts socket server
     */
    public void startSocketServer(){
        try {
            serverSocket = new ServerSocket(port);
            start();
            Server.LOGGER.info(() -> "Socket server started on port 1098");

        } catch (IOException e) {
            Server.LOGGER.severe("Error while starting server");
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();
                new ConnectionSocket(this, client);
            } catch (IOException e) {
                Server.LOGGER.severe("Connection lost");
            }
        }
    }

    /**
     * Handles login of a socket client
     * @param nickname chosen by the client
     * @param connection type of connection chosen
     * @throws IOException
     * @throws InterruptedException
     */
    public void login(String nickname, Connection connection) throws IOException, InterruptedException {
        server.login(nickname, connection);
    }

    /**
     * Adds client
     * @param nickname chosen by the client
     * @param connection type of connection chosen
     * @throws RemoteException
     * @throws InterruptedException
     */
    public void addClient(String nickname, Connection connection) throws RemoteException, InterruptedException {
        server.addClient(nickname, connection);
    }

    /**
     * Handles client disconnection
     * @param connection type of connection for the client to be disconnected
     * @throws RemoteException
     */
    public void clientDisconnection(Connection connection) throws RemoteException {
        server.clientDisconnection(connection);
    }

    /**
     * Handles message received
     * @param message to be handled
     * @throws RemoteException
     * @throws InterruptedException
     */
    public void handleMessage(Message message) throws RemoteException, InterruptedException {
        server.handleMessage(message);
    }
}
