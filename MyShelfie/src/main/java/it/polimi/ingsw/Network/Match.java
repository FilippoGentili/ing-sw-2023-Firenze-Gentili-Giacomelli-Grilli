package it.polimi.ingsw.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Match extends Remote {
    public void addPlayer(String nickname) throws RemoteException;
    public void removePlayer(String nickname) throws RemoteException;
    public void selectTile(int row, int col) throws RemoteException;
    public boolean gameOver() throws RemoteException;
    public String getWinner() throws  RemoteException;
    public void startGame() throws RemoteException;
}
