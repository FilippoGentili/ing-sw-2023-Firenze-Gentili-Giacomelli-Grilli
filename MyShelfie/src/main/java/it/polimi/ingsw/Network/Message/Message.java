package it.polimi.ingsw.network.Message;

import java.io.Serializable;

public abstract class Message implements Serializable {
        private static final long serialVersionUID = -4873567285652677918L;
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

/* In socket client e socket server aggiungere:
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;

    this.outputStm = new ObjectOutputStream(socket.getOutputStream());
    this.inputStm = new ObjectInputStream(socket.getInputStream());
 */

