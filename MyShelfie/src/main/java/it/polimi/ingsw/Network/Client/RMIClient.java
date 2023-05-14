package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.GenericMessage;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.Ping;
import it.polimi.ingsw.Network.Server.RMI.RMIClientHandler;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RMIClient extends Client {
        private static final long serialVersionUID = -4866092295114430600L;
        private final View view;
        private transient RMIClientHandler server = null;
        private ExecutorService executorService;
        private ScheduledExecutorService pinger;
        private ObjectOutputStream output;
        private ObjectInputStream input;

        private static final int HEARTBEAT = 10000;


        public RMIClient(View view){
                super();
                this.view = view;
                connectRMIClient();
        }

        public RMIClientHandler connectRMIClient(){
                try {
                        server = (RMIClientHandler) Naming.lookup("rmiConnection");
                } catch (MalformedURLException | NotBoundException | RemoteException e){
                        Server.LOGGER.severe(e.getMessage());
                }

                return server;
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


