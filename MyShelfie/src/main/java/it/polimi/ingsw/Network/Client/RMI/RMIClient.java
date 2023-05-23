package it.polimi.ingsw.Network.Client.RMI;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.RemoteException;

public class RMIClient extends Client implements RMIClientHandler{

    public RMIClient(DisconnectionHandler disconnectionHandler) {
        super(disconnectionHandler);
    }

    @Override
    public void connection() throws IOException {

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
