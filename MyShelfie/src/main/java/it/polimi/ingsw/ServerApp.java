package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.Server;


public class ServerApp {

    public static void main(String[] args) {

        if(args.length > 1 && args[1].equals("-r")){
            Server server = new Server();
            server.loadMatch();
        }else{
            Server server = new Server();
            server.startServers();
        }

    }
}
