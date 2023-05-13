package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIClientHandler extends Remote {

    void showMessage(String message) throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException;
    void nicknameRequest() throws RemoteException;
    void askNumberOfPlayers() throws RemoteException;
    void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException;
    void TilesRequest(LivingRoom livingRoom) throws RemoteException;
    void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException;
    void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException;
    void someoneDisconnected(String nickname) throws RemoteException;
    void showLivingRoom(LivingRoom livingRoom) throws RemoteException;
    void showBookshelf(Player player) throws RemoteException;
    void showCommonGoalCards(Game game) throws RemoteException;
    void showPersonalGoalCard(Player player) throws Exception;
    void disconnectClient() throws RemoteException;
}
