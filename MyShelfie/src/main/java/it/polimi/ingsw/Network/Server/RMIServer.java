package it.polimi.ingsw.Network.Server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private static Server server ;

    public RMIServer(Server server) {
        this.server = server;
    }

    public void startRMIServer() {
        Thread thread = new Thread(() -> {
            try {
                MatchServerImpl obj = new MatchServerImpl(server);
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
