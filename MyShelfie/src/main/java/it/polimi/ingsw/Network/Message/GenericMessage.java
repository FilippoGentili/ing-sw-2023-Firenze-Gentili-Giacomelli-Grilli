package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class GenericMessage extends Message{

    private static final long serialVersionUID = -4683872130244249855L;
    private final String message;

    /**
     * Message used to communicate a generic string
     * @param messageContent
     */
    public GenericMessage(String messageContent) {
        super(Game.getServerName(), MessageType.GENERIC_MESSAGE);
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

