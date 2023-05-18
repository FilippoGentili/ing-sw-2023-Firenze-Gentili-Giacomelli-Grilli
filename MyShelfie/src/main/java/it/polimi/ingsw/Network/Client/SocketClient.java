package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SocketClient extends Client implements Runnable{

    private static final long serialVersionUID = -7451963301034418721L;
    private transient Socket socket;

    private transient ObjectOutputStream output;
    private transient ObjectInputStream input;
    //private ExecutorService executorService;
    //private ScheduledExecutorService pinger;

    private transient Thread thread;

    private static final int HEARTBEAT = 10000;

    public SocketClient(String username) throws IOException {
        super(username);
        Client.LOGGER.info(() ->"Socket client started on port 49674");
    }

    @Override
    public void connect() throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress("127.0.0.1", 49674), HEARTBEAT);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());

        sendMessage(new LoginRequest(getUsername()));

        this.thread = new Thread();
        thread.start();

    }

    @Override
    public void disconnect(){
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
            thread.interrupt();
            input = null;
            output = null;

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


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            Message message;
            try {
                message = (Message) input.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if(message!=null && !message.getMessageType().equals(MessageType.PING)){
                synchronized (messageQueue){
                    messageQueue.add(message);
                }
            }else if(message!=null && message.getMessageType().equals(MessageType.PING)){
                super.timer.cancel();
                super.timer = new Timer();
                super.timer.schedule(new Timer);
            }

        }
    }
}
