package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIServerHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClientHandlerImpl extends UnicastRemoteObject implements RMIClientHandler {
    private final transient Server server;
    private transient MatchServer connectionServer;

    protected RMIClientHandlerImpl(Server server) throws RemoteException {
        super();
        this.server = server;
    }

    @Override
    public void login(String nickname, RMIServerHandler rmiServerHandler) throws IOException {
        connectionServer = new MatchServerRMI(server,rmiServerHandler);
        server.login(nickname,connectionServer);
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
