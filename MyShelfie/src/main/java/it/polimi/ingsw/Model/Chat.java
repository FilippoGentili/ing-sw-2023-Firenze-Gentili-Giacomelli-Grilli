package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Chat {
    private final ArrayList<String> messages;
    private ArrayList<String> oldMessages;
    private String owner;
    private ArrayList<String> otherPlayers;

    /**
     * Constructor of class chat
     */
    public Chat(){
        this.messages = new ArrayList<>();
        this.oldMessages = new ArrayList<>();
        this.otherPlayers = new ArrayList<>();
    }

    /**
     * Gets messages and clears list
     * @return list of messages
     */
    public ArrayList<String> getMessages(){
        ArrayList<String> playerMessages = new ArrayList<>();
        playerMessages.addAll(messages);
        oldMessages.addAll(messages);
        messages.clear();
        return playerMessages;
    }

    /**
     * Gets old messages
     * @return previously sent messages
     */
    public ArrayList<String> getOldMessages(){
        return oldMessages;
    }

    /**
     * Adds message to list of messages
     * @param sender nickname of sender
     * @param receiver nickname of receiver
     * @param message text of message to be sent
     */
    public void addMessage(String sender, String receiver, String message){
        String finalMessage = "from " + sender + " to " + receiver + ": " + message;
        messages.add(finalMessage);
    }

    /**
     * Adds message to list OldMessages
     * @param message text to add to old messages
     */
    public void addOldMessage(String message){
        oldMessages.add(message);
    }

    /**
     * Sets owner of chat
     * @param nickname of the owner of the chat
     */
    public void setOwner(String nickname){
        this.owner = nickname;
    }

    /**
     * Returns owner of the chat
     * @return nickname of the owner of the chat
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Adds players except current player
     * @param players list of all players of the game
     */
    public void addOtherPlayers(ArrayList<Player> players){
        for(Player p : players)
            if(!p.getNickname().equals(owner))
                this.otherPlayers.add(p.getNickname());
    }

    /**
     * Gets list of players that are not the current player, used when sending chat messages
     * @return list of other player for this chat
     */
    public ArrayList<String> getOtherPlayers() {
        return this.otherPlayers;
    }
}
