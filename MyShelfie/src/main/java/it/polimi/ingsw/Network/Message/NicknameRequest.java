package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class NicknameRequest extends Message{
    private static final long serialVersionUID = -9163744077200630463L;

    public NicknameRequest() {
        super(Game.getServerName(), MessageType.NICKNAME_REQUEST);
    }

}
