package it.polimi.ingsw.Network.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import it.polimi.ingsw.Network.Server.Match;
import it.polimi.ingsw.Network.Server.MatchImpl;

import java.util.Scanner;

public class RMIClient extends MatchImpl {

    public RMIClient() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1");
        MatchImpl client = (MatchImpl) registry.lookup("server");

    }

    public void sendMessage(Message message){
        //manda un messaggio al server
    }


}

