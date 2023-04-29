package it.polimi.ingsw.Network.Message;

public abstract class Message {
    private final String nickname;
    private final MessageType type;


    public Message(String nickname, MessageType messageType){
        this.nickname = nickname;
        this.type = messageType;
    }

    public String getNickname(){
        return nickname;
    }

    public MessageType getMessageType(){
        return type;
    }
    @Override
    public String toString(){
        return "Message from: "+ nickname + ", of type: " + type + "}";
    }

}
