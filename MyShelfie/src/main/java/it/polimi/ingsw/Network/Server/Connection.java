package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Message.Message;

import java.rmi.RemoteException;

public abstract class Connection {
    public boolean isConnected = true;

    /**
     * Boolean used to check the connection status
     * @return true if the client is connected, false otherwise
     */
    public boolean checkConnection(){
        return isConnected;
    }

    /**
     * Sets connection boolean to false after disconnection
     */
    public void setIsConnected(){
        isConnected=false;
    }

    /**
     * Disconnects a client from server
     * @throws RemoteException
     */
    public abstract void disconnectClient() throws RemoteException;

    /**
     * Sends message
     * @param message to be sent
     */
    public abstract void sendMessage(Message message);

    /**
     * Ping method used verify the connection
     * @throws RemoteException
     */
    public abstract void ping() throws RemoteException;
}
