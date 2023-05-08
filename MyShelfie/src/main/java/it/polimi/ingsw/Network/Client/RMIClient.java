package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;

import java.io.Serial;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient extends Client implements MatchClient{

        @Serial
        private static final long serialVersionUID = 4702549132783715919L;
        private transient MatchServer server;

        public void startRMIClient(){
                try {
                        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
                        MatchServer matchServer = (MatchServer) registry.lookup("MyShelfieServer");
                        System.out.println("RMI Client started");
                } catch (RemoteException | NotBoundException e){
                        throw new RuntimeException(e);
                }
        }


        @Override
        public void disconnect() {

        }

        @Override
        public void sendMessage(Message message){

        }

        @Override
        public void readMessage() {

        }

        @Override
        public void pinger(boolean on) {

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

