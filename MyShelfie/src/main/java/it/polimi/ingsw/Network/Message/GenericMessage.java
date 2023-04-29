package it.polimi.ingsw.Network.Message;

public class GenericMessage extends Message{
    private final String message;

    /**
     * Message used in chat to communicate text between players
     * @param username
     */
    public GenericMessage(String username, String messageContent) {
        super(username, MessageType.GENERIC_MESSAGE);
        this.message = messageContent;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return " " + getNickname() + " : " + getMessage();
    }

}
