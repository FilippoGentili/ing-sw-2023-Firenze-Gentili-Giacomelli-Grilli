package it.polimi.ingsw.network.Message;

public class Ping extends Message{
    /**
     * Message used from the client to let the server know it's there
     */
    public Ping(){
        super(null, MessageType.PING);
    }
}
