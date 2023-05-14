package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIServer{
    private static Server server;

    public RMIServer(Server server) {
        this.server = server;
    }
    public void run() {
        Thread thread = new Thread(() -> {
            try {
                RMIClientHandlerImpl rmiConnection = new RMIClientHandlerImpl(this);
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.rebind("MyShelfieServer", rmiConnection);
                Server.LOGGER.info(() ->"RMI server started on port 1099");
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            }
        });
        thread.start();
    }

    public static void addClient(String nickname, MatchServer matchServer) throws RemoteException{
        server.addClient(nickname, matchServer);
    }

    public static void receiveMessage(Message message) throws RemoteException {
        server.receiveMessage(message);
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        server.clientDisconnection(matchServer);
    }

    public static void forwardMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }
}
