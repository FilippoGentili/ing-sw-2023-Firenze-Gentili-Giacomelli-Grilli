package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Chat {
    private final ArrayList<String> messages;
    private ArrayList<String> oldMessages;
    private String owner;

    private ArrayList<String> otherPlayers;

    public Chat(){
        this.messages = new ArrayList<>();
        this.oldMessages = new ArrayList<>();
        this.otherPlayers = new ArrayList<>();
    }

    public ArrayList<String> getMessages(){
        ArrayList<String> playerMessages = new ArrayList<>();
        playerMessages.addAll(messages);
        oldMessages.addAll(messages);
        messages.clear();
        return playerMessages;
    }

    public ArrayList<String> getOldMessages(){
        return oldMessages;
    }

    public void addMessage(String sender, String receiver, String message){
        String finalMessage = "from " + sender + " to " + receiver + ": " + message;
        messages.add(finalMessage);
    }

    public void addOldMessage(String message){
        oldMessages.add(message);
    }

    public void setOwner(String nickname){
        this.owner = nickname;
    }

    public String getOwner() {
        return owner;
    }

    public void addOtherPlayers(ArrayList<Player> players){
        for(Player p : players)
            if(!p.getNickname().equals(owner))
                this.otherPlayers.add(p.getNickname());
    }

    public ArrayList<String> getOtherPlayers() {
        return this.otherPlayers;
    }
}
