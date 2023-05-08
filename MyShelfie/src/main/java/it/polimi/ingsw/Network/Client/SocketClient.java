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

public class SocketClient extends Client{

    private final Socket socket;

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final ExecutorService executorService;
    private final ScheduledExecutorService pinger;


    private static final int HEARTBEAT = 10000;

    public SocketClient(String address, int port) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(address, port), HEARTBEAT);
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        this.executorService = Executors.newSingleThreadExecutor();
        this.pinger = Executors.newSingleThreadScheduledExecutor();
    }

    /*public void startSocketClient(){
        try (Socket socket = new Socket(address, port){
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    @Override
    public void disconnect() throws RemoteException {
        try {
            if (!socket.isClosed()) {
                executorService.shutdownNow();
                pinger(false);
                socket.close();
            }
        } catch (IOException e) {
            notifyObserver(new GenericMessage("Could not disconnect."));
        }

    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        try {
            out.writeObject(message);
            out.reset();
        } catch (IOException e) {
            disconnect();
            notifyObserver(new GenericMessage("Could not send message."));
        }
    }

    @Override
    public void readMessage() {
        executorService.execute(() -> {
            while(!executorService.isShutdown()){
                Message message;
                try {
                    message = (Message) in.readObject();
                    Client.LOGGER.info("Received: " + message);
                } catch (IOException | ClassNotFoundException e) {
                    message = new GenericMessage("Connection lost");
                    try {
                        disconnect();
                    } catch (RemoteException ex) {
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

    @Override
    public void pinger(boolean on) {
        if (on) {
            pinger.scheduleAtFixedRate(() -> {
                try {
                    sendMessage(new Ping());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }, 0, 1000, TimeUnit.MILLISECONDS);
        } else {
            pinger.shutdownNow();
        }
    }
}
