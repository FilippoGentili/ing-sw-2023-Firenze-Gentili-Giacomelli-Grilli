package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

/**
 * Message used to notify the clients that the game has started
 */
public class GameStartedMessage extends Message{

    private static final long serialVersionUID = 1561724725228822352L;

    private Game game;
    private ArrayList<Player> players;
    public GameStartedMessage(Game game) {
        super(Game.getServerName(), MessageType.GAME_STARTED);
        this.game = game;
    }

    public Game getGame(){
        return game;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    @Override
    public String toString(){return "Game started!\nWhenever you want to send a chat message, write 'open chat'";
    }
}
