package it.polimi.ingsw.Observer;

//qui ci saranno tutti i metodi da chiamare in seguito a cambiamenti nella view

import it.polimi.ingsw.Model.Tile;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ViewObserver{

    void updateServerInfo(Map<String, String> serverInfo);

    void updateNickname(String nickname) throws RemoteException;

    void updateNumOfPlayers(int num);

    void updateChosenTiles(ArrayList<Tile> chosen);

    void updateOrderedTiles()

    void updateChosenColumn(int col);

    void handleDisconnection();
}
