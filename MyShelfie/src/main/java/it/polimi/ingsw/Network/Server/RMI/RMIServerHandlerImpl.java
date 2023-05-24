package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Connection;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerHandlerImpl extends UnicastRemoteObject implements RMIServerHandler{
    private final transient Server server;

    public RMIServerHandlerImpl(Server server) throws RemoteException {
        this.server = server;
    }

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        server.handleMessage(message);
    }

    @Override
    public void login(String username, RMIClientHandler connection) throws IOException {
        ConnectionRMI connectionRMI = new ConnectionRMI(connection,server);
        server.login(username, connectionRMI);
    }
}
