package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class MatchServerSocket implements MatchServer{

    private final Socket client;
    private final SocketServer socketServer;
    private boolean connected;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    public MatchServerSocket(SocketServer socketServer, Socket client){
        this.client = client;
        this.socketServer = socketServer;
        this.connected = true;
    }


    @Override
    public void connectClient(Client client) throws RemoteException {

    }

    @Override
    public void sendMessage(Message message) throws RemoteException {

    }

    @Override
    public void disconnectClient(Client client) throws RemoteException {

    }

    @Override
    public void getMessage() {

    }


}
