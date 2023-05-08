package it.polimi.ingsw;

import java.util.Scanner;

import static it.polimi.ingsw.Network.Server.Server.startRMIServer;
import static it.polimi.ingsw.Network.Server.Server.startSocketServer;

public class ServerApp {

    public static void main(String[] args) {

        Server server = new Server();
        //GameController gameController = new GameController();

        System.out.println("If you want to start an rmi server write '-rmi' ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        boolean rmi = false;

        if(input.equals("-rmi"))
            rmi = true;

        if(rmi){
            startRMIServer();
        }else{
            startSocketServer();
        }

    }
}
