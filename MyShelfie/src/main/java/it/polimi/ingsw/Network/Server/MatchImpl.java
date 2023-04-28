package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Match;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatchImpl extends UnicastRemoteObject implements Match {

    protected MatchImpl() throws RemoteException {
    }

    @Override
    public void addPlayer(String nickname) throws RemoteException {

    }

    @Override
    public void removePlayer(String nickname) throws RemoteException {

    }

    @Override
    public void selectTile(int row, int col) throws RemoteException {

    }

    @Override
    public boolean gameOver() throws RemoteException {
        return false;
    }

    @Override
    public String getWinner() throws RemoteException {
        return null;
    }

    @Override
    public void startGame() throws RemoteException {

    }
}
