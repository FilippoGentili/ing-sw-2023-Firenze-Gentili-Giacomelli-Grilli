package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIServer implements Runnable{
    private static Server server;

    public RMIServer(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        Thread thread = new Thread(() -> {
            try {
                MatchServerRMI obj = new MatchServerRMI(server);
                Registry registry = LocateRegistry.createRegistry(1099);
                Naming.rebind("MyShelfieServer", obj);
                Server.LOGGER.info(() ->"RMI server started on port 1099");
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            }
        });
        thread.start();
    }
}
