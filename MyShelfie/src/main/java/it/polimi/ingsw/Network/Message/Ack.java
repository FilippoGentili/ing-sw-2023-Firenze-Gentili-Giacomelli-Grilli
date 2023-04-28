package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class Ack extends Message{
    /**
     * Message used to answer the ping
     */
    public Ack() {
        super(LivingRoom.getInstance().getServerName(), MessageType.ACK);
    }
}
