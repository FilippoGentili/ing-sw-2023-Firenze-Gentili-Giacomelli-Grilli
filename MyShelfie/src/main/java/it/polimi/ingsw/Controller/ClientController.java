package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
//import it.polimi.ingsw.Network.Client.Chat;
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
    private boolean alreadyDisconnected = false;
    private Object lock = new Object();

    /**
     * Constructor of client controller for each client
     * @param view created for the client
     */
    public ClientController(View view) {
        this.view = view;
        new Thread(this).start();
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

    /**
     * Sets client for this client controller
     * @param client set for the specific client controller
     */
    public void setClient(Client client){
        this.client = client;
    }

    /**
     * Gets nickname of the client
     * @return the nickname of the client
     */
    public String getNickname(){return this.client.getUsername();}

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
                    if(!alreadyDisconnected) {
                        alreadyDisconnected = true;
                        DisconnectionReply disconnectionReply = (DisconnectionReply) message;
                        queue.add(() -> {
                            view.someoneDisconnected(disconnectionReply.getDisconnectedUser());
                        });
                    }
                    break;
                case DISCONNECTION_RESULT:
                    queue.add(() -> {
                       view.handleDisconnection();
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
                        view.getChat().addOtherPlayers(gameStartedMessage.getGame().getPlayers());
                    });
                    break;
                case OPENCHAT_MESSAGE:
                    OpenChatMessage openChatMessage = (OpenChatMessage) message;
                    queue.add(() -> {
                        view.openChat();
                    });
                    break;
                case CHAT_MESSAGE:
                    ChatMessage chatMessage = (ChatMessage) message;
                    queue.add(() -> {
                        view.getChat().addMessage(chatMessage.getSender(), chatMessage.getReceiver(), chatMessage.getMessage());
                    });
                    break;
                case TURN_MESSAGE:
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
                    break;
                case UPDATEGUIPOINTS_MESSAGE:
                    UpdateGuiPointsMessage guiPointsMessage = (UpdateGuiPointsMessage) message;
                    queue.add(()-> {
                        view.updateGuiCommonGoalCardPoints(guiPointsMessage.getGame(), guiPointsMessage.getPreviousPoints1(), guiPointsMessage.getPreviousPoints2());
                    });
                    break;
                case ENDGAME_MESSAGE:
                    EndGameMessage endGameMessage = (EndGameMessage) message;
                    queue.add(() -> {
                       view.endGame(endGameMessage.getScoreboard(),endGameMessage.getWinner());
                    });
                default:
                    break;
            }
        }
    }


    @Override
    public void updateServerInfoSocket(DisconnectionHandler disconnectionHandler,String address,String port) {
        try{
            this.client =  new SocketClient(disconnectionHandler,address,port);
            client.connection();
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
            this.clientUpdater = new ClientUpdater(this.client, this);
            view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,null);
        }
    }

    @Override
    public void sendChatMessage(String receiver, String message) {
        client.sendMessage(new ChatMessage(client.getUsername(), receiver, message));
        view.getChat().addOldMessage("from you to " + receiver + ": " + message);
    }

    @Override
    public void updateNickname(String nickname) {
        this.client.setUsername(nickname);
        view.getChat().setOwner(nickname);
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
        view.handleDisconnection();
        client.sendMessage(new DisconnectionRequest(client.getUsername()));
        closeConnection();
    }

    /**
     * Checks if the address used to connect is valid, and if is possible to connect. Excludes broadcast addresses
     * @param address inserted by the client in gui
     * @param connectionType inserted by the client in gui
     * @return true if address is valid, false otherwise
     */
    public static boolean validAddress(String address, String connectionType){
        boolean isValid=true;
        String SocketPort = "1098";
        String RMIPort = "1099";
        String connection = connectionType;
        boolean bc=notBroadcastAddress(address);

        if (connection.equals("rmi")) {
            if (bc) {
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
            if (bc) {
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

    /**
     * Checks if the address is not a broadcast address
     * @param address inserted by the client in gui
     * @return true if the address is a valid ip address and not broadcast, false otherwise
     */
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

    /**
     * Closes connection with the client updater and disconnects the client
     */
    public void closeConnection() {
        synchronized (lock) {
            if (clientUpdater != null) {
                clientUpdater.stop();
                clientUpdater = null;
            }

            try {
                client.disconnectMe();
            } catch (Exception e) {

            }
            client = null;
        }
    }
}
