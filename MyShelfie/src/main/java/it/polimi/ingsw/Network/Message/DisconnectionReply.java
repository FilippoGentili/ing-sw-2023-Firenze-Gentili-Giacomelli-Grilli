package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class DisconnectionReply extends Message{

    private String disconnectedUser;
    public DisconnectionReply(String username) {
        super(LivingRoom.getInstance().getServerName(), MessageType.DISCONNECTION_REPLY);
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
