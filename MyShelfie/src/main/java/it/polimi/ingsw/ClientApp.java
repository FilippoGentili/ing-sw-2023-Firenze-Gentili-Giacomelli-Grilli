package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.View.Cli;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws IOException {

        boolean cliCheck = false;

        System.out.println("If you want to start a cli write '-cli' ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        while(!input.equals("-cli")){
            System.out.println("Invalid statement!");
            System.out.println("If you want to start a cli write '-cli' ");
            input = scanner.nextLine().trim();
        }

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
