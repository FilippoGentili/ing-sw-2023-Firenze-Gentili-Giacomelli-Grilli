package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Network.Server.RMI.RMIServerHandler;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient extends Client implements RMIClientHandler{
    private transient RMIServerHandler server;
    private final String address;
    private final String port;

    public RMIClient(DisconnectionHandler disconnectionHandler, String address, String port) throws RemoteException {
        super(disconnectionHandler);
        this.address = address;
        this.port = port;
    }

    @Override
    public void connection() throws IOException {
        try {
            int rmiport = Integer.parseInt(port);
            Registry registry = LocateRegistry.getRegistry(address,rmiport);
            server = (RMIServerHandler) registry.lookup("MyShelfieServer");
            Client.LOGGER.info(() ->"RMIClient client started on port 1099");
        }catch (NotBoundException e){
            Client.LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void disconnect() {

    }

    @Override
    public void sendMessage(Message message) throws IOException {
        if(message.getMessageType() == MessageType.LOGIN_REQUEST){
            server.login(message.getNickname(),this);
        }else {
            server.receiveMessage(message);
        }
    }

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        synchronized (messageQueue){
            messageQueue.add(message);
        }
    }
}
