package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.RMI.RMIServerHandler;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient extends Client implements RMIClientHandler{
    private transient RMIServerHandler server;

    public RMIClient(DisconnectionHandler disconnectionHandler) {
        super(disconnectionHandler);
    }

    @Override
    public void connection() throws IOException {
        Registry registry = LocateRegistry.getRegistry();
    }

    @Override
    public void disconnect() {

    }

    @Override
    public void sendMessage(Message message) throws RemoteException {

    }

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        synchronized (messageQueue){
            messageQueue.add(message);
        }
    }
}
