package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class WinnerMessage extends Message{
    private String WinnerNickname;

    public WinnerMessage() {
        super(LivingRoom.getInstance().getServerName(), MessageType.WINNER);
    }
}
