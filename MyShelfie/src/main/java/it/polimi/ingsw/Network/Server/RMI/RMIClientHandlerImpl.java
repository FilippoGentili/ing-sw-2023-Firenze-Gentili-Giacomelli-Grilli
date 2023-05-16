package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClientHandlerImpl extends UnicastRemoteObject implements RMIClientHandler {
    private final transient RMIServer server;

    protected RMIClientHandlerImpl(RMIServer server) throws RemoteException {
        super();
        this.server = server;
    }

    /**
     * this method receives the message from the client and sends it to the server.
     * @param message message sent from the client
     * @throws RemoteException
     */
    @Override
    public void sendMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }

    @Override
    public void disconnectClient() throws RemoteException {

    }

}
