package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Client.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Remote interface of the client which will be used
 * by server. Methods which are invoked by the client
 */

public interface MatchServer extends Remote {
    void login() throws RemoteException;
    void nicknameRequest(String name) throws RemoteException;
    void connectClient(RMIClient client) throws RemoteException;
    void addPlayer(Player player) throws RemoteException;
    void removePlayer(Player player) throws RemoteException;
    ArrayList<Player> getListPlayers() throws RemoteException;
    void connectChat(String nickname) throws RemoteException;
    void startGame(int numOfPlayers) throws RemoteException;
    void selectTile(int row, int col) throws RemoteException;
    void updateState(State state) throws RemoteException;
    boolean isGameOver() throws RemoteException;
    String getWinner() throws RemoteException;
}

