package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.Model.LivingRoom;

public class LoginReply extends Message{

    private final boolean nicknameAccepted;
    private final boolean successfulAccess;

    /**
     * Message used to respond to a login request from the server to the client
     * @param nicknameAccepted
     * @param successfulAccess
     */
    public LoginReply(boolean nicknameAccepted, boolean successfulAccess) {
        super(LivingRoom.getInstance().getServerName(), MessageType.LOGIN_REPLY);
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
