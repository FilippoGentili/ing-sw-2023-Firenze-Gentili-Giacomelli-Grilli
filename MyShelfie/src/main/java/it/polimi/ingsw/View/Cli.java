package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.ConnectionRequest;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Observer.ViewObservable;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static java.lang.Integer.parseInt;

public class Cli extends ViewObservable implements View{

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
        out.println("\n" +
                " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| | ____    ____ | || |  ____  ____  | || |    _______   | || |  ____  ____  | || |  _________   | || |   _____      | || |  _________   | || |     _____    | || |  _________   | |\n" +
                "| ||_   \\  /   _|| || | |_  _||_  _| | || |   /  ___  |  | || | |_   ||   _| | || | |_   ___  |  | || |  |_   _|     | || | |_   ___  |  | || |    |_   _|   | || | |_   ___  |  | |\n" +
                "| |  |   \\/   |  | || |   \\ \\  / /   | || |  |  (__ \\_|  | || |   | |__| |   | || |   | |_  \\_|  | || |    | |       | || |   | |_  \\_|  | || |      | |     | || |   | |_  \\_|  | |\n" +
                "| |  | |\\  /| |  | || |    \\ \\/ /    | || |   '.___`-.   | || |   |  __  |   | || |   |  _|  _   | || |    | |   _   | || |   |  _|      | || |      | |     | || |   |  _|  _   | |\n" +
                "| | _| |_\\/_| |_ | || |    _|  |_    | || |  |`\\____) |  | || |  _| |  | |_  | || |  _| |___/ |  | || |   _| |__/ |  | || |  _| |_       | || |     _| |_    | || |  _| |___/ |  | |\n" +
                "| ||_____||_____|| || |   |______|   | || |  |_______.'  | || | |____||____| | || | |_________|  | || |  |________|  | || | |_____|      | || |    |_____|   | || | |_________|  | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n");

        serverInfo();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void serverInfo(){
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "1099"; //da cambiare forse
        boolean valid;
        String address;
        String port;

        do{
            out.println("Specify the address");
            System.out.println("Default address value -> " + defaultAddress);

            address = readLine();
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

            port = readLine();
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

        notifyObserver(obs -> obs.updateServerInfo(serverInfo));
    }
    @Override
    public void nicknameRequest(){
        String nickname;
        System.out.println("Insert your nickname: ");
        nickname=readLine();
        notifyObserver(obs -> obs.updateNickname(nickname));
    }

    @Override
    public void askNumberOfPlayers() {
        int num;
        System.out.println("Insert the number of players you want to play with: ");
        num = checkValidNumOfPlayers();
        notifyObserver(obs -> obs.updateNumOfPlayers(num));
    }

    public int checkValidNumOfPlayers(){
        int num;
        do{
            num = parseInt(readLine());
            if(num<2 || num>4)
                System.out.println("Invalid number of players! Enter a number between 2 and 4:");

        }while(num<2 || num>4);

        return num;
    }

    @Override
    public void TilesRequest() {
        HashMap<Integer, Integer> chosenTilesIndex = new HashMap<>();
        int row;
        int col;
        String input;

        System.out.println("Choose up to 3 tiles from the board. Insert the coordinates of the tiles you want to choose: ");
        int i=1;
        boolean valid = true;

        while(i<4 && valid){
            System.out.println(i+":");
            do{
                System.out.println("row: ");
                row = parseInt(readLine());
                if(row<0 || row>8)
                    System.out.println("Index out of bound. Please insert a number between 0 and 8");
            }while(row<0 || row>8);
            do{
                System.out.println("column: ");
                col = parseInt(readLine());
                if(col<0 || col>8)
                    System.out.println("Index out of bound. Please insert a number between 0 and 8");
            }while(col<0 || col>8);
            chosenTilesIndex.put(row, col);
            i++;

            if(i<4){
                do{
                    System.out.println("Do you want to select another tile? (y/n)");
                    input = readLine();
                    if(input.equals("n"))
                        valid=false;
                    else if(!input.equals("y"))
                        System.out.println("Command not valid");
                }while(!input.equals("y") && !input.equals("n"))
            }
        }

        notifyObserver(obs -> obs.updateChosenTiles(chosenTilesIndex));
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) {
        int col;

        System.out.println("Insert the number of the column where you want to insert the tiles");
        System.out.println("Starting from the left: first column = 0, last column = 4");

        do{
            col = parseInt(readLine());

            if(!AvailableColumns.contains(col))
                System.out.println("Column index Not valid. Please select a column with enough space");

        }while(!AvailableColumns.contains(col));

        final int choice = col;

        notifyObserver(obs -> obs.updateChosenColumn(choice));
    }


}
