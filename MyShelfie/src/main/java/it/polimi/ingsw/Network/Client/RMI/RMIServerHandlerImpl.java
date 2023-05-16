package it.polimi.ingsw.Network.Client.RMI;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerHandlerImpl extends UnicastRemoteObject implements RMIServerHandler {
    private final transient RMIClient client;

    protected RMIServerHandlerImpl(RMIClient client) throws RemoteException {
        super();
        this.client = client;
    }

    /**
     * this method receives the message from the server and sends it to the client.
     * @param message
     * @throws RemoteException
     */
    @Override
    public void sendMessage(Message message) throws RemoteException {
        client.sendMessage(message);
    }
}
