package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class ColumnRequest extends Message{
    private static final long serialVersionUID = 6449197724787330509L;
    private final String activePlayer;
    public ColumnRequest(String nickname){
        super(Game.getServerName(),  MessageType.COLUMN_REQUEST);
        this.activePlayer=nickname;
    }

    public String getActivePlayer(){
        return activePlayer;
    }

    @Override
    public String toString(){
        return " " + getActivePlayer() + " select the column";
    }

}
