package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public interface View {

    void showMessage(String message);

    void loginResult(boolean validNickname, boolean connection, String nickname);

    void nicknameRequest();

    void askNumberOfPlayers();

    void columnRequest(ArrayList<Integer> AvailableColumns);

    void TilesRequest();

    void OrderTiles(ArrayList<Tile> chosenTiles);

    void showCurrentPlayer();
}
