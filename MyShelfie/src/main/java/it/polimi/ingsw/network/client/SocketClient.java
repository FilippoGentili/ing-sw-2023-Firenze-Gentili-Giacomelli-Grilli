package it.polimi.ingsw.network.client;

import it.polimi.ingsw.network.Match;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Match match = (Match) registry.lookup("Game");
            match.startGame();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

