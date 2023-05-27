package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

//manda eventi

public class Observable {

    public ArrayList<Observer> observers = new ArrayList<>();

    protected Observable() {
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
