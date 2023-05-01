package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Network.Message.*;

public class Ack extends Message {
        private static final long serialVersionUID = -2255063192863940862L;

        /**
         * Message used to answer the ping
         */
        public Ack() {
            super(Game.getServerName(), MessageType.ACK);
        }

    }

