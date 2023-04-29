package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class LoginReply extends Message{

    private static final long serialVersionUID = -9191023129086531699L;
    private final boolean nicknameAccepted;
    private final boolean successfulAccess;
    private final String nicknameinserted;

    /**
     * Message used to respond to a login request from the Server to the Client
     * @param nicknameAccepted
     * @param successfulAccess
     */
    public LoginReply(boolean nicknameAccepted, boolean successfulAccess, String nickname) {
        super(Game.getServerName(), MessageType.LOGIN_REPLY);
        this.nicknameAccepted=nicknameAccepted;
        this.successfulAccess=successfulAccess;
        this.nicknameinserted = nickname;
    }

    public boolean isSuccessfulAccess(){
        return successfulAccess;
    }

    public boolean isNicknameAccepted(){
        return nicknameAccepted;
    }

    public String getNicknameLogged(){
        return nicknameinserted;
    }

    @Override
     public String toString(){
        return "Client " + getNicknameLogged() + " successful access = " + isSuccessfulAccess()
                + " nickname accepted = " + isNicknameAccepted();
    }

}
