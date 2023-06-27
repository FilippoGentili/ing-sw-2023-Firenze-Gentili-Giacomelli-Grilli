package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Message.*;

//gestisce l'arrivo di eventi

public interface Observer {
    /**
     * Handles arriving messages from Server (Requests)
     * @param message
     */
    void update(Message message);
}
