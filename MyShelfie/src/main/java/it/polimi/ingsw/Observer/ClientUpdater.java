package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientUpdater implements Runnable{

    private final Client client;

    private Observable observable;
    private Thread thread;

    ClientUpdater(Client client, Observable observervable) {
        this.client = client;
        this.observable = observervable;
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
                    try {
                        observable.notifyObserver(msg);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
