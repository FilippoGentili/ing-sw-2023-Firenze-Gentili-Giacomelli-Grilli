package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

public class PlayerMessage extends Message{
    Player player;
    public PlayerMessage(Player player) {
        super(Game.getServerName(), MessageType.PLAYER_MESSAGE);
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

}
