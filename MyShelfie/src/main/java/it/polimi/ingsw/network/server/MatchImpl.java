package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchImpl extends UnicastRemoteObject implements Match {
    private ArrayList<Player> players;

    public MatchImpl() throws RemoteException {
        super();
        players = new ArrayList<Player>();
    }

    public void connectClient(RMIClient client) throws RemoteException {
        // implementazione del metodo
    }

    public void addPlayer(Player player) throws RemoteException {
        // implementazione del metodo
    }

    public void removePlayer(Player player) throws RemoteException {
        // implementazione del metodo
    }

    public ArrayList<Player> getListPlayers() throws RemoteException {
        // implementazione del metodo
    }

    public void connectChat(String nickname) throws RemoteException {
        // implementazione del metodo
    }

    public void startGame(int numOfPlayers) throws RemoteException {
        // implementazione del metodo
    }

    public void selectTile(int row, int col) throws RemoteException {
        // implementazione del metodo
    }

    public void updateState(State state) throws RemoteException {
        // implementazione del metodo
    }

    public boolean isGameOver() throws RemoteException {
        // implementazione del metodo
    }

    public String getWinner() throws RemoteException {
        // implementazione del metodo
    }
}
