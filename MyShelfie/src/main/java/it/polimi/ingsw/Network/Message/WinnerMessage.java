package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class WinnerMessage extends Message{
    private final String WinnerNickname;

    public WinnerMessage(String winner) {
        super(LivingRoom.getInstance().getServerName(), MessageType.WINNER);
        this.WinnerNickname=winner;
    }
}
