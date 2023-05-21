package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class GameStateMessage extends Message{

    @Serial
    private static final long serialVersionUID = -5330570225065099425L;
    private Player player;
    private Game game;

    public GameStateMessage(Player player, Game game) {
        super(Game.getServerName(),MessageType.GAME_STATE);
        this.player=player;
        this.game=game;
    }

    public Game getGame(){
        return game;
    }

    public Player getPlayer(){
        return player;
    }


}
