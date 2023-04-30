package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatchServerImpl extends UnicastRemoteObject implements MatchServer {
    private ArrayList<RMIClient> clients;
    private ArrayList<Player> players;

    public MatchServerImpl() throws RemoteException {
        clients = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void connectClient(RMIClient client) throws RemoteException {
        clients.add(client);
    }

    public void addPlayer(Player player) throws RemoteException {
        players.add(player);
    }

    public void removePlayer(Player player) throws RemoteException {
        players.remove(player);
    }

    public ArrayList<Player> getListPlayers() throws RemoteException {
        return players;
    }

    public void connectChat(String nickname) throws RemoteException {
        //implementazione della chat
    }

    public void startGame(int numOfPlayers) throws RemoteException {
        //implementazione dell'avvio del gioco
    }

    public void selectTile(int row, int col) throws RemoteException {
        //implementazione della selezione della tessera
    }

    public void updateState(State state) throws RemoteException {
        //implementazione dell'aggiornamento dello stato
    }

    public boolean isGameOver() throws RemoteException {
        //implementazione della verifica del game over
    }

    public String getWinner() throws RemoteException {
        //implementazione del recupero del vincitore
    }
}
