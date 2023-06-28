package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.Server;

import java.util.Scanner;


public class ServerApp {

    public static void main(String[] args) {

        if(args.length > 0 && args.length < 2){
            if(args[0].charAt(0) == '-' && args[0].length() == 2){
                if(args[0].charAt(1) == 'r'){
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
        /*Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if(input.equalsIgnoreCase("r")){
            Server server = new Server(true);
            Server.LOGGER.info("Loading an existing match");
            server.startServers();
        }else{
            Server server = new Server();
            Server.LOGGER.info("Creating a new match");
            server.startServers();
        }*/

    }
}
