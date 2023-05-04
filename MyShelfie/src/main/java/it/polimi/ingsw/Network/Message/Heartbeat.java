package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class Heartbeat extends Message{

    public Heartbeat(){
        super(Game.getServerName(), MessageType.HEARTBEAT);
    }
}
