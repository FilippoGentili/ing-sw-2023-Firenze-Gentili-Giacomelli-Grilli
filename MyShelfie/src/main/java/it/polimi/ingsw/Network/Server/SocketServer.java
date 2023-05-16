package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

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

    public  void run() {
        try {
            serverSocket = new ServerSocket(port);
            Server.LOGGER.info(() -> "Socket server started on port 49674");
        } catch (IOException e) {
            Server.LOGGER.severe("Error while starting server");
            return;
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();

                client.setSoTimeout(5000);

                MatchServerSocket matchServerSocket = new MatchServerSocket(this, client);
                Thread thread = new Thread(matchServerSocket, "matchServerSocket" + client.getInetAddress());
                thread.start();
            } catch (IOException e) {
                Server.LOGGER.severe("Connection lost");
            }
        }
    }

    public void addClient(String nickname, MatchServer matchServer) throws RemoteException {
        server.addClient(nickname, matchServer);
    }

    public void receiveMessage(Message message) {
        server.receiveMessage(message);
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        server.clientDisconnection(matchServer);
    }

    public void forwardMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    public void sendMessage(Message message, String nickname) throws RemoteException {
        server.sendMessage(message,nickname);
    }

}
