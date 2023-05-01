package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Tile;

import java.util.Arrays;

public class LivingRoomMessage extends Message{
    private static final long serialVersionUID = -7965460809484303772L;
    private LivingRoom livingroom;


    public LivingRoomMessage(LivingRoom livingroom) {
        super(Game.getServerName(), MessageType.LIVING_ROOM);
        this.livingroom=livingroom;
    }

    public Tile[][] getLivingRoomBoard(){
        return livingroom.getBoard();
    }

    @Override
    public String toString(){
        return "LivingRoom : " + Arrays.deepToString(getLivingRoomBoard());
    }

}

