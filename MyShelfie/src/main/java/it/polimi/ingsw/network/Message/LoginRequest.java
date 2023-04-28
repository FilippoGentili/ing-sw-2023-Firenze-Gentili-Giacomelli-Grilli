package it.polimi.ingsw.network.Message;

public class LoginRequest extends Message{
    /**
     * Message from the client to the server to try to connect
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
