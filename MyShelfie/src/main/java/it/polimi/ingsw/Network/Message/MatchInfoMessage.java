package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;

import java.util.List;

public class MatchInfoMessage extends Message{

    private LivingRoom livingroom;
    private List<Player> players;

    public MatchInfoMessage(LivingRoom livingRoom, List<Player> players) {
        super(Game.getServerName(), MessageType.MATCH_INFO);
        this.livingroom = livingRoom;
        this.players = players;
    }
}
