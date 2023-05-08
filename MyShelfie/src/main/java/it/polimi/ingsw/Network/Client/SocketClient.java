package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.GenericMessage;
import it.polimi.ingsw.Network.Message.Message;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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

    public void startSocketClient(){
        try (Socket socket = new Socket(getAddress(), getPort());){
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void disconnect() {

    }

    @Override
    public void sendMessage(Message message) {

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
                    disconnect();

                }
            }
        });
    }

    @Override
    public void pinger(boolean on) {

    }
}
