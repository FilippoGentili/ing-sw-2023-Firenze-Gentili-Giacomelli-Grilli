package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Tile;

import java.io.Serial;
import java.util.ArrayList;

public class IndexMessage extends Message{
    @Serial
    private static final long serialVersionUID = 169983083844552426L;
    private ArrayList<Tile> chosen;

    /**
     * Message used to let the server know the chosen tile's index
     * @param username
     * @param chosen
     */
    public IndexMessage(String username, ArrayList<Tile> chosen) {
        super(username, MessageType.INDEX_TILES);
        this.chosen = chosen;
    }

    public ArrayList<Tile> getChosen(){
        return chosen;
    }
}
