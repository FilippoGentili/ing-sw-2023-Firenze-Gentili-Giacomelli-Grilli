package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class WaitingRoomMessage extends Message{
    private static final long serialVersionUID = -7965460809484303772L;
   private final int maxPlayers;


    public WaitingRoomMessage(int maxPlayers) {
        super(Game.getServerName(), MessageType.WAITING_ROOM);
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

}
