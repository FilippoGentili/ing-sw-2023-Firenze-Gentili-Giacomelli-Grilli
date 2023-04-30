package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Message.Message;

import java.util.ArrayList;

//manda eventi

public class Observable {

    public ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs){
        observers.add(obs);
    }

    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    public void notify(Message message){
        for(Observer obs : observers){
            obs.update(message);
        }
    }
}
