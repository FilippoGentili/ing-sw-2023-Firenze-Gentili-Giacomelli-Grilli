package it.polimi.ingsw.Network.Message;

import java.io.Serial;

public class DisconnectionResult extends Message{

    @Serial
    private static final long serialVersionUID = -3448532578543465797L;
    private final String disconnectedUser;

    /**
     * Constructor for the message
     */
    public DisconnectionResult(String username) {
        super(username, MessageType.DISCONNECTION_RESULT);
        this.disconnectedUser = username;
    }
}
