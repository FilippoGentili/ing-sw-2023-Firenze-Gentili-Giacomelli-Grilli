package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public class OrderedTiles extends Message{
    private static final long serialVersionUID = -1120652964195992391L;
    private final ArrayList<Tile> orderedTiles;
    public OrderedTiles(String nickname, ArrayList<Tile> orderedTiles) {
        super(nickname, MessageType.ORDERED_TILES);
        this.orderedTiles = orderedTiles;
    }

    public ArrayList<Tile> getOrderedTiles(){
        return orderedTiles;
    }

    @Override
    public String toString(){
        return " " + getNickname() + " orderedTiles: " + getOrderedTiles();
    }

}
