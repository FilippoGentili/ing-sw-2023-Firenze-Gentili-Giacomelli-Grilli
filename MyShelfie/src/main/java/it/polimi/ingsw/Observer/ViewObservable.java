package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ViewObservable {

    protected ArrayList<ViewObserver> observers = new ArrayList<>();

    /**
     * Adds observer to the observers list
     * @param observer to be added
     */
    public void addObserver(ViewObserver observer){
        observers.add(observer);
    }

    /**
     * Adds all observers to the list
     * @param observer list of observers
     */
    public void addAllObserver(List<ViewObserver> observer){
        this.observers.addAll(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    /**
     * Notifies the observers to generate an action through lambda function
     * @param lambda
     */
    protected void notifyObserver(Consumer<ViewObserver> lambda) {
        for (ViewObserver observer : observers) {
            lambda.accept(observer);
        }
    }

}
