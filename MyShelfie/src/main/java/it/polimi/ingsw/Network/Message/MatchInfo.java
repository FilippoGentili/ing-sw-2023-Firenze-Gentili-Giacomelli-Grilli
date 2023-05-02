package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class MatchInfo extends Message{
    private static final long serialVersionUID = 6955347987257164619L;
    private final String activePlayer;
    private final ArrayList<Player> players;

    /**
     * Message used to update the clients on the ongoing match
     * @param players
     * @param activePlayer
     */
    public MatchInfo(ArrayList<Player> players, String activePlayer) {
        super(Game.getServerName(), MessageType.MATCH_INFO);
        this.activePlayer = activePlayer;
        this.players = players;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    @Override
    public String toString(){
        return "" + getActivePlayer() + "is the active player, the other players are " + getPlayers();
    }
}


