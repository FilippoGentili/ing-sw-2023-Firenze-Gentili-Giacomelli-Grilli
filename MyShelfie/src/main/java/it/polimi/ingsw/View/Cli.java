package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.ClientController;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Cli {

    private ClientController clientController;

    private final PrintStream out;

    public Cli(){
        out = System.out;
    }

    public String readLine(){
        //da sistemare con i thread
    }

    public void start(){
        out.println("Welcome to MyShelfie!");

        try{
            printServerInfo();
        } catch (ExecutionException e) {
            out.println("STR_INPUT_CANCELED");
        }
    }

    public void printServerInfo(){
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "1099"; //da cambiare forse
        boolean valid;

        do{
            out.println("Specify the address");
            System.out.println("Default address value -> " + defaultAddress);

            String address = readLine();
            if (address.equals("")) {
                serverInfo.put("address", defaultAddress);
                valid = true;
            } else if (clientController.validIP(address)) {
                serverInfo.put("address", address);
                valid = true;
            } else {
                out.println("Invalid address!");
                out.flush();
                valid = false;
            }
        }while(!valid);

        do{
            out.println("Specify the port");
            System.out.println("Default port value -> " + defaultAddress);

            String port = readLine();
            if (port.equals("")) {
                serverInfo.put("port", defaultPort);
                valid = true;
            } else if (clientController.validPort(port)) {
                serverInfo.put("port", port);
                valid = true;
            } else {
                out.println("Invalid port!");
                out.flush();
                valid = false;
            }
        }while(!valid);

        //notifyObserver(obs -> obs.onUpdateServerInfo(serverInfo));
    }






}
