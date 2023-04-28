package it.polimi.ingsw.network.Message;

public class Ping extends Message{
    public Ping(){
        super(null, MessageType.PING);
    }
}
