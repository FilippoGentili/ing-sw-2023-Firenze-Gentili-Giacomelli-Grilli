package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.ChatMessage;
import it.polimi.ingsw.Observer.ViewObservable;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Cli extends ViewObservable implements View, DisconnectionHandler {

    private final PrintStream out;
    Scanner scanner;
    private boolean myTurn = false;
    private boolean secondMessage = false;
    private boolean close = false;

    private Chat chat;

    public Cli(){
        chat = new Chat();
        out = System.out;
        scanner = new Scanner(System.in);
    }
    public String readLine(){
        return scanner.nextLine().trim();
    }
    public void start() throws IOException {
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
    public void serverInfo() {

        boolean rmi = false;
        final String address;
        final String port;

        final String SocketPort = "1098";
        final String RMIPort = "1099";
        String tempPort = SocketPort;


        //choose type of connection
        System.out.println("Which type of connection do you want to use?");
        System.out.println("Type -rmi or -socket");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        //check if input is right
        while (!input.equals("-rmi") && !input.equals("-socket")) {
            System.out.println("Invalid statement!");
            System.out.println("Type -rmi or -socket");
            input = scanner.nextLine().trim();
        }

        if (input.equals("-rmi")){
            rmi = true;
            tempPort = RMIPort;
        }

        port = tempPort;

        System.out.println("Server is going to give you the IP Address.\nPlease insert it:");
        do {
            input = scanner.nextLine().trim();
        } while (!validAddress(input, rmi));

        address = input;
        /*
        do {
            System.out.println("Insert the Server port:");
            input = scanner.nextLine().trim();
               if(!validPort(input))
                   System.out.println("Please insert a valid port");
        } while (!validPort(input));

        port = input;

         */


        if (rmi) {
            notifyObserver(obs -> {
                try {
                    obs.updateServerInfoRmi(this,address,port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            notifyObserver(obs -> {
                try {
                    obs.updateServerInfoSocket(this,address,port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }
    public boolean validAddress(String address, boolean connection){
        boolean isValid=true;
        String SocketPort = "1098";
        String RMIPort = "1099";
        boolean rmi=connection;
        boolean bc=notBroadcastAddress(address);

        if (rmi) {
            if (/*((address.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b")) || (address == null || address.equals("localhost"))) &&*/ bc) {
                try {
                    Registry registry = LocateRegistry.getRegistry(address, parseInt(RMIPort));
                    registry.list();
                } catch (RemoteException e) {
                    System.out.println("Unable to connect to RMI server");
                    isValid = false;
                }
            }else {
                isValid = false;
            }
        } else {
            if (/*((address.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b")) || (address == null || address.equals("localhost"))) &&*/ bc) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(address, parseInt(SocketPort)), 5000);
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Unable to connect to Socket server");
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        }

        if(!isValid)
            System.out.println("Invalid server address.\nPlease insert a valid server address:");

        return isValid;
    }
    public boolean notBroadcastAddress(String address){
        boolean bc=true;
        String tempAddress = address;

        if((tempAddress.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b")) || tempAddress.equals("localhost") || tempAddress==null){
            if(!tempAddress.equals("localhost") || tempAddress==null){
                tempAddress=tempAddress.substring(0, tempAddress.indexOf("."));
                if(tempAddress.equals("127")) {
                    bc = false;
                }
            }
        }else{
            bc=false;
        }


        return bc;
    }
    @Override
    public void nicknameRequest(){
        String nickname = null;
        System.out.println("Insert your nickname: ");

        do{
            nickname=readLine();

            if(nickname.equals("")){
                System.out.println("input not valid. Please insert a valid nickname: ");
            }
        }while(nickname.equals(""));

        String finalNickname = nickname;
        notifyObserver(obs -> {
            try {
                obs.updateNickname(finalNickname);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    public void askNumberOfPlayers() {
        int num;
        System.out.println("Insert the number of players you want to play with: ");
        num = checkValidNumOfPlayers();
        notifyObserver(obs -> {
            try {
                obs.updateNumOfPlayers(num);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public int checkValidNumOfPlayers(){
            int num;
            String old;

            old = readLine();

            while ((!old.matches("\\d+")) || (parseInt(old) < 2 || parseInt(old) > 4)){
                if(!old.matches("\\d+")){
                    System.out.println("Invalid input, number of players must be of type int");
                } else if((parseInt(old) < 2 || parseInt(old) > 4)){
                    System.out.println("Invalid number of players! Enter a number between 2 and 4:");
                }

                old=readLine();
            }

            num=parseInt(old);

        return num;
    }
    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) {
       out.flush();
        if(!validNickname && connection){
            System.out.println("The nickname is not valid.");
            nicknameRequest();
        }/*else{
            System.out.println("Connection refused");
            System.exit(1);
        }*/

    }
    public int indexTranslator(String input){
        switch(input){
            case "A", "a":
                return 0;
            case "B", "b":
                return 1;
            case "C", "c":
                return 2;
            case "D", "d":
                return 3;
            case "E", "e":
                return 4;
            case "F", "f":
                return 5;
            case "G", "g":
                return 6;
            case "H", "h":
                return 7;
            case "I", "i":
                return 8;
            default:
                System.out.println("Error");
                return 0;
        }
    }

    /**
     * This method is used to show the chat message
     */
    @Override
    public void showChatMessage(Chat chat) {
       /* for(Message messages: chat){
            System.out.println(messages.getSender() + ": " + messages.getMessage());
        }*/
    }

    @Override
    public void sendChatMessage(String receiver, String sender, ChatMessage message){
            notifyObserver(obs -> {
               // obs.sendChatMessage(sender, receiver, message);
            });
    }

    /**
     * This method is used for the chat
     * @param player that writes the message
     */
    public void openChat(Player player){
        String sender = player.getNickname();
        Scanner scanner = new Scanner(System.in);
        String receiver;
        boolean exists = false;
        if(!secondMessage) {
            System.out.println("Chat opened");
        }

        //prints all old messages
        if(chat.getMessages(player.getNickname()).isEmpty()){
            System.out.println("No old messages");
        }else{
            for(Message message: chat.getMessages(player.getNickname())){
                System.out.println(message.getTime() + ":" + message.getSender() + ": " + message.getMessage());
            }
        }

        //prints all players and ask who is the receiver
        System.out.println("Who is the receiver?");
        System.out.println("Write 'all players' to send a broadcast message");
        for(Player players: player.getGame().getPlayers()){
            System.out.println(players.getNickname());
        }

        //asks the receiver
        do{
            receiver = scanner.nextLine().trim();
            if(receiver.equals("close chat")){
                closeChat();
                close = true;
                break;
            }
            for(Player players: player.getGame().getPlayers()){
                if(receiver.equals("all players") || receiver.equals(players.getNickname())) {
                    exists = true;
                    break;
                }
            }
            if(!exists){
                System.out.println("Player not found, please try again");
            }
        }while(!exists);

        if(!close) {
            //asks the message
            System.out.println("Write your message: ");
            String message = scanner.nextLine().trim();

            if (message.equals("close chat")) {
                closeChat();
            }
            final String finalReceiver = receiver;

            //prints all new messages
            //showChatMessage(player.getNickname(), receiver, null);


            //another message?
            System.out.println("Do you want to write a new message?");

            String answer;
            do {
                answer = scanner.nextLine().trim();
                if (answer.equals("yes")) {
                    secondMessage = true;
                    openChat(player);
                } else if (answer.equals("no")) {
                    closeChat();
                } else {
                    System.out.println("Invalid input, type yes or no");
                }
            } while (!answer.equals("yes") && !answer.equals("no"));
        }
    }

    public void closeChat(){
        System.out.println("Chat closed");
        System.out.println("Continue where you left");
    }
    @Override
    public void TilesRequest(LivingRoom livingRoom) {

        ArrayList<Tile> chosenTiles = new ArrayList<>();
        int row;
        int col;
        String input;
        List<String> columns1 = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        List<String> columns2 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");

        System.out.println("Choose up to 3 tiles from the board. Insert the coordinates of the tiles you want to choose: ");
        int i=1;
        boolean valid = true;

        while(i<4 && valid){

            do{
                System.out.println(i+":");

                do{
                    System.out.println("row: ");
                    input = readLine().trim();
                    while(!input.matches("\\d+")){
                       // if(input.matches("open chat")){
                           // openChat();
                        //}
                        System.out.println("Input incorrect. Please insert a number between 1 and 9");
                        System.out.println("row: ");
                        input = readLine();
                    }
                    row = parseInt(input);
                    if(row<1 || row>9)
                        System.out.println("Index out of bound. Please insert a number between 1 and 9");
                }while(row<1 || row>9);
                do{
                    System.out.println("column: ");
                    input = readLine().trim();
                    if(!columns1.contains(input) && !columns2.contains(input))
                        //if(input.matches("open chat")){
                            //openChat();
                       // }
                        System.out.println("Index not valid. Please insert a character between A and I");
                }while(!columns1.contains(input) && !columns2.contains(input));

                col = indexTranslator(input);

                if(!chosenTiles.contains(livingRoom.getTile(row-1, col)) && livingRoom.getTile(row-1,col).getTileType() != TileType.NULL){
                    chosenTiles.add(livingRoom.getTile(row-1, col));
                    i++;

                    if(i<4){
                        do{
                            System.out.println("Do you want to select another tile? (y/n)");
                            input = readLine().trim();
                            //if(input.matches("open chat")){
                                //openChat();
                            //}
                            if(input.equals("n"))
                                valid=false;
                            else if(!input.equals("y"))
                                System.out.println("Command not valid");
                        }while(!input.equals("y") && !input.equals("n"));
                    }else
                        valid = false;
                }else{
                    if(livingRoom.getTile(row,col).getTileType() == TileType.NULL)
                        System.out.println("You can't select this tile");
                    else System.out.println("You already selected this tile");
                }

            }while((chosenTiles.contains(livingRoom.getTile(row-1, col)) || livingRoom.getTile(row-1,col).getTileType() == TileType.NULL) && valid);
        }

        notifyObserver(obs -> {
            try {
                obs.updateChosenTiles(chosenTiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) {
        String input;
        ArrayList<Tile> orderedTiles = new ArrayList<>();
        ArrayList<String> tilesTypes = new ArrayList<>();

        if(chosenTiles.size() > 1){
            System.out.println("Choose the order of the tiles, from the bottom to the top");
            int i=1;
            do{
                System.out.println("Here are the tiles you chose: ");
                for (Tile tile : chosenTiles){
                    tilesTypes.add(tile.getTileType().toString());
                    System.out.println(tile.getTileType().toString());
                }

                System.out.println("Select the " + i + " tile type:");
                input = readLine();

                if(!tilesTypes.contains(input)) {
                    if(input.matches("open chat")){
                       // openChat();
                    }else {
                        System.out.println("You didn't choose this type of tile");
                    }
                }else{
                    for (int x=0; x<chosenTiles.size(); x++) {
                        if (input.equals(chosenTiles.get(x).getTileType().toString())) {
                            orderedTiles.add(chosenTiles.get(x));
                            chosenTiles.remove(x);
                            tilesTypes.remove(x);
                            break;
                        }
                    }
                    i++;
                }

            }while(!chosenTiles.toString().contains(input) && chosenTiles.size()>0);
        }else{
            orderedTiles.add(chosenTiles.get(0));
        }

        notifyObserver(obs -> {
            try {
                obs.updateOrderedTiles(orderedTiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        myTurn = false;
    }
    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns, Player player) {
        boolean correct = false;
        String input;
        int col = 0;

        System.out.println("Insert the number of the column where you want to insert the tiles");

        do{
            input = readLine();


            if(input.matches("\\d+")){
                col = parseInt(input);
                correct = AvailableColumns.contains(col-1);
                if(!correct)
                    System.out.println("Column index Not valid. Please select a column with enough space");
            }else {
                if(input.matches("open chat")){
                    openChat(player);
                }else {
                    System.out.println("Input not valid. Please insert a number instead of a string");
                }
            }

        }while(!correct || !input.matches("\\d+"));

        final int choice = col-1;

        notifyObserver(obs -> {
            try {
                obs.updateChosenColumn(choice, AvailableColumns);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    public void showScoreboard(ArrayList<Player> scoreboard) {
        for(Player p : scoreboard)
            System.out.println(p.getNickname() + ": "+ p.getScore()+" points");
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
    @Override
    public void showCommonGoalCards(Game game) {

        int gc[] = new int[2];
        gc[0] = game.getCommonGoal1().getId();
        gc[1] = game.getCommonGoal2().getId();

        for(int i=0; i<2; i++){
            if(i==0){
                System.out.println("FIRST COMMON GOAL CARD:");
                System.out.println("Points: " + game.getCommonGoal1().getValue());
            }else{
                System.out.println("SECOND COMMON GOAL CARD:");
                System.out.println("Points: " + game.getCommonGoal2().getValue());
            }


            switch(gc[i]){
                case 1:
                    System.out.println("Six groups each containing at least 2 tiles of the same type (not necessarily in the depicted shape).\n" +
                            "The tiles of one group can be different from those of another group.");
                    System.out.println("+-------+");
                    System.out.println("|   =   |");
                    System.out.println("+-------+   x6");
                    System.out.println("|   =   |");
                    System.out.println("+-------+");
                    break;
                case 2:
                    System.out.println("Five tiles of the same type forming a diagonal.");
                    System.out.println("+-------+");
                    System.out.println("|   =   |");
                    System.out.println("+-------+-------+");
                    System.out.println("        |   =   |");
                    System.out.println("        +-------+-------+");
                    System.out.println("                |   =   |");
                    System.out.println("                +-------+-------+");
                    System.out.println("                        |   =   |");
                    System.out.println("                        +-------+-------+");
                    System.out.println("                                |   =   |");
                    System.out.println("                                +-------+");
                    break;
                case 3:
                    System.out.println("Four tiles of the same type in the four corners of the bookshelf.");
                    System.out.println("+-------+-----------------------+-------+");
                    System.out.println("|   =   |                       |   =   |");
                    System.out.println("+-------+                       +-------+");
                    System.out.println("|                                       |");
                    System.out.println("|                                       |");
                    System.out.println("|                                       |");
                    System.out.println("|                                       |");
                    System.out.println("|                                       |");
                    System.out.println("|                                       |");
                    System.out.println("+-------+                       +-------+");
                    System.out.println("|   =   |                       |   =   |");
                    System.out.println("+-------+-----------------------+-------+");
                    break;
                case 4:
                    System.out.println("Four lines each formed by 5 tiles of maximum three different types.\n" +
                            "One line can show the same or a different combination of another line.");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    System.out.println("|       |       |       |       |       |       x4");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    System.out.println();
                    System.out.println("        +-------+");
                    System.out.println("MAX 3   |   !=  |");
                    System.out.println("        +-------+");
                    break;
                case 5:
                    System.out.println("Four groups each containing at least 4 tiles of the same type (not necessarily in the depicted shape).\n" +
                            "The tiles of one group can be different from those of another group");
                    System.out.println("+-------+");
                    System.out.println("|   =   |");
                    System.out.println("+-------+");
                    System.out.println("|   =   |");
                    System.out.println("+-------+   x4");
                    System.out.println("|   =   |");
                    System.out.println("+-------+");
                    System.out.println("|   =   |");
                    System.out.println("+-------+");
                    break;
                case 6:
                    System.out.println("Two columns each formed by 6 different types of tiles. ");
                    System.out.println("+-------+");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+   x2");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+");
                    System.out.println("|  !=   |");
                    System.out.println("+-------+");
                    break;
                case 7:
                    System.out.println("Two groups each containing 4 tiles of the same type in a 2x2 square.\n" +
                            "The tiles of one square can be different from those of the other square.");
                    System.out.println("+-------+-------+");
                    System.out.println("|   =   |   =   |");
                    System.out.println("+-------+-------+   x2");
                    System.out.println("|   =   |   =   |");
                    System.out.println("+-------+-------+");
                    break;
                case 8:
                    System.out.println("Two lines each formed by 5 different types of tiles.\n" +
                            "One line can show the same or a different combination of the other line.");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    System.out.println("|  !=   |  !=   |  !=   |  !=   |  !=   |   x2");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    break;
                case 9:
                    System.out.println("Three columns each formed by 6 tiles of maximum three different types.\n" +
                            "One column can show the same or a different combination of another column.");
                    System.out.println("+-------+");
                    System.out.println("|       |");
                    System.out.println("+-------+");
                    System.out.println("|       |");
                    System.out.println("+-------+");
                    System.out.println("|       |               +-------+");
                    System.out.println("+-------+  X3   MAX 3   |   !=  |");
                    System.out.println("|       |               +-------+");
                    System.out.println("+-------+");
                    System.out.println("|       |");
                    System.out.println("+-------+");
                    System.out.println("|       |");
                    System.out.println("+-------+");
                    break;
                case 10:
                    System.out.println("Five tiles of the same type forming an X.");
                    System.out.println("+-------+       +-------+");
                    System.out.println("|   =   |       |   =   |");
                    System.out.println("+-------+-------+-------+");
                    System.out.println("        |   =   |       ");
                    System.out.println("+-------+-------+-------+");
                    System.out.println("|   =   |       |   =   |");
                    System.out.println("+-------+       +-------+");
                    break;
                case 11:
                    System.out.println("Eight tiles of the same type. There’s no restriction about the position of these tiles.");
                    System.out.println("    +-------+   +-------+");
                    System.out.println("    |   =   |   |   =   |");
                    System.out.println("    +-------+   +-------+");
                    System.out.println();
                    System.out.println("+-------+   +-------+   +-------+");
                    System.out.println("|   =   |   |   =   |   |   =   |");
                    System.out.println("+-------+   +-------+   +-------+");
                    System.out.println();
                    System.out.println("+-------+   +-------+   +-------+");
                    System.out.println("|   =   |   |   =   |   |   =   |");
                    System.out.println("+-------+   +-------+   +-------+");
                    break;
                case 12:
                    System.out.println("Five columns of increasing or decreasing height. Starting from the first column on the left or on the right,\n" +
                            " each next column must be made of exactly one more tile. Tiles can be of any type.");
                    System.out.println("+-------+");
                    System.out.println("|       |");
                    System.out.println("+-------+-------+");
                    System.out.println("|       |       |");
                    System.out.println("+-------+-------+-------+");
                    System.out.println("|       |       |       |");
                    System.out.println("+-------+-------+-------+-------+");
                    System.out.println("|       |       |       |       |");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    System.out.println("|       |       |       |       |       |");
                    System.out.println("+-------+-------+-------+-------+-------+");
                    break;
                default:
                    System.out.println("Common goal id not valid");
            }
        }
    }
    @Override
    public void showPersonalGoalCard(Player player) throws Exception {
        Tile[][] personalGoalCard = player.getPersonalGoalCard().buildPersonalGoalCard();
        System.out.println("PERSONAL GOAL CARD:");
        System.out.println("|   1   |   2   |   3   |   4   |   5   |");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[0][0].getTileType().toCliString()+"|"+personalGoalCard[0][1].getTileType().toCliString()+"|"+personalGoalCard[0][2].getTileType().toCliString()+"|"+personalGoalCard[0][3].getTileType().toCliString()+"|"+personalGoalCard[0][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[1][0].getTileType().toCliString()+"|"+personalGoalCard[1][1].getTileType().toCliString()+"|"+personalGoalCard[1][2].getTileType().toCliString()+"|"+personalGoalCard[1][3].getTileType().toCliString()+"|"+personalGoalCard[1][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[2][0].getTileType().toCliString()+"|"+personalGoalCard[2][1].getTileType().toCliString()+"|"+personalGoalCard[2][2].getTileType().toCliString()+"|"+personalGoalCard[2][3].getTileType().toCliString()+"|"+personalGoalCard[2][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[3][0].getTileType().toCliString()+"|"+personalGoalCard[3][1].getTileType().toCliString()+"|"+personalGoalCard[3][2].getTileType().toCliString()+"|"+personalGoalCard[3][3].getTileType().toCliString()+"|"+personalGoalCard[3][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[4][0].getTileType().toCliString()+"|"+personalGoalCard[4][1].getTileType().toCliString()+"|"+personalGoalCard[4][2].getTileType().toCliString()+"|"+personalGoalCard[4][3].getTileType().toCliString()+"|"+personalGoalCard[4][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println("|"+personalGoalCard[5][0].getTileType().toCliString()+"|"+personalGoalCard[5][1].getTileType().toCliString()+"|"+personalGoalCard[5][2].getTileType().toCliString()+"|"+personalGoalCard[5][3].getTileType().toCliString()+"|"+personalGoalCard[5][4].getTileType().toCliString()+"|");
        System.out.println("+-------+-------+-------+-------+-------+");
        System.out.println();

    }
    @Override
    public void updateGameState(Player player, Game game) throws Exception {

        out.flush();
        System.out.print("\033[H\033[2J");
        System.out.println();
        showCommonGoalCards(game);
        System.out.println();
        showPersonalGoalCard(player);
        System.out.println();
        showLivingRoom(game.getLivingRoom());
        System.out.println();
        for(Player p : game.getPlayers()) {
            showBookshelf(p);
            System.out.println();
        }

    }
    @Override
    public void showGameStarted(Game game) {

    }
    @Override
    public void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) {

    }
    @Override
    public void showWinner(String winner, Game game) {

    }
    @Override
    public void someoneDisconnected(String nickname) {
        System.out.println(nickname + " disconnected.");
        /*notifyObserver(obs -> {
            try {
                obs.handleDisconnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });*/

        System.exit(1);
    }
    @Override
    public void handleDisconnection(String nickname) {
        System.out.println("You will be disconnected. Game finished :(");

        notifyObserver(obs -> {
            try {
                obs.handleDisconnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


       //System.exit(1);
    }
    @Override
    public void turnDisplay(Player player) {

    }
    @Override
    public void welcomeBack(String nickname) {
        System.out.println("Welcome back "+nickname+"!");
        System.out.println("The game will start when all the previous players are connected.");
    }
    @Override
    public void updateGuiCommonGoalCardPoints(Game game, int previousPoints1, int previousPoints2){
    }

    @Override
    public void endGame(ArrayList<Player> scoreboard, String winner) {
        showScoreboard(scoreboard);
        System.out.println("The winner is " + winner + "! Congratulations to everyone!");
        System.out.println("Write 'exit' to leave the game.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        while(!input.equalsIgnoreCase("exit")) {
            System.out.println("Invalid statement!");
            input = scanner.nextLine().trim();
        }
        if(input.equalsIgnoreCase("exit")) {
            notifyObserver(obs -> {
                try {
                    obs.handleDisconnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            handleDisconnection();
        }


    }

    @Override
    public void handleDisconnection() {
        System.out.println("You will be disconnected. Game finished :(");

       /* notifyObserver(obs -> {
            try {
                obs.handleDisconnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });*/
        System.exit(1);
    }
}