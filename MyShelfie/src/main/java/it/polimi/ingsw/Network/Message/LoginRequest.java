package it.polimi.ingsw.Network.Message;

public class LoginRequest extends Message{
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
