package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;
import java.util.HashMap;

public class ScoreBoardMessage extends Message{

    private static final long serialVersionUID = 8143302299525296710L;
    HashMap<String, Integer> scoreboard;

    public ScoreBoardMessage(HashMap<String, Integer> scoreboard) {
        super(Game.getServerName(), MessageType.PLAYER_MESSAGE);
        this.scoreboard = scoreboard;
    }

    public HashMap<String, Integer> getScoreboard(){
        return scoreboard;
    }
}
