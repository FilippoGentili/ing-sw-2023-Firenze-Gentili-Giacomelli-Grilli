package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;

public class MatchImpl extends UnicastRemoteObject implements Match {
    private ArrayList<Player> players;
    private int numOfPlayers;

    public MatchImpl(int numOfPlayers) throws RemoteException {
        this.numOfPlayers = numOfPlayers;
        players = new ArrayList<Player>();
    }

    /**
     * connection between client and server
     * @throws RemoteException
     */
    @Override
    public void connectClient(RMIClient client) throws RemoteException {

    }

    /**
     * adds the player to the game
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void addPlayer(Player player) throws RemoteException {

    }

    /**
     * removes player from the game
     * @param player
     * @throws RemoteException
     */
    @Override
    public void removePlayer(Player player) throws RemoteException {

    }

    /**
     *
     * @return list of players in the game
     * @throws RemoteException
     */
    @Override
    public ArrayList<Player> getListPlayers() throws RemoteException {
        // Implementazione del metodo per ottenere il numero di giocatori nella partita
        return players;
    }

    /**
     * connects the client to the chat
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void connectChat(String nickname) throws RemoteException {

    }

    /**
     * starts a new game
     * @param numOfPlayers
     * @throws RemoteException
     */
    @Override
    public void startGame(int numOfPlayers) throws RemoteException {

    }

    /**
     * client selects a tile from the livingRoom
     * @param row
     * @param col
     * @throws RemoteException
     */
    @Override
    public void selectTile(int row, int col) throws RemoteException {

    }

    /**
     * update the state of a client
     * @param state
     * @throws RemoteException
     */
    @Override
    public void updateState(State state) throws RemoteException {

    }

    /**
     * ends the game
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean endGame() throws RemoteException {

    }

    /**
     * gets the winner of the game
     * @return
     * @throws RemoteException
     */
    @Override
    public String getWinner() throws RemoteException {

        return null;
    }
}
