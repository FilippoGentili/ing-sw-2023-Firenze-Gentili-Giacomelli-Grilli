package it.polimi.ingsw.Observer;

//qui ci saranno tutti i metodi da chiamare in seguito a cambiamenti nella view
//i metodi manderanno messaggi al server

import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface ViewObserver{

    void updateServerInfoSocket(DisconnectionHandler disconnectionHandler, String address,String port) throws IOException;

    void updateServerInfoRmi(DisconnectionHandler disconnectionHandler,String address,String port) throws RemoteException;

    void updateNickname(String nickname) throws IOException;

    void updateNumOfPlayers(int num) throws IOException;

    void updateChosenTiles(ArrayList<Tile> chosen) throws IOException;

    void updateOrderedTiles(ArrayList<Tile> chosen) throws IOException;

    void updateChosenColumn(int col,ArrayList<Integer> availableColumns) throws IOException;

    void handleDisconnection() throws IOException;

    void updateLivingRoomTiles(HashMap<Integer, Integer> index) throws IOException;
}
