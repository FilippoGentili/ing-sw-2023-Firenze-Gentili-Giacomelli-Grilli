package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private ArrayList<Player> participants;
    private List<Message> messages;

    public Chat(){
        participants = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addParticipants(Player participant){
        participants.add(participant);

    }
    public int getNumberOfParticipants(@NotNull Player participants){
        return participants.size();
    }

    public int getNumMessages(){
        return messages.size();
    }

    public List<Message> getMessages(){
        return messages;
    }
}
