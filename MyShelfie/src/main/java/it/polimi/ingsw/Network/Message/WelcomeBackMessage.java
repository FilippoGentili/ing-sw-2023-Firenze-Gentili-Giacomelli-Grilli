package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

import java.io.Serial;

public class WelcomeBackMessage extends Message {

    @Serial
    private static final long serialVersionUID = 9014383118592771811L;
    private final String nickname;

    /**
     * Message used in persistence when the game is reloaded
     * @param nickname
     */
    public WelcomeBackMessage(String nickname) {
        super(Game.getServerName(), MessageType.WELCOMEBACK_MESSAGE);
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    @Override
    public String toString() {
        return "Welcome back " + nickname;
    }
}
