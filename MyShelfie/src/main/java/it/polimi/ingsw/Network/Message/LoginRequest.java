package it.polimi.ingsw.Network.Message;

public class LoginRequest extends Message{

    private static final long serialVersionUID = -3722112110076890446L;

    /**
     * Message from the Client to the Server to try to connect
     * @param username
     */
    public LoginRequest(String username) {
        super(username, MessageType.LOGIN_REQUEST);
    }
    @Override
    public String toString(){
        return "LoginRequest from: " + getNickname();
    }

}
