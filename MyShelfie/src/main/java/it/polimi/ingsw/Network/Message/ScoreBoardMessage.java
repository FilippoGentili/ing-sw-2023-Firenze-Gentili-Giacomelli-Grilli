package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class ScoreBoardMessage extends Message{

    private static final long serialVersionUID = 8143302299525296710L;
    private final ArrayList<Player> scoreboard;

    public ScoreBoardMessage(ArrayList<Player> scoreboard) {
        super(Game.getServerName(), MessageType.SCOREBOARD_MESSAGE);
        this.scoreboard = scoreboard;
    }

    public ArrayList<Player> getScoreboard(){
        return scoreboard;
    }
}
