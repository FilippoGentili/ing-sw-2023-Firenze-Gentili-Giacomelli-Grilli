package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;

public class StartingChatMessage extends Message{
    @Serial
    private static final long serialVersionUID = -6531408099623461084L;

    /**
     * Constructor for the message
     */
    public StartingChatMessage() {
        super(Game.getServerName(), MessageType.STARTING_CHAT_MESSAGE);
    }
}
