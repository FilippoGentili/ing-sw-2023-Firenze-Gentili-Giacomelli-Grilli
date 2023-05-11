package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.GenericMessage;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.Ping;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class SocketClient extends Client{

    private Socket socket;

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ExecutorService executorService;
    private ScheduledExecutorService pinger;


    private static final int HEARTBEAT = 10000;

    public SocketClient() throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress("127.0.0.1", 1099), HEARTBEAT);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        this.executorService = Executors.newSingleThreadExecutor();
        this.pinger = Executors.newSingleThreadScheduledExecutor();
        Client.LOGGER.info(() ->"Socket client started on port 1099");
    }

    @Override
    public void disconnect(){
        try {
            if (!socket.isClosed()) {
                executorService.shutdownNow();
                pinger(false);
                socket.close();
            }
        } catch (IOException e) {
            try {
                notifyObserver(new GenericMessage("Could not disconnect."));
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public void sendMessage(Message message){
        try {
            output.writeObject(message);
            output.reset();
        } catch (IOException e) {
            disconnect();
            try {
                notifyObserver(new GenericMessage("Could not send message."));
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Method used when the client is Socket and receives a message from server
     */
    @Override
    public void readMessage() {
        executorService.execute(() -> {
            while(!executorService.isShutdown()){
                Message message;
                try {
                    message = (Message) input.readObject();
                    Client.LOGGER.info("Received:" + message);
                } catch (IOException | ClassNotFoundException e) {
                    message = new GenericMessage("Connection lost");
                    disconnect();
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

    @Override
    public void pinger(boolean on) {
        if (on) {
            pinger.scheduleAtFixedRate(() -> {
                sendMessage(new Ping());
            }, 0, HEARTBEAT, TimeUnit.MILLISECONDS);
        } else {
            pinger.shutdownNow();
        }
    }

}
