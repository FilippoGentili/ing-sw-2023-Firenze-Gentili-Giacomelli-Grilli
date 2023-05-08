package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import java.net.ServerSocket;
import java.rmi.RemoteException;

public class SocketServer {

    private final Server server;
    private final int port;
    ServerSocket serverSocket;

    public SocketServer(Server server, int port){
        this.server = server;
        this.port = port;
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
