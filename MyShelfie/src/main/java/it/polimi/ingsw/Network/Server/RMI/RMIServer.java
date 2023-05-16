package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIServerHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static java.util.Objects.isNull;


public class RMIServer{
    private static Server server;
    private RMIServerHandler client;

    public RMIServer(Server server) {
        this.server = server;
    }
    public void run() {
        Thread thread = new Thread(() -> {
            try {
                RMIClientHandlerImpl rmiConnectionServer = new RMIClientHandlerImpl(server);
                Registry firstRegistry = LocateRegistry.createRegistry(1099);
                firstRegistry.rebind("MyShelfieServer", rmiConnectionServer);
                Server.LOGGER.info(() ->"RMI server started on port 1099");
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            }
        });
        thread.start();
    }

    public void sendMessage(Message message) throws RemoteException {
            client.sendMessage(message);
    }

    public static void forwardMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }
}
