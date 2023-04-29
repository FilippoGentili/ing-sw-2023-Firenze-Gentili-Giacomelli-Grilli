package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class LoginReply extends Message{

    private final boolean nicknameAccepted;
    private final boolean successfulAccess;

    /**
     * Message used to respond to a login request from the Server to the Client
     * @param nicknameAccepted
     * @param successfulAccess
     */
    public LoginReply(boolean nicknameAccepted, boolean successfulAccess) {
        super(Game.getServerName(), MessageType.LOGIN_REPLY);
        this.nicknameAccepted=nicknameAccepted;
        this.successfulAccess=successfulAccess;
    }

    public boolean isSuccessfulAccess(){
        return successfulAccess;
    }

    public boolean isNicknameAccepted(){
        return nicknameAccepted;
    }


}
