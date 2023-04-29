package it.polimi.ingsw.Network.Message;

public class ColumnReply extends Message{
    private static final long serialVersionUID = -399221901652619718L;
    private final int column;

    /**
     * Method used to let the server know which column the player has chosen to set the tiles into
     * @param nickname
     * @param column
     */
    public ColumnReply(String nickname, int column) {
        super(nickname, MessageType.COLUMN_REPLY);
        this.column=column;
    }

    public int getColumn(){
        return column;
    }

    @Override
    public String toString(){
        return " " + getNickname() + " wants to put the chosen tiles in column " + getColumn();
    }
}
