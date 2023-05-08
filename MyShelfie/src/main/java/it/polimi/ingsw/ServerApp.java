package it.polimi.ingsw;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Server.RMIServer;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.Network.Server.SocketServer;

import java.util.Scanner;



public class ServerApp {

    public static void main(String[] args) {

        GameController gameController = new GameController();
        Server server = new Server(gameController);

        System.out.println("If you want to start an rmi server write '-rmi' ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        boolean rmi = false;

        if(input.equals("-rmi"))
            rmi = true;

        if(rmi){
            RMIServer rs = new RMIServer(server);
            rs.startRMIServer();
        }else{
            SocketServer ss = new SocketServer(server);
            ss.run();
        }

    }
}
