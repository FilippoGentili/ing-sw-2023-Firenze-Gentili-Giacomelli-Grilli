package it.polimi.ingsw.Observer;

//qui ci saranno tutti i metodi da chiamare in seguito a cambiamenti nella view
//i metodi manderanno messaggi al server

import it.polimi.ingsw.Model.Tile;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ViewObserver{

    void updateServerInfoSocket(Map<String, String> serverInfo) throws IOException;

    void updateNickname(String nickname) throws RemoteException;

    void updateNumOfPlayers(int num) throws RemoteException;

    void updateChosenTiles(ArrayList<Tile> chosen) throws RemoteException;

    void updateOrderedTiles(ArrayList<Tile> chosen) throws RemoteException;

    void updateChosenColumn(int col,ArrayList<Integer> availableColumns) throws RemoteException;

    void handleDisconnection() throws RemoteException;
}
