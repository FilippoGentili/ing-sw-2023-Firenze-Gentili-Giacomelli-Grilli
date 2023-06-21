package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.ClientController;
//import it.polimi.ingsw.Network.Client.Chat;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.util.ArrayList;

public class ClientUpdater implements Runnable{

    private final Client client;
    private Observer observer;
    private Thread thread;

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

    public void start() {
        if (this.thread.isInterrupted()) {
            this.thread.start();
        }
    }

    public void stop(){
        this.thread.interrupt();
    }

}
