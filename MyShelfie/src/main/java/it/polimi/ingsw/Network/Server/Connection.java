package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

public abstract class Connection {
    public boolean isConnected = true;

    public boolean checkConnection(){
        return isConnected;
    }

    public abstract void disconnectClient();

    public abstract void sendMessage(Message message);

    public abstract void ping();

}
