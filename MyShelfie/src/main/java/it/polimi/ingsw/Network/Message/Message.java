package it.polimi.ingsw.Network.Message;

import java.io.Serializable;

public abstract class Message implements Serializable {
        private static final long serialVersionUID = -4873567285652677918L;
        private final String nickname;
        private final MessageType type;
        private byte[] data;

    /**
     * Constructor for the message
     * @param nickname
     * @param messageType
     */
    public Message(String nickname, MessageType messageType/*byte[] data*/){
            this.nickname = nickname;
            this.type = messageType;
            /*this.data = data;*/
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

        /*public byte[] getData() {
             return data;
        }

         */

        /*public void setData(byte[] data) {
             this.data = data;
         }

         */
}


/* In socket client e socket server aggiungere:
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;

    this.outputStm = new ObjectOutputStream(socket.getOutputStream());
    this.inputStm = new ObjectInputStream(socket.getInputStream());
 */

