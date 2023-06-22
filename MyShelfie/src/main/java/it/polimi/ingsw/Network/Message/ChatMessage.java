package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Chat;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class ChatMessage extends Message{

    @Serial
    private static final long serialVersionUID = 1803056874187171704L;
    private final Chat chat;

    /**
     * Message used exclusively when writing in the chat
     */
    public ChatMessage(Chat chat) {
        super(Game.getServerName(), MessageType.CHAT_MESSAGE);
        this.chat = chat;

    }
    public Chat getChat(){
        return  chat;
    }

}
