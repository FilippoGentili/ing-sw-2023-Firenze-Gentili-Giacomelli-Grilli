package it.polimi.ingsw.network.server;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.network.Match;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements Match {
    protected RMIServer() throws RemoteException {

        super();

    }

    @Override
    public void addPlayer(String nickname) throws RemoteException{

    }

    @Override
    public void removePlayer(String nickname) throws RemoteException{

    }
    @Override
    public void selectTile(int row, int col) throws RemoteException{

    }

    @Override
    public boolean gameOver() throws RemoteException{

    }

    @Override
    public String getWinner() throws  RemoteException{
        Game game = new Game();
        return game.getScoreBoard();
    }
}