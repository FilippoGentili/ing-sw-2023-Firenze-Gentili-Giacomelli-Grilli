package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.util.ArrayList;

public class ColumnRequest extends Message{
    private static final long serialVersionUID = 6449197724787330509L;
    private final ArrayList<Integer> availableColumns;
    private String activePlayer;
    public ColumnRequest(String nickname, ArrayList<Integer> availableColumns){
        super(Game.getServerName(),  MessageType.COLUMN_REQUEST);
        this.availableColumns=availableColumns;
        this.activePlayer = nickname;
    }


    public ArrayList<Integer> getAvailableColumns(){
        return availableColumns;
    }
    public String getActivePlayer(){
        return activePlayer;
    }

    @Override
    public String toString(){
        return " " + getActivePlayer() +" select the column from the list: " + getAvailableColumns();
    }

}

