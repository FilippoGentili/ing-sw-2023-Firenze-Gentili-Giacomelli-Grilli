package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.View.Gui.Scene.GameSceneController;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface View {

    void showMessage(String message) ;

    void loginResult(boolean validNickname, boolean connection, String nickname);

    void nicknameRequest();

    void askNumberOfPlayers() ;

    void columnRequest(ArrayList<Integer> AvailableColumns);

    void TilesRequest(LivingRoom livingRoom) ;

    void OrderTiles(ArrayList<Tile> chosenTiles) ;

    void showScoreboard(ArrayList<Player> scoreboard);

    void someoneDisconnected(String nickname) ;

    void showLivingRoom(LivingRoom livingRoom);

    void showBookshelf(Player player);

    void showCommonGoalCards(Game game);

    void showPersonalGoalCard(Player player) throws Exception;

    void updateGameState(Player player, Game game) throws Exception;


    void showGameStarted(Game game);

    void showWaitingRoom(int maxPlayers, int numOfPlayersConnected);

    void showWinner(String winner);
}
