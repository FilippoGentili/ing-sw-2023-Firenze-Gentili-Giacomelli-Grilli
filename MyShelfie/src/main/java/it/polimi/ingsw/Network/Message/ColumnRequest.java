package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class ColumnRequest extends Message{
    private static final long serialVersionUID = 6449197724787330509L;
    private final ArrayList<Integer> availableColumns;
    private Player player;

    /**
     * Message used to request a column from the server to the client
     * @param availableColumns
     */
    public ColumnRequest(ArrayList<Integer> availableColumns, Player player){
        super(Game.getServerName(),  MessageType.COLUMN_REQUEST);
        this.availableColumns=availableColumns;
        this.player = player;
    }


    public ArrayList<Integer> getAvailableColumns(){
        return availableColumns;
    }

    public Player getPlayer(){return player;}

    @Override
    public String toString(){
        return "Select the column from the list: " + getAvailableColumns();
    }

}

