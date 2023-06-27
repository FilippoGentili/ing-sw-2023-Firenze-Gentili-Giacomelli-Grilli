package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class OpenChatMessage extends Message{


    public OpenChatMessage() {
        super(Game.getServerName(), MessageType.OPENCHAT_MESSAGE);
    }
}
