package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface View {

    void showMessage(String message) throws RemoteException;

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

    void showCommonGoalCards(Game game);

    void showPersonalGoalCard(Player player) throws Exception;

    void updateGameState(Player player, Game game) throws Exception;

    void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) throws RemoteException;

    void showWinner(String winner) throws RemoteException;
}
