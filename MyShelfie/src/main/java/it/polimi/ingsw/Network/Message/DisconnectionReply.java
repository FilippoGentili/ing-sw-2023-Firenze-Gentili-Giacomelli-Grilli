package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class DisconnectionReply extends Message{
    private static final long serialVersionUID = -1754601960629355380L;
    private final String disconnectedUser;

    /**
     * Message sent from the server to the clients letting them know a player is disconnecting
     * @param username
     */
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
