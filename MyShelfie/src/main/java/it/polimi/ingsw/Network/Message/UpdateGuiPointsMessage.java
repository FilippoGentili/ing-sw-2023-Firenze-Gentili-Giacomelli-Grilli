package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;

public class UpdateGuiPointsMessage extends Message{

    @Serial
    private static final long serialVersionUID = 9015967703429549955L;
    private Game game;
    private int previousPoints1;
    private int previousPoints2;

    public UpdateGuiPointsMessage(Game game, int previousPoints1, int previousPoints2) {
        super(Game.getServerName(), MessageType.UPDATEGUIPOINTS_MESSAGE);
        this.game = game;
        this.previousPoints1 = previousPoints1;
        this.previousPoints2 = previousPoints2;
    }
    public Game getGame(){
        return game;
    }

    public int getPreviousPoints1() {
        return previousPoints1;
    }

    public int getPreviousPoints2() {
        return previousPoints2;
    }
}
