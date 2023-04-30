package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Observer.Observer;

import java.util.ArrayList;

public class VirtualView implements View, Observer {

    @Override
    public void update(Message message) {

    }

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



    @Override
    public void askNumberOfPlayers() {

    }

    @Override
    public void columnRequest() {

    }

    @Override
    public void TilesRequest(ArrayList<Tile> chosenTiles) {

    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) {

    }
}
