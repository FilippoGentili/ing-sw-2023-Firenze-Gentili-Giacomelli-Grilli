package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class LoginResult extends Message{
    private static final long serialVersionUID = 2142301885464609677L;
    private final boolean nicknameAccepted;
    private final boolean successfulAccess;
    private final String chosenNickname;

    /**
     * Message used to communicate the login's status
     * @param nickname
     * @param nicknameAccepted
     * @param successfulAccess
     */
    public LoginResult(String nickname,boolean nicknameAccepted, boolean successfulAccess) {
        super(Game.getServerName(), MessageType.LOGIN_RESULT);
        this.chosenNickname= nickname;
        this.nicknameAccepted = nicknameAccepted;
        this.successfulAccess = successfulAccess;
    }

    public boolean isSuccessfulAccess() {
        return successfulAccess;
    }

    public boolean isNicknameAccepted() {
        return nicknameAccepted;
    }

    public String getChosenNickname(){
        return chosenNickname;
    }

    @Override
    public String toString() {
        return "Successful access = " + isSuccessfulAccess() + ", nickname accepted = " + isNicknameAccepted() + ", chosenNickname = " +getChosenNickname();
    }
}
