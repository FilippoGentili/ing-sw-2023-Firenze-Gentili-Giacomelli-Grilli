package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Message.*;

import java.rmi.RemoteException;

//gestisce l'arrivo di eventi

public interface Observer {
    void update(Message message) throws RemoteException;
}
