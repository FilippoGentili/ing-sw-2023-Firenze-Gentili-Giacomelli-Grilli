package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.GenericMessage;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.Ping;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.MatchServerRMI;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RMIClient extends Client{
        private static final long serialVersionUID = -4866092295114430600L;
        private transient MatchServer server;
        private ExecutorService executorService;
        private ScheduledExecutorService pinger;
        private ObjectOutputStream output;
        private ObjectInputStream input;

        private static final int HEARTBEAT = 10000;


        public RMIClient(String username){
                super();
                try {
                        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
                        server = (MatchServer) registry.lookup("MyShelfieServer");
                        this.executorService = Executors.newSingleThreadExecutor();
                        this.pinger = Executors.newSingleThreadScheduledExecutor();
                        Client.LOGGER.info(() ->"RMI client started on port 1099");
                } catch (RemoteException | NotBoundException e){
                        Server.LOGGER.severe(e.getMessage());
                }
        }


        @Override
        public void disconnect(){
                try{
                        server.disconnectClient();
                        server = null;
                        executorService.shutdownNow();
                        pinger(false);
                }catch (IOException e){
                        try {
                                notifyObserver(new GenericMessage("Could not disconnect."));
                        } catch (RemoteException ex) {
                                throw new RuntimeException(ex);
                        }

                }
        }

        /**
         * Method used to send from client RMI to server a message
         * @param message
         * @throws RemoteException
         */
        @Override
        public void sendMessage(Message message) throws RemoteException {
                try {
                        server.sendMessage(message);
                } catch (IOException e) {
                        try {
                                server.disconnectClient();
                        } catch (IOException ex) {
                                throw new RuntimeException(ex);
                        }
                        try {
                                notifyObserver(new GenericMessage("Could not send message."));
                        } catch (RemoteException ex) {
                                throw new RuntimeException(ex);
                        }
                }
        }

        /*@Override
        public void readMessage() {
                executorService.execute(() -> {
                        while(!executorService.isShutdown()){
                                Message message;
                                try {
                                        message = (Message) input.readObject();
                                        Client.LOGGER.info("Received: " + message);
                                } catch (IOException | ClassNotFoundException e) {
                                        message = new GenericMessage("Connection lost");
                                        try {
                                                server.disconnectClient();
                                        } catch (IOException ex) {
                                                throw new RuntimeException(ex);
                                        }
                                        executorService.shutdownNow();
                                }
                                try {
                                        notifyObserver(message);
                                } catch (RemoteException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                });

        }

         */

        @Override
        public void pinger(boolean on) {
                if (on) {
                        pinger.scheduleAtFixedRate(() -> {
                                try {
                                        sendMessage(new Ping());
                                } catch (RemoteException e) {
                                        throw new RuntimeException(e);
                                }
                        }, 0, HEARTBEAT, TimeUnit.MILLISECONDS);
                } else {
                        pinger.shutdownNow();
                }
        }

        @Override
        public void readMessage() {

        }
}


