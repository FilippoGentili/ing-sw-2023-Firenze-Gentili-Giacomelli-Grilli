package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Bookshelf;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface View {

    void showMessage(String message) throws RemoteException;

    void loginResult(boolean validNickname, boolean connection, String nickname);

    void nicknameRequest() throws RemoteException;

    void askNumberOfPlayers();

    void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException;

    void TilesRequest(LivingRoom livingRoom);

    void OrderTiles(ArrayList<Tile> chosenTiles);

    void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException;

    void someoneDisconnected(String nickname) throws RemoteException;

    void showLivingRoom(LivingRoom livingRoom) throws RemoteException;

    void showBookshelf(Player player);
}
