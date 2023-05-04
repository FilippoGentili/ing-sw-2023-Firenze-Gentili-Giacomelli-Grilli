package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.View.Cli;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws RemoteException {

        boolean cliCheck = false;

        /*for(String arg : args) {
            if (arg.equals("-cli")) {
                cliCheck = true;
                break;
            }
        }*/

        System.out.println("If you want to start a cli write '-cli' ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.equals("-cli")) {
            cliCheck = true;
        }

        if(cliCheck){
            Cli view = new Cli();
            ClientController clientController = new ClientController(view);
            view.addObserver(clientController);
            view.start();
        }/*else{
            //gui
        }*/

    }
}
