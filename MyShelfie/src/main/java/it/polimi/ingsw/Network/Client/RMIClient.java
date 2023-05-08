package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient{
        public static void main(String[] args) throws RemoteException, NotBoundException {
                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
                MatchServer matchServer = (MatchServer) registry.lookup("//localhost/MatchServer");
        }
}

