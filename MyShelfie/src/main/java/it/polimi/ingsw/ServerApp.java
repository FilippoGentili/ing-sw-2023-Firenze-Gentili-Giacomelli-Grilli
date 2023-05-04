package it.polimi.ingsw;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Server.Server;

import static it.polimi.ingsw.Network.Server.Server.startRMIServer;
import static it.polimi.ingsw.Network.Server.Server.startSocketServer;

public class ServerApp {

    public static void main(String[] args) {

        Server server = new Server();
        GameController gameController = new GameController();

        boolean rmi = false;

        for(String arg : args){
            if(arg.equals("-rmi")){
                rmi = true;
                break;
            }
        }

        if(rmi){
            startRMIServer();
        }else{
            startSocketServer();
        }

    }
}
