package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;
import java.util.ArrayList;

public class EndGameMessage extends Message{

    @Serial
    private static final long serialVersionUID = 8117319563877710421L;
    private ArrayList<Player> scoreboard;
    private String winner;
    /**
     * Constructor for the message
     *
     * 
     */
    public EndGameMessage(ArrayList<Player> scoreboard, String winner) {
        super(Game.getServerName(), MessageType.ENDGAME_MESSAGE);
        
        this.scoreboard = scoreboard;
        this.winner = winner;
    }
    
    public ArrayList<Player> getScoreboard(){
        return scoreboard;
    }
    
    public String getWinner(){
        return winner;
    }
}
