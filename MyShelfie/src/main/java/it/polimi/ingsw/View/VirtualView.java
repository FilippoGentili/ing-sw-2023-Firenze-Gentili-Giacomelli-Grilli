package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public class VirtualView implements View {

    @Override
    public void NicknameRequest() {

    }

    @Override
    public void showCurrentPlayer() {

    }

    @Override
    public void showMessage(String message) {
        //send message tramite client handler all'interno di Server
    }

    public void loginResult(boolean result){
        //da gestire sempre con clientHandler
    }

    @Override
    public void askNumberOfPlayers() {

    }

    @Override
    public void TilesRequest(ArrayList<Tile> chosenTiles) {

    }
}
