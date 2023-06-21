package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class PlayerMessage extends Message{
    @Serial
    private static final long serialVersionUID = -3151757445271032920L;
    Player player;

    /**
     * Message used to get the player from the server
     * @param player
     */
    public PlayerMessage(Player player) {
        super(Game.getServerName(), MessageType.PLAYER_MESSAGE);
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

}
