package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.View;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Gui extends ViewObservable implements View {
    @Override
    public void showMessage(String message) throws RemoteException {

    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {

    }

    @Override
    public void nicknameRequest() throws RemoteException {

    }

    @Override
    public void askNumberOfPlayers() throws RemoteException {

    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {

    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException {

    }

    @Override
    public void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException {

    }

    @Override
    public void someoneDisconnected(String nickname) throws RemoteException {

    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void showBookshelf(Player player) throws RemoteException {

    }

    @Override
    public void showCommonGoalCards(Game game) {

    }

    @Override
    public void showPersonalGoalCard(Player player) throws Exception {

    }

    @Override
    public void updateGameState(Player player) throws Exception {

    }

    @Override
    public void showWinner(String winner) {

    }
}
