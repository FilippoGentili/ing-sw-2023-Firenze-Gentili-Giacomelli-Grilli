package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.util.ArrayList;

public class ColumnRequest extends Message{
    private static final long serialVersionUID = 6449197724787330509L;
    private final ArrayList<Integer> availableColumns;
    private String activePlayer;

    /**
     * Message used to request a column from the server to the client
     * @param availableColumns
     */
    public ColumnRequest(ArrayList<Integer> availableColumns){
        super(Game.getServerName(),  MessageType.COLUMN_REQUEST);
        this.availableColumns=availableColumns;}

    public ArrayList<Integer> getAvailableColumns(){
        return availableColumns;
    }

    @Override
    public String toString(){
        return "Select the column from the list: " + getAvailableColumns();
    }

}

