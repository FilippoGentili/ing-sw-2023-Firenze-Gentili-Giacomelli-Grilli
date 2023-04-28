package it.polimi.ingsw.observer;
import it.polimi.ingsw.network.Message.*;

public interface Observer {
    void refresh(Message message);
}
