package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Chat;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.RMI.RMIClient;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Client.Socket.SocketClient;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Observer.ClientUpdater;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.View;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class ClientController implements Observer, ViewObserver, Runnable {

    public static final Logger LOGGER = Logger.getLogger("MyShelfie client");
    private final View view;
    private Client client;
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private ClientUpdater clientUpdater;


    public ClientController(View view) {
        this.view = view;
        //taskQueue = Executors.newSingleThreadExecutor();
        new Thread(this).start();
        //this.lock = new Object();
    }

    @Override
    public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                    LOGGER.severe(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
    }

    public void setClient(Client client){
        this.client = client;
    }

    public String getNickname(){return this.client.getUsername();}

    //potrei far partire tanti thread quanti sono gli observable



    /**
     * Handles arriving messages from Server (Requests)
     *
     * @param message
     */
    @Override
    public void update(Message message) {
        synchronized (client){
            switch(message.getMessageType()){
                case GENERIC_MESSAGE:
                    queue.add(() -> {
                        view.showMessage(message.toString());
                    });
                    break;
                case LOGIN_REQUEST:
                    queue.add(() -> {
                        view.nicknameRequest();
                    });
                    break;
                case LOGIN_RESULT:
                    LoginResult loginResult = (LoginResult) message;
                    queue.add(() -> {
                        view.loginResult(loginResult.isNicknameAccepted(), loginResult.isSuccessfulAccess(), loginResult.getChosenNickname());
                    });
                    break;
                case LOGIN_REPLY:
                    LoginReply loginReply = (LoginReply) message;
                    queue.add(() -> {
                        view.showMessage(message.toString());
                    });
                    break;
                case NUM_OF_PLAYERS_REQUEST:
                    queue.add(() -> {
                        view.askNumberOfPlayers();
                    });
                    break;
                case GAME_STATE:
                    GameStateMessage gameStateMessage = (GameStateMessage) message;
                    queue.add(() -> {
                        try {
                            view.updateGameState(gameStateMessage.getPlayer(), gameStateMessage.getGame());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    break;
                case SCOREBOARD_MESSAGE:
                    ScoreBoardMessage scoreBoardMessage = (ScoreBoardMessage) message;
                    queue.add(() -> {
                        view.showScoreboard(scoreBoardMessage.getScoreboard());
                    });
                    break;
                case DISCONNECTION_REPLY:
                    DisconnectionReply disconnectionReply = (DisconnectionReply) message;
                    queue.add(() -> {
                        if(disconnectionReply.getDisconnectedUser().equals("Server"))
                            view.handleDisconnection(disconnectionReply.getDisconnectedUser());
                        else view.someoneDisconnected(disconnectionReply.getDisconnectedUser());
                        closeConnection();
                    });
                    break;
                case CHOSEN_TILES_REQUEST:
                    ChosenTilesRequest chosenTilesRequest = (ChosenTilesRequest) message;
                    queue.add(() -> {
                        view.TilesRequest(chosenTilesRequest.getLivingroom());
                    });
                    break;
                case ORDERED_TILES_REQUEST:
                    OrderedTilesRequest orderedTilesRequest = (OrderedTilesRequest) message;
                    queue.add(() -> {
                        view.OrderTiles(orderedTilesRequest.getChosenTiles());
                    });
                    break;
                case COLUMN_REQUEST:
                    ColumnRequest columnRequest = (ColumnRequest) message;
                    queue.add(() -> {
                        view.columnRequest(columnRequest.getAvailableColumns(), columnRequest.getPlayer());
                    });
                    break;
                case WINNER_MESSAGE:
                    WinnerMessage winnerMessage = (WinnerMessage) message;
                    queue.add(() -> {
                        view.showWinner(winnerMessage.getWinnerNickname(), winnerMessage.getGame());
                    });
                    break;
                case LIVING_ROOM:
                    LivingRoomMessage livingRoomMessage = (LivingRoomMessage) message;
                    LivingRoom livingRoom = livingRoomMessage.getLivingRoom();
                    queue.add(() -> {
                        view.showLivingRoom(livingRoom);
                    });
                    break;
                case PLAYER_MESSAGE:
                    PlayerMessage playerMessage = (PlayerMessage) message;
                    Player player = playerMessage.getPlayer();
                    queue.add(() -> {
                        view.showBookshelf(player);
                    });
                    break;
                case WAITING_ROOM:
                    WaitingRoomMessage waitingRoomMessage = (WaitingRoomMessage) message;
                    queue.add(() -> {
                        view.showMessage(message.toString());
                        view.showWaitingRoom(waitingRoomMessage.getMaxPlayers(), waitingRoomMessage.getNumOfPlayersConnected());
                    });
                    break;
                case GAME_STARTED:
                    GameStartedMessage gameStartedMessage = (GameStartedMessage) message;
                    queue.add(() -> {
                        view.showMessage(message.toString());
                        view.showGameStarted(gameStartedMessage.getGame());
                    });
                    break;
                case STARTING_CHAT_MESSAGE:
                    try {
                        startChat();
                    }catch (IOException e){
                        //
                    }
                    break;
                case CHAT_MESSAGE:
                    ChatMessage chatMessage = (ChatMessage) message;
                    queue.add(() -> {
                       view.showChatMessage(chatMessage);
                    });
                    break;
                case Turn_Message:
                    TurnMessage turnMessage = (TurnMessage) message;
                    queue.add(() -> {
                        view.turnDisplay(turnMessage.getPlayer());
                    });
                    break;
                case WELCOMEBACK_MESSAGE:
                    WelcomeBackMessage welcomeBackMessage = (WelcomeBackMessage) message;
                    queue.add(()-> {
                        view.welcomeBack(welcomeBackMessage.getNickname());
                    });
                default:
                    break;
            }
        }
    }

    @Override
    public void updateServerInfoSocket(DisconnectionHandler disconnectionHandler, String address,String port) {
        try{
            //creo una connessione con il server che ha ipaddress e port come serverInfo.
            this.client =  new SocketClient(disconnectionHandler,address,port);
            client.connection();
            //this.chat = new SocketClientChat(address,disconnectionHandler);
            //chat.connectChat();
            //this.client.addObserver(this);
            this.clientUpdater = new ClientUpdater(this.client, this);
            this.view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,this.client.getUsername());
        }
    }

   @Override
    public void updateServerInfoRmi(DisconnectionHandler disconnectionHandler, String address, String port) throws RemoteException {
        try {
            this.client = new RMIClient(disconnectionHandler, address, port);
            this.client.connection();
            //this.client.addObserver(this);
            this.clientUpdater = new ClientUpdater(this.client, this);
            view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,null);
        }
    }

    public void sendChatMessage(String message){
        client.sendMessage(new ChatMessage(message));
    }

    @Override
    public void updateNickname(String nickname) {
        this.client.setUsername(nickname);
        client.sendMessage(new LoginRequest(nickname));
    }

    @Override
    public void updateNumOfPlayers(int num) {
        client.sendMessage(new NumOfPlayersReply(client.getUsername(), num));
    }

    @Override
    public void updateChosenTiles(ArrayList<Tile> chosen) {
        client.sendMessage(new ChosenTilesReply(client.getUsername(), chosen));
    }

    @Override
    public void updateChosenColumn(int col, ArrayList<Integer> availableColumns) {
        client.sendMessage(new ColumnReply(client.getUsername(), col,availableColumns));
    }

    public void updateOrderedTiles(ArrayList<Tile> orderedTiles) {
        client.sendMessage(new OrderedTilesReply(client.getUsername(), orderedTiles));
    }

    @Override
    public void handleDisconnection() {
        client.sendMessage(new DisconnectionRequest(client.getUsername()));
    }

    @Override
    public void updateLivingRoomTiles(ArrayList<Tile> chosen) throws IOException {
        client.sendMessage(new IndexMessage(client.getUsername(), chosen));
    }

    public void startChat() throws IOException {
        this.view.startChat();
    }

    public static boolean validAddress(String address, String connectionType){
        boolean isValid=true;
        String SocketPort = "1098";
        String RMIPort = "1099";
        String connection = connectionType;
        boolean bc=notBroadcastAddress(address);

        if (connection.equals("rmi")) {
            if (/*(address.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b")) || (address == null || address.equals("localhost"))*/ bc) {
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
            if (/*(address.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b")) || (address == null || address.equals("localhost"))*/ bc) {
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

        return isValid;
    }

    public static boolean notBroadcastAddress(String address){
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

    public static boolean validPort(String port){
        try {
            int portNum = Integer.parseInt(port);
            if (portNum >= 1 && portNum <= 65536) {
                return true;
            }
        } catch (NumberFormatException e) {
            // Handled with the return
        }

        return false;
    }

    public void closeConnection(){
        if(clientUpdater!= null){
            clientUpdater.stop();
            clientUpdater=null;
        }

        try{
            client.disconnectMe();
        } catch (Exception e){

        }
        client = null;
    }

}
