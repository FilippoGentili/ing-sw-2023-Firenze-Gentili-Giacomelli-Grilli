package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.util.ArrayList;

//manda eventi

public class Observable implements Runnable {

    private final Client client;
    public ArrayList<Observer> observers = new ArrayList<>();

    private Thread thread;



    public Observable(){
        this.client = null;     //da fixare, devo avere un client da passare
        this.thread = new Thread(this);
        this.thread.start();
    }

    public Observable(Client client){
        this.client = client;
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
                        notifyObserver(msg);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void addObserver(Observer obs){
        observers.add(obs);
    }

    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    public void notifyObserver(Message message) throws RemoteException {
        for(Observer obs : observers){
            obs.update(message);
        }
    }
}
