package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;

public class ChatMessage extends Message{

    @Serial
    private static final long serialVersionUID = 1803056874187171704L;
    private final String message;
    
    public ChatMessage(String message) {
        super(Game.getServerName(), MessageType.CHAT_MESSAGE);
        this.message = message;
    }
    
    public String showMessage(){
        return message;
    }

    @Override
    public String toString(){
        return "" + getNickname() + " : " + showMessage();
    }
}
