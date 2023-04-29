package it.polimi.ingsw.Network.Message;

public class Ping extends Message{
    private static final long serialVersionUID = -3279996595011591573L;

    /**
     * Message used from the Client to let the Server know it's there
     */
    public Ping(){
        super(null, MessageType.PING);
    }

}
