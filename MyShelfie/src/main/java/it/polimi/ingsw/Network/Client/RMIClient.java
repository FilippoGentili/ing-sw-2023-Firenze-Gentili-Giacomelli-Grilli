package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Timer;

public class RMIClient extends Client{
        private transient MatchServer server;

        public void startRMIClient(){
                try {
                        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
                        MatchServer matchServer = (MatchServer) registry.lookup("MyShelfieServer");
                        Client.LOGGER.info(() ->"RMI client started on port 1099");
                } catch (RemoteException | NotBoundException e){
                        Server.LOGGER.severe(e.getMessage());
                }
        }


        @Override
        public void disconnect() throws IOException {
                server.disconnectClient();
                server = null;
        }

        @Override
        public void sendMessage(Message message) throws RemoteException {
                if(server == null){
                        throw new RemoteException();
                }
                server.sendMessage(message);
        }

        @Override
        public void readMessage() {

        }

        @Override
        public void pinger(boolean on) {

        }
}

