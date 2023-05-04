package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;

public class ChosenTilesRequest extends Message{
    private static final long serialVersionUID = 4031065487697271641L;
    private LivingRoom livingroom;

    /**
     * Message from server to client used to ask the client to choose the tiles from the livingroom, sent as a parameter
     * @param livingroom
     */
    public ChosenTilesRequest(LivingRoom livingroom) {
        super(Game.getServerName(), MessageType.CHOSEN_TILES_REQUEST);
        this.livingroom=livingroom;
    }

    public LivingRoom getLivingroom(){
        return livingroom;
    }
}
