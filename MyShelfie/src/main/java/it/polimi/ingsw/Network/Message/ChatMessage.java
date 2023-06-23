package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Chat;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class ChatMessage extends Message{

    @Serial
    private static final long serialVersionUID = 1803056874187171704L;
    private final String sender;
    private final String receiver;
    private final String message;

    /**
     * Message used exclusively when writing in the chat
     */
    public ChatMessage(String sender, String receiver, String message) {
        super(sender, MessageType.CHAT_MESSAGE);
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender(){return this.sender;}

    public String getReceiver(){return this.receiver;}

    public String getMessage(){return this.message;}


}
