package it.polimi.ingsw.Observer;

//qui ci saranno tutti i metodi da chiamare in seguito a cambiamenti nella view

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public interface ViewObserver {

    void updateServerInfo(/*Map<String, String> serverInfo*/);

    void updateNickname(String nickname);

    void updateNumOfPlayers(int num);

    void updateChosenTiles(ArrayList<Tile> chosen);

    void updateChosenColumn(int col);

    void handleDisconnection();
}
