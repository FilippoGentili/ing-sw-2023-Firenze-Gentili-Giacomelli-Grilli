package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.View.Cli;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws IOException {

            boolean cliCheck = false;
            boolean guiCheck = false;

            System.out.println("How do you want to play?");
            System.out.println("Type '-cli' or '-gui'");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            while (!input.equals("-cli") && !input.equals("-gui")) {
                System.out.println("Invalid statement!");
                System.out.println("Type '-cli' or '-gui'");
                input = scanner.nextLine().trim();
            }

            if (input.equals("-cli")) {
                cliCheck = true;
            } else if (input.equals("-gui")) {
                guiCheck = true;
            }

            if (cliCheck) {
                Cli view = new Cli();
                ClientController clientController = new ClientController(view);
                view.addObserver(clientController);
                view.start();
            }
            if (guiCheck) {
                //gui
                System.out.println("ciao");
            }
        }
}
