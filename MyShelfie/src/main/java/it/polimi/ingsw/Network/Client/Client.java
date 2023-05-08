package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Client extends UnicastRemoteObject, Observable {

    private final String nickname;
    private final String address;
    private final int port;

    Client(String nickname, String address, int port) throws RemoteException{
        this.nickname = nickname;
        this.address = address;
        this.port = port;
    }

    String getNickname(){
        return nickname;
    }

    String getAddress(){
        return address;
    }

    int getPort(){
        return port;
    }

    abstract void startRMIClient() throws Exception;

    abstract void closeConnection() throws Exception;

    abstract void sendMessage(Message message) throws IOException;

}
