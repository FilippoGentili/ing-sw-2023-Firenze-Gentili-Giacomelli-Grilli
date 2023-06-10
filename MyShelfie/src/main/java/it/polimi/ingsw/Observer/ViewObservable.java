package it.polimi.ingsw.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ViewObservable {

    protected ArrayList<ViewObserver> observers = new ArrayList<>();

    public void addObserver(ViewObserver observer){
        observers.add(observer);
    }
    public void addAllObserver(List<ViewObserver> observer){
        this.observers.addAll(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    protected void notifyObserver(Consumer<ViewObserver> lambda) {
        for (ViewObserver observer : observers) {
            lambda.accept(observer);
        }
    }



}
