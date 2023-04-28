package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message.*;

import java.util.ArrayList;

public class Observable {

    public ArrayList<Observer> observers = new ArrayList<>();

    public void addObs(Observer obs){
        observers.add(obs);
    }

    public void removeObs(Observer obs){
        observers.remove(obs);
    }

    protected void notify(Message message){
        for(Observer i : observers)
            i.refresh(message);
    }
}
