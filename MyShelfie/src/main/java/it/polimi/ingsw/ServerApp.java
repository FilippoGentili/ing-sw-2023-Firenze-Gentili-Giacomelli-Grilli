package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.Server;

import java.util.Scanner;


public class ServerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if(input.equalsIgnoreCase("r")){
            Server server = new Server(true);
            Server.LOGGER.info("Loading an existing match");
            server.startServers();
        }else{
            Server server = new Server();
            Server.LOGGER.info("Creating a new match");
            server.startServers();
        }

    }
}
