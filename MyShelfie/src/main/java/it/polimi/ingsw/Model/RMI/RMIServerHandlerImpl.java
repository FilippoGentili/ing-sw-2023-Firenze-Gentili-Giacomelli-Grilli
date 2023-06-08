package it.polimi.ingsw.Model.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerHandlerImpl extends UnicastRemoteObject implements RMIServerHandler{
    private final transient Server server;
    private transient ConnectionRMI connectionRMI;

    public RMIServerHandlerImpl(Server server) throws RemoteException {
        this.server = server;
    }

    @Override
    public void receiveMessage(Message message) throws RemoteException, InterruptedException {
        server.handleMessage(message);
    }

    @Override
    public void login(String username, RMIClientHandler connection) throws IOException, InterruptedException {
        connectionRMI = new ConnectionRMI(connection,server);
        server.login(username, connectionRMI);
    }

    @Override
    public void disconnectMe() throws RemoteException{
        connectionRMI.disconnectClient();
    }
}
