package it.polimi.ingsw.Network.Server.RMI;

/*import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private final Server server;
    private final int port;

    public RMIServer(Server server, int port) {
        this.server = server;
        this.port = port;
    }

    public void startRMIServer() {
        try {
            RMIServerHandlerImpl rmiServerHandler = new RMIServerHandlerImpl(server);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("MyShelfieServer",rmiServerHandler);
            Server.LOGGER.info(() -> "RMI server started on port 1099");
        }catch (IOException | AlreadyBoundException e){
            Server.LOGGER.severe(e.getMessage());
        }
    }
}*/
