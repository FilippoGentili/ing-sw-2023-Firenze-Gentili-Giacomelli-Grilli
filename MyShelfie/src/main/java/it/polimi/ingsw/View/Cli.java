package it.polimi.ingsw.View;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.MessageType;
import it.polimi.ingsw.Observer.ViewObservable;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
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

        //DA IMPLEMENTARE LA SCELTA TRA RMI E SOCKET

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
    public void loginResult(boolean validNickname, boolean connection, String nickname) {
        out.flush();
        if(validNickname && connection)
            System.out.println("Hello " + nickname + ", you are connected to the server!");
        else if(connection){
            System.out.println("The nickname is not valid.");
            nicknameRequest();
        }else{
            System.out.println("Connection refused");
            System.exit(1);
        }

    }

    public int indexTranslator(String input){
        switch(input){
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            default:
                System.out.println("Error");
                return 0;
        }
    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) {
        ArrayList<Tile> chosenTiles = new ArrayList<>();
        int row;
        String input;
        List<String> columns = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");

        System.out.println("Choose up to 3 tiles from the board. Insert the coordinates of the tiles you want to choose: ");
        int i=1;
        boolean valid = true;

        while(i<4 && valid){
            System.out.println(i+":");
            do{
                System.out.println("row: ");
                row = parseInt(readLine());
                if(row<1 || row>9)
                    System.out.println("Index out of bound. Please insert a number between 1 and 9");
            }while(row<1 || row>9);
            do{
                System.out.println("column: ");
                input = readLine();
                if(!columns.contains(input))
                    System.out.println("Index not valid. Please insert a character between A and I");
            }while(!columns.contains(input));

            chosenTiles.add(livingRoom.getTile(row-1, indexTranslator(input)));
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

        notifyObserver(obs -> obs.updateChosenTiles(chosenTiles));
    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) {
        String input;
        ArrayList<Tile> orderedTiles = new ArrayList<>();

        System.out.println("Choose the order of the tiles, from the bottom to the top");
        int i=1;
        boolean done = false;
        do{
            System.out.println("Here are the tiles you chose: ");
            for (Tile chosenTile : chosenTiles)
                System.out.println(chosenTile.toString());
            System.out.println("Select the " + i + " tile type:");
            input = readLine();

            if(!chosenTiles.toString().contains(input)) {
                System.out.println("You didn't choose this type of tile");
            }else{
                for (int x=0; x<chosenTiles.size() && !done; x++) {
                    if (input.equals(chosenTiles.get(x).getTileType().toString())) {
                        orderedTiles.add(chosenTiles.get(x));
                        chosenTiles.remove(x);
                        done = true;
                    }
                }
                i++;
            }
        }while(!chosenTiles.toString().contains(input));

        notifyObserver(obs -> obs.updateOrderedTiles(orderedTiles));
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) {
        int col;

        System.out.println("Insert the number of the column where you want to insert the tiles");

        do{
            col = parseInt(readLine());

            if(!AvailableColumns.contains(col-1))
                System.out.println("Column index Not valid. Please select a column with enough space");

        }while(!AvailableColumns.contains(col-1));

        final int choice = col-1;

        notifyObserver(obs -> obs.updateChosenColumn(choice));
    }


    @Override
    public void someoneDisconnected(String nickname) {
        System.out.println(nickname + " disconnected");
        System.exit(1);
    }

    @Override
    public void showListOfPlayers(ArrayList<String> nicknames) {
        System.out.println("Lobby: ");
        for(int i=1; i<=nicknames.size(); i++)
            System.out.println(i+") "+nicknames.get(i-1));
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) {
        String notValid = "%%%%%%%";
        System.out.println("LIVING ROOM");
        System.out.println("|   |   A   |   B   |   C   |   D   |   E   |   F   |   G   |   H   |   I   |");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 1 |"+notValid+"|"+notValid+"|"+notValid+"|"+livingRoom.getTile(0,3).getTileType().toCliString()+"|"+livingRoom.getTile(0,4).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|"+notValid+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 2 |"+notValid+"|"+notValid+"|"+notValid+"|"+livingRoom.getTile(1,3).getTileType().toCliString()+"|"+livingRoom.getTile(1,4).getTileType().toCliString()+"|"+livingRoom.getTile(1,5).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 3 |"+notValid+"|"+notValid+"|"+livingRoom.getTile(2,2).getTileType().toCliString()+"|"+livingRoom.getTile(2,3).getTileType().toCliString()+"|"+livingRoom.getTile(2,4).getTileType().toCliString()+"|"+livingRoom.getTile(2,5).getTileType().toCliString()+"|"+livingRoom.getTile(2,6).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 4 |"+notValid+"|"+livingRoom.getTile(3,1).getTileType().toCliString()+"|"+livingRoom.getTile(3,2).getTileType().toCliString()+"|"+livingRoom.getTile(3,3).getTileType().toCliString()+"|"+livingRoom.getTile(3,4).getTileType().toCliString()+"|"+livingRoom.getTile(3,5).getTileType().toCliString()+"|"+livingRoom.getTile(3,6).getTileType().toCliString()+"|"+livingRoom.getTile(3,7).getTileType().toCliString()+"|"+livingRoom.getTile(3,8).getTileType().toCliString()+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 5 |"+livingRoom.getTile(4,0).getTileType().toCliString()+"|"+livingRoom.getTile(4,1).getTileType().toCliString()+"|"+livingRoom.getTile(4,2).getTileType().toCliString()+"|"+livingRoom.getTile(4,3).getTileType().toCliString()+"|"+livingRoom.getTile(4,4).getTileType().toCliString()+"|"+livingRoom.getTile(4,5).getTileType().toCliString()+"|"+livingRoom.getTile(4,6).getTileType().toCliString()+"|"+livingRoom.getTile(4,7).getTileType().toCliString()+"|"+livingRoom.getTile(4,8).getTileType().toCliString()+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 6 |"+livingRoom.getTile(5,0).getTileType().toCliString()+"|"+livingRoom.getTile(5,1).getTileType().toCliString()+"|"+livingRoom.getTile(5,2).getTileType().toCliString()+"|"+livingRoom.getTile(5,3).getTileType().toCliString()+"|"+livingRoom.getTile(5,4).getTileType().toCliString()+"|"+livingRoom.getTile(5,5).getTileType().toCliString()+"|"+livingRoom.getTile(5,6).getTileType().toCliString()+"|"+livingRoom.getTile(5,7).getTileType().toCliString()+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 7 |"+notValid+"|"+notValid+"|"+livingRoom.getTile(6,2).getTileType().toCliString()+"|"+livingRoom.getTile(6,3).getTileType().toCliString()+"|"+livingRoom.getTile(6,4).getTileType().toCliString()+"|"+livingRoom.getTile(6,5).getTileType().toCliString()+"|"+livingRoom.getTile(6,6).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 8 |"+notValid+"|"+notValid+"|"+notValid+"|"+livingRoom.getTile(7,3).getTileType().toCliString()+"|"+livingRoom.getTile(7,4).getTileType().toCliString()+"|"+livingRoom.getTile(7,5).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|"+notValid+"|");
        System.out.println("----+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| 9 |"+notValid+"|"+notValid+"|"+notValid+"|"+notValid+"|"+livingRoom.getTile(8,4).getTileType().toCliString()+"|"+livingRoom.getTile(8,5).getTileType().toCliString()+"|"+notValid+"|"+notValid+"|"+notValid+"|");
        System.out.println();
    }

    @Override
    public void showBookshelf(Player player) {
        System.out.println(player.getNickname()+"'s bookshelf:");
        System.out.println("|   1   |   2   |   3   |   4   |   5   |");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(0,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(0,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(0,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(0,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(0,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(1,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(1,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(1,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(1,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(1,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(2,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(2,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(2,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(2,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(2,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(3,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(3,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(3,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(3,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(3,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(4,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(4,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(4,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(4,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(4,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+player.getBookshelf().getTile(5,0).getTileType().toCliString()+"|"+player.getBookshelf().getTile(5,1).getTileType().toCliString()+"|"+player.getBookshelf().getTile(5,2).getTileType().toCliString()+"|"+player.getBookshelf().getTile(5,3).getTileType().toCliString()+"|"+player.getBookshelf().getTile(5,4).getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println();
    }
}
