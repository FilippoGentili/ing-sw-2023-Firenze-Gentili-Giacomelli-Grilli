package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class ChatMessage extends Message{

    @Serial
    private static final long serialVersionUID = 1803056874187171704L;
    private final String message;
    private final String receiver;
    private final String sender;
    
    public ChatMessage(String sender, String receiver, String message) {
        super(Game.getServerName(), MessageType.CHAT_MESSAGE);
        this.receiver = receiver;
        this.sender = sender;
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }

    public String getReceiver(){
        return receiver;
    }

    public String getSender(){
        return sender;
    }
}
