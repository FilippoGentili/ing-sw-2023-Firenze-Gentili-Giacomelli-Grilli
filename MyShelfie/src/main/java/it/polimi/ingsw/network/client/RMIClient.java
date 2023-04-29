package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Server.MatchImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient extends MatchImpl {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1");
        MatchImpl client = (MatchImpl) registry.lookup("server");



    }


}
