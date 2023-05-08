package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SocketServer implements Runnable {

    private final Server server;
    ServerSocket serverSocket;

    public SocketServer(Server server){
        this.server = server;
    }

    @Override
    public  void run() {
        try {
            serverSocket = new ServerSocket(1099);
            Server.LOGGER.info(() -> "Socket server started on port " + 1099 + ".");
        } catch (IOException e) {
            Server.LOGGER.severe("Error while starting server");
            return;
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();

                client.setSoTimeout(5000);

                MatchServerSocket matchServerSocket = new MatchServerSocket(this, client);
                Thread thread = new Thread((Runnable) matchServerSocket, "matchServerSocket" + client.getInetAddress());
                thread.start();
            } catch (IOException e) {
                Server.LOGGER.severe("Connection lost");
            }
        }
    }


   /* public void startSocketServer(){
        try (ServerSocket listener = new ServerSocket(getPort())){
            while (true){
                try (Socket socket = listener.accept()){
                    TimeUnit.SECONDS.sleep(20);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                    System.out.println("Data sent");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public void addClient(String nickname, MatchServer matchServer) throws RemoteException {
        server.addClient(nickname, matchServer);
    }

    public void forwardMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        server.clientDisconnection(matchServer);
    }

}
