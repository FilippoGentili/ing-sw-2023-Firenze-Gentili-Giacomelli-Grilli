package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class NumOfPlayersRequest extends Message{
    private static final long serialVersionUID = -6565070052540678653L;

    /**
     * Message from the Server to the Client to ask for the number of players
     */
    public NumOfPlayersRequest() {
        super(Game.getServerName(), MessageType.NUM_OF_PLAYERS_REQUEST);
    }
}
