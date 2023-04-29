package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class Ack extends Message{
    /**
     * Message used to answer the ping
     */
    public Ack() {
        super(Game.getServerName(), MessageType.ACK);
    }
}
