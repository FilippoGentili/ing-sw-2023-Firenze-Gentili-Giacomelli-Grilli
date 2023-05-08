package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Observer.Observable;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient extends Client implements MatchClient{

        private transient MatchServer server;

        RMIClient(String nickname, String address, int port) throws RemoteException {
                super(nickname, address, port);
        }

        @Override
        public void startRMIClient(){
                try {
                        Registry registry = LocateRegistry.getRegistry(getAddress(), getPort());
                        MatchServer matchServer = (MatchServer) registry.lookup("MyShelfieServer");
                        System.out.println("RMI Client started");
                } catch (RemoteException | NotBoundException e){
                        throw new RuntimeException(e);
                }
        }

        @Override
        void closeConnection() throws Exception {

        }

        @Override
        public void sendMessage(Message message) throws RemoteException {

        }

        @Override
        public void ping() throws RemoteException {

        }

        @Override
        public void connectToServer() throws RemoteException {

        }

        @Override
        public void disconnectFromServer() throws RemoteException {

        }

        @Override
        public void heartbeat() throws RemoteException {

        }
}

