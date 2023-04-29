package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class DisconnectionReply extends Message{
    /**
     * The server lets the other player know a player has left the game
     */
    private final String disconnectedUser;
    public DisconnectionReply(String username) {
        super(Game.getServerName(), MessageType.DISCONNECTION_REPLY);
        this.disconnectedUser=username;
    }

    public String getDisconnectedUser(){
        return disconnectedUser;
    }
    @Override
    public String toString(){
        return " " + getDisconnectedUser() + " is leaving the game";
    }

}
