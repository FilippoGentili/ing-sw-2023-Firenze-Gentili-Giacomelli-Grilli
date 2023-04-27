package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final ArrayList<Player> participants;
    private final List<Message> messages;

    public Chat(){
        participants = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addParticipants(Player participant){
        participants.add(participant);

    }
    public int getNumberOfParticipants(){
        return participants.size();
    }

    public int getNumMessages(){
        return messages.size();
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void removeParticipant(Player participant) {
        participants.remove(participant);
    }
}
