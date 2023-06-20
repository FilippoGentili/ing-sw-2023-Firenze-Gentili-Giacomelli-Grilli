package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;

public class UpdateGuiPointsMessage extends Message{

    @Serial
    private static final long serialVersionUID = 9015967703429549955L;
    private Game game;

    public UpdateGuiPointsMessage(Game game) {
        super(Game.getServerName(), MessageType.UPDATEGUIPOINTS_MESSAGE);
    }

    public Game getGame(){
        return game;
    }
}
