package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatchClient extends Remote {
    void update(Message message) throws RemoteException ;
    void updateState(State state) throws RemoteException;
    void notifyDisconnection() throws RemoteException;
    void notifyPlayerAdded(Player player) throws RemoteException;
    void notifyPlayerRemoved(Player player) throws RemoteException;
    void notifyGameStarted() throws RemoteException;
    void notifyTileSelected(int row, int col) throws RemoteException;
    void notifyStateUpdate(State state) throws RemoteException;
    void notifyGameOver(String winner) throws RemoteException;
}

