package it.polimi.ingsw.Network.Client.Socket;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import static java.lang.Integer.parseInt;

public class SocketClient extends Client implements Runnable{

    private static final long serialVersionUID = -7451963301034418721L;
    private transient Socket socket;
    private final String address;
    private final String port;
    private transient ObjectOutputStream output;
    private transient ObjectInputStream input;
    private transient Thread thread;
    private static final int HEARTBEAT = 10000;

    /**
     * Constructor of socket client
     * @param disconnectionHandler
     * @param address
     * @param port
     * @throws IOException
     */
    public SocketClient(DisconnectionHandler disconnectionHandler, String address, String port) throws IOException {
        super(disconnectionHandler);
        this.address = address;
        this.port = port;
    }

    @Override
    public void connection() throws IOException {
        this.socket = new Socket();
        int portNum = Integer.parseInt(port);
        this.socket.connect(new InetSocketAddress(address, portNum), HEARTBEAT);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        //sendMessage(new LoginRequest(getUsername()));

        this.thread = new Thread(this);
        thread.start();
        Client.LOGGER.info(() ->"Socket client started on port 1098");
    }

    @Override
    public void disconnectMe(){
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
            thread.interrupt();
            input = null;
            output = null;

        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
        }

    }

    @Override
    public void sendMessage(Message message){
        try {
            output.writeObject(message);
            output.reset();
        } catch (IOException | NullPointerException e) {
            Client.LOGGER.severe("Couldn't send message. Must disconnect");
            messageQueue.add(new DisconnectionResult(super.getUsername()));
            disconnectMe();
        }
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Message message = (Message) input.readObject();
                if(message!=null && message.getMessageType() != MessageType.PING){
                    synchronized (messageQueue){
                        messageQueue.add(message);
                    }
                }else if(message!=null && message.getMessageType().equals(MessageType.PING)){
                    super.timer.cancel();
                    super.timer = new Timer();
                    super.timer.schedule(new PingTimer(super.disconnectionHandler), HEARTBEAT);
                }
            } catch (IOException e) {
                disconnectMe();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
