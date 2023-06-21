package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<Message> messages;


    public Chat(){
        this.messages = new ArrayList<Message>();
    }

    public List<Message> getMessages(String nickname){
        List<Message> playerMessages = new ArrayList<Message>();
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getReceiver() != null && t.getReceiver().equals(nickname))).toList());
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getSender().equals(nickname))).toList());
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getReceiver() == null)).toList());
        return playerMessages;
    }

}
