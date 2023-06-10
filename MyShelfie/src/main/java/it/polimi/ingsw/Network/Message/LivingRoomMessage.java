package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;

public class LivingRoomMessage extends Message{
    private static final long serialVersionUID = -7965460809484303772L;
    private LivingRoom livingroom;

    /**
     * Message used to print the current status of the living room
     * @param livingroom
     */
    public LivingRoomMessage(LivingRoom livingroom) {
        super(Game.getServerName(), MessageType.LIVING_ROOM);
        this.livingroom=livingroom;
    }

    public LivingRoom getLivingRoom(){
        return livingroom;
    }

}

