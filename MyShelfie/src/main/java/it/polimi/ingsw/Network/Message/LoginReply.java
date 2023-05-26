package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class LoginReply extends Message {

    private static final long serialVersionUID = -9191023129086531699L;
    private String nickname;

    public LoginReply(String nickname) {
        super(Game.getServerName(), MessageType.LOGIN_REPLY);
        this.nickname=nickname;
    }

    public String getNickname(){
        return nickname;
    }


    @Override
    public String toString() {
        return "Hello " + getNickname() + " you are connected to the server!";
    }
}
