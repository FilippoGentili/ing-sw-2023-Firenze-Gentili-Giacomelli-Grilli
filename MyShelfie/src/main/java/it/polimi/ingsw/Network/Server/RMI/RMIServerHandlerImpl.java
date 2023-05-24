package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Server;

import java.rmi.RemoteException;

public class RMIServerHandlerImpl implements RMIServerHandler{
    private final transient Server server;
    private transient ConnectionRMI connectionRMI;

    public RMIServerHandlerImpl(Server server){
        this.server = server;
    }

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        server.handleMessage(message);
    }
}
