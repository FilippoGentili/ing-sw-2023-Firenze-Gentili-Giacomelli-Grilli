package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class WinnerMessage extends Message{
    private static final long serialVersionUID = 7515762515979215880L;
    private final String WinnerNickname;

    /**
     * Message from the server to the client to communicate the winner
     * @param winner
     */
    public WinnerMessage(String winner) {
        super(Game.getServerName(), MessageType.WINNER);
        this.WinnerNickname=winner;
    }

    public String getWinnerNickname(){
        return WinnerNickname;
    }

    @Override
    public String toString(){
        return "" + getWinnerNickname() + " is the Winner";
    }

}

