package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public interface View {

    void showMessage(String message);
    void NicknameRequest();
    void loginResult(boolean result);
    void askNumberOfPlayers();

    void columnRequest();

    void TilesRequest(ArrayList<Tile> chosenTiles);

    void showCurrentPlayer();
}
