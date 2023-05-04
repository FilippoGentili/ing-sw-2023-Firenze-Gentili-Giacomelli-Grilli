package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.View.Cli;

public class ClientApp {

    public static void main(String[] args) {

        boolean cliCheck = false;

        for(String arg : args) {
            if (arg.equals("-cli")) {
                cliCheck = true;
                break;
            }
        }

        if(cliCheck){
            Cli view = new Cli();
            ClientController clientController = new ClientController(view);
            view.addObserver(clientController);
            view.start();
        }else{
            //gui
        }

    }
}
