package it.polimi.ingsw.Network.Server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private final Server server;
    private final int port;

    public RMIServer(Server server, int port) {
        this.server = server;
        this.port = port;
    }

    void startRMIServer(){
        try{
            MatchServerImpl obj = new MatchServerImpl(server);
            Registry registry = LocateRegistry.createRegistry(port);
            Naming.rebind("MyShelfieServer", obj);
            System.out.println("RMI Server started");
        }catch (IOException e) {
           // Server.LOGGER.severe(e.getMessage());
        }
    }
}
