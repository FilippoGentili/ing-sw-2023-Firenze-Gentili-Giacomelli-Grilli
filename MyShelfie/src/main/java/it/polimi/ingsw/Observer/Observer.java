package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Message.*;

//gestisce l'arrivo di eventi

public interface Observer {
    void update(Message message);
}
