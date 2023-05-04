package it.polimi.ingsw.Network.Message;


import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;

public class OrderedTilesRequest extends Message{
    private static final long serialVersionUID = -64466265156410323L;
    private final ArrayList<Tile> chosenTiles;

    /**
     * Message from server to client used to ask to order the chosen tiles
     * @param chosenTiles
     */
    public OrderedTilesRequest(ArrayList<Tile> chosenTiles) {
        super(Game.getServerName(), MessageType.ORDERED_TILES_REQUEST);
        this.chosenTiles=chosenTiles;
    }

    public ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }
}
