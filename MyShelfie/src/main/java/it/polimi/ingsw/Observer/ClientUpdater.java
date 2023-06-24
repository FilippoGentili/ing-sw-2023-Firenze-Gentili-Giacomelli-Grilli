package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.util.ArrayList;

/**
 * The class represent a way for the client to be always listening
 */
public class ClientUpdater implements Runnable{

    private final Client client;
    private Observer observer;
    private Thread thread;

    /**
     * Constructor of client updater for a client
     * @param client the client updater has to be tied to
     * @param observer
     */
    public ClientUpdater(Client client, Observer observer) {
        this.client = client;
        this.observer = observer;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            synchronized (client){
                ArrayList<Message> messages;
                do{
                    messages = client.receiveMessages();
                    try{
                        client.wait(100);
                    }catch (InterruptedException e) {
                        ClientController.LOGGER.severe(e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }while(messages.isEmpty());

                for(Message msg : messages) {
                    observer.update(msg);
                }
            }
        }
    }

    /**
     * Starts the thread
     */
    public void start() {
        if (this.thread.isInterrupted()) {
            this.thread.start();
        }
    }

    /**
     * Stops the thread
     */
    public void stop(){
        this.thread.interrupt();
    }

}
