package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Message.*;

public interface Observer {
    void refresh(Message message);
}
