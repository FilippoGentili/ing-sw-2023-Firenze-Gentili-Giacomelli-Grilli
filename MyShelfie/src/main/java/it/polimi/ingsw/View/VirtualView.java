package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.MatchServerImpl;
import it.polimi.ingsw.Observer.Observer;

import java.util.ArrayList;

public class VirtualView implements View, Observer {

    private final MatchServer matchServer;

    public VirtualView(MatchServer matchServer){
        this.matchServer = matchServer;
    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void nicknameRequest() {

    }

    @Override
    public void showCurrentPlayer() {

    }

    @Override
    public void showMessage(String message) {
        matchServer.
    }



    @Override
    public void askNumberOfPlayers() {

    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) {

    }

    @Override
    public void TilesRequest() {

    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles){

    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) {

    }
}
