package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;


public class TurnMessage extends Message{

    private static final long serialVersionUID = -4942518809156302921L;
    private Player player;

    /**
     * Constructor for the message
     *
     * @param player that is now playing
     * @param messageType TurnMessage
     */
    public TurnMessage(Player player, MessageType messageType) {
        super(Game.getServerName(), MessageType.Turn_Message);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
