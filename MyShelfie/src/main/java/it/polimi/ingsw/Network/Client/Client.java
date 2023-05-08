package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Client extends Observable{

    public abstract void disconnect();

    public abstract void sendMessage(Message message);

    public abstract void readMessage();

    public abstract void pinger(boolean on);

}
