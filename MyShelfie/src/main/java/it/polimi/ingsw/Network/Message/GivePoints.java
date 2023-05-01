package it.polimi.ingsw.Network.Message;


import it.polimi.ingsw.Model.Game;

public class GivePoints extends Message{
    private static final long serialVersionUID = 6172630014346767975L;
    private final int points;
    private final String player;

    /**
     * This message is sent from the server to the client to let it know how many points it's been given
     * @param nickname
     * @param points
     */
    public GivePoints(String nickname, int points) {
        super(Game.getServerName(), MessageType.GIVE_POINTS);
        this.points=points;
        this.player=nickname;
    }

    public int getPoints(){
        return points;
    }

    public String getPlayer(){
        return player;
    }

    @Override
    public String toString(){
        return " " + getPlayer() + "receives " + getPoints() + "points";
    }
}
