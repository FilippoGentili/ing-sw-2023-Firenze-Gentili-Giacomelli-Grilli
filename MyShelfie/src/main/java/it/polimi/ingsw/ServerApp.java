package it.polimi.ingsw;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.Network.Server.SocketServer;
import it.polimi.ingsw.Network.Server.RMIServer;

import java.util.Scanner;



public class ServerApp {

    public static void main(String[] args) {

        boolean rmi = false;
        boolean socket = false;

        GameController gameController = new GameController();
        Server server = new Server(gameController);

        System.out.println("Which type of connection do you want to use?");
        System.out.println("Type -rmi or -socket");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        while(!input.equals("-rmi") && !input.equals("-socket")){
            System.out.println("Invalid statement!");
            System.out.println("Type -rmi or -socket");
            input = scanner.nextLine().trim();
        }

        if(input.equals("-rmi"))
            rmi = true;

        if(input.equals("-socket"))
            socket = true;

        if(rmi){
            RMIServer rs = new RMIServer(server);
            rs.run();
        }else if(socket) {
            SocketServer ss = new SocketServer(server);
            ss.run();
        }
    }
}
