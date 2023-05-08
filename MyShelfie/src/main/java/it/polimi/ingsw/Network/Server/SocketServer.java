package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SocketServer {

    private final Server server;
    private final int port;
    ServerSocket serverSocket;

    public SocketServer(Server server, int port){
        this.server = server;
        this.port = port;
    }

    public void startSocketServer(){
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
    }

    public void addClient(String nickname, MatchServer matchServer) throws RemoteException {
        server.addClient(nickname, matchServer);
    }

    public void forwardMessage(Message message){
        server.forwardMessage(message);
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        server.clientDisconnection(matchServer);
    }

}
