package it.polimi.ingsw;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Server.RMI.RMIServer;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.Network.Server.SocketServer;


public class ServerApp {

    public static void main(String[] args) {
        Server server = new Server();

        server.startServers();
    }
}
