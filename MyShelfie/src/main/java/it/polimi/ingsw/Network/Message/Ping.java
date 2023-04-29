package it.polimi.ingsw.Network.Message;

public class Ping extends Message{
    /**
     * Message used from the Client to let the Server know it's there
     */
    public Ping(){
        super(null, MessageType.PING);
    }

}
