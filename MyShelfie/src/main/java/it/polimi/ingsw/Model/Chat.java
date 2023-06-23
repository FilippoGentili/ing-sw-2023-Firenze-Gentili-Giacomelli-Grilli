package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Chat {
    private final ArrayList<String> messages;


    public Chat(){
        this.messages = new ArrayList<>();
    }

    public ArrayList<String> getMessages(){
        ArrayList<String> playerMessages = new ArrayList<>();
        playerMessages.addAll(messages);
        messages.clear();
        return playerMessages;
    }

    public void addMessage(String sender, String receiver, String message){
        String finalMessage = "from " + sender + " to " + receiver + ": " + message;
        messages.add(finalMessage);
    }

}
