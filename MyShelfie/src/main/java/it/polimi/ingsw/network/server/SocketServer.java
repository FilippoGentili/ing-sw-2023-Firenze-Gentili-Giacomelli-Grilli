package it.polimi.ingsw.network.server;

import it.polimi.ingsw.network.Match;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SocketServer {
    public static void main(String[] args) {
        try {
            MatchImpl match = new MatchImpl();
            Match stub = (Match) UnicastRemoteObject.exportObject(match, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Game", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
