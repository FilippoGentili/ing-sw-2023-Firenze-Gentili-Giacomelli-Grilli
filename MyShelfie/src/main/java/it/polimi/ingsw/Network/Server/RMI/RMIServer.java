package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIServerHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
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
                RMIClientHandlerImpl rmiConnectionServer = new RMIClientHandlerImpl(this);
                Registry firstRegistry = LocateRegistry.createRegistry(1099);
                firstRegistry.rebind("MyShelfieServer", rmiConnectionServer);
                Server.LOGGER.info(() ->"RMI server started on port 1099");

                while(isNull(client)){
                    Registry thirdRegistry = LocateRegistry.getRegistry("LocalHost", 1099);
                    client = (RMIServerHandler) thirdRegistry.lookup("rmiConnectionClient");
                }
            } catch (IOException e) {
                Server.LOGGER.severe(e.getMessage());
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }

    public static void addClient(String nickname, MatchServer matchServer) throws RemoteException{
        server.addClient(nickname, matchServer);
    }

    public void sendMessage(Message message) throws RemoteException {
            client.sendMessage(message);
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        server.clientDisconnection(matchServer);
    }

    public static void forwardMessage(Message message) throws RemoteException {
        server.forwardMessage(message);
    }
}
