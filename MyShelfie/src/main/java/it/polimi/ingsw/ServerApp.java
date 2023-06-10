package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.Server;


public class ServerApp {

    public static void main(String[] args) {

        if(args.length > 1 && args[1].equals("-r")){
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
