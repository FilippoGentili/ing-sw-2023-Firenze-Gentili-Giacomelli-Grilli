package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class MatchInfo extends Message{
    private final String ActivePlayer;
    private final ArrayList<Player> players;
    public MatchInfo(String nickname, ArrayList<Player> players) {
        super(nickname, MessageType.MATCH_INFO);
        this.ActivePlayer = nickname;
        this.players = players;
    }

    public String getActivePlayer() {
        return ActivePlayer;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    @Override
    public String toString(){
        return "" + getActivePlayer() + "is the active player, the other players are " + getPlayers();
    }
}
