package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class WinnerMessage extends Message{
    private final String WinnerNickname;

    public WinnerMessage(String winner) {
        super(Game.getServerName(), MessageType.WINNER);
        this.WinnerNickname=winner;
    }

}
