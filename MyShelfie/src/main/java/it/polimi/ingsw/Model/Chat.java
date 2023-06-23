package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<String> messages;


    public Chat(){
        this.messages = new ArrayList<>();
    }

    public ArrayList<String> getMessages(){
        ArrayList<String> playerMessages = new ArrayList<>();
        playerMessages.addAll(messages);
        messages.clear();
        return playerMessages;
    }

    public void addMessage(String sender, String receiver, String message){ //da controllare ordine dei parametri che forse li ho trollati
        String finalMessage = "from" + sender + "to " + receiver + ": " + message;
        messages.add(finalMessage);
    }

}
