package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.io.Serial;

public class GameState extends Message{

    @Serial
    private static final long serialVersionUID = -5330570225065099425L;
    private String nickname;
    private Game game;

    public GameState(String nickname){
        super(nickname, MessageType.GAME_STATE);
    }


}
