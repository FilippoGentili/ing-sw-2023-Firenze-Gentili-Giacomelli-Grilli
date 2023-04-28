package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class DisconnectionReply extends Message{
    public String disconnectedUser;
    public DisconnectionReply() {
        super(LivingRoom.getInstance().getServerName(), MessageType.DISCONNECTION_REPLY);
    }
}
