package it.polimi.ingsw.Network.Message;

public class DisconnectionRequest extends Message{
    private final String disconnectedUser;

    public DisconnectionRequest(String username) {
        super(username, MessageType.DISCONNECTION_REQUEST);
        this.disconnectedUser=username;
    }

    public String getDisconnectedUser(){
        return disconnectedUser;
    }

    public String toString(){
        return " " + getDisconnectedUser() + " wants to quit the game";
    }

}
