package it.polimi.ingsw.Network.Message;

import java.util.ArrayList;

public class ColumnReply extends Message{
    private static final long serialVersionUID = -399221901652619718L;
    private final int column;
    private final ArrayList<Integer> AvailableColumns;

    /**
     * Method used to let the server know which column the player has chosen to set the tiles into
     * @param nickname
     * @param column
     */
    public ColumnReply(String nickname, int column, ArrayList<Integer> availableColumns) {
        super(nickname, MessageType.COLUMN_REPLY);
        this.column=column;
        this.AvailableColumns = availableColumns;
    }

    public int getColumn(){
        return column;
    }

    public ArrayList<Integer> getAvailableColumns() {
        return AvailableColumns;
    }

    @Override
    public String toString(){
        return " " + getNickname() + " wants to put the chosen tiles in column " + getColumn();
    }
}
