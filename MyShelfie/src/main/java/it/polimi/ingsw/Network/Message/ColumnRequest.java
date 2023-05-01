package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.Game;

import java.util.ArrayList;

public class ColumnRequest extends Message{
    private static final long serialVersionUID = 6449197724787330509L;
    private final String activePlayer;
    private final ArrayList<Integer> availableColumns;
    public ColumnRequest(String nickname, ArrayList<Integer> availableColumns){
        super(Game.getServerName(),  MessageType.COLUMN_REQUEST);
        this.activePlayer=nickname;
        this.availableColumns=availableColumns;
    }

    public String getActivePlayer(){
        return activePlayer;
    }

    public ArrayList<Integer> getAvailableColumns(){
        return availableColumns;
    }

    @Override
    public String toString(){
        return " " + getActivePlayer() + " select the column from the list: " + getAvailableColumns();
    }

}

