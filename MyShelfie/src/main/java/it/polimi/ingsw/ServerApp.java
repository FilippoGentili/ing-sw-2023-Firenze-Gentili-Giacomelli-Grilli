package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.RMI.RMIServer;
import it.polimi.ingsw.Network.Server.SocketServer;


public class ServerApp {

    public static void main(String[] args) {

        RMIServer rs = new RMIServer();
        rs.run();

        int port = 49674;
        SocketServer ss = new SocketServer(port);
        ss.run();
    }
}
