package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public class ChosenTilesMessage extends Message {
    private final ArrayList<Tile> chosenTiles;

    public ChosenTilesMessage(String nickname, MessageType messageType, ArrayList<Tile> chosenTiles){
        super(nickname,messageType);
        this.chosenTiles = chosenTiles;
    }

    public ArrayList<Tile> getChosenTiles() {
        return chosenTiles;
    }
}
