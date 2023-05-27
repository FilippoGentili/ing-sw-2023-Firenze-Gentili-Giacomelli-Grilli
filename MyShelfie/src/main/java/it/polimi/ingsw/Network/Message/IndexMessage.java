package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;
import java.util.HashMap;

public class IndexMessage extends Message{
    @Serial
    private static final long serialVersionUID = 169983083844552426L;
    private HashMap<Integer,Integer> indexTiles;

    public IndexMessage(HashMap<Integer,Integer> indexTiles) {
        super(Game.getServerName(), MessageType.INDEX_TILES);
        this.indexTiles = indexTiles;
    }

    public HashMap<Integer,Integer> getIndexTiles(){
        return indexTiles;
    }
}
