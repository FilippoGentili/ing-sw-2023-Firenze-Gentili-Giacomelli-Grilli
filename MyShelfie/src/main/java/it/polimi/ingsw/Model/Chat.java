package it.polimi.ingsw.Model;

import it.polimi.ingsw.View.VirtualView;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<Message> messages;


    public Chat(){
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message message, Game game){
        this.messages.add(message);
        for(Player player: game.getPlayers()){
            //forse observer
        }
    }
    public List<Message> getMessages(Player player){
        List<Message> playerMessages = new ArrayList<Message>();
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getReceiver() != null && t.getReceiver().equals(player.getNickname()))).toList());
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getSender().equals(player))).toList());
        playerMessages.addAll(this.messages.stream().filter(t -> (t.getReceiver() == null)).toList());
        return playerMessages;
    }

}
