package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public class ChosenTilesMessage extends Message {
    private static final long serialVersionUID = 611518002718302338L;
    private final ArrayList<Tile> chosenTiles;

    public ChosenTilesMessage(String nickname, ArrayList<Tile> chosenTiles){
        super(nickname, MessageType.CHOSEN_TILES_REQUEST);
        this.chosenTiles = chosenTiles;
    }

    public ArrayList<Tile> getChosenTiles() {
        return chosenTiles;
    }

    @Override
    public String toString(){
        return "" + getNickname() + " has chosen the following tiles " + getChosenTiles();
    }

}
