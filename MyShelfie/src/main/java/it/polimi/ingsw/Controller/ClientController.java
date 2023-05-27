package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Client.Socket.SocketClient;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Observer.ClientUpdater;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.View;


import java.io.IOException;
import java.rmi.RemoteException;
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

    private GameController gameController;  // da settare per poi chiamare getPlayerByNickname

    private ClientUpdater clientUpdater;


    public ClientController(View view) {
        this.view = view;
        //taskQueue = Executors.newSingleThreadExecutor();
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
            case MATCH_INFO:
                break;
            case DISCONNECTION_REPLY:
                DisconnectionReply disconnectionReply = (DisconnectionReply) message;
                queue.add(() -> {
                    view.someoneDisconnected(disconnectionReply.getDisconnectedUser());
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
                    view.columnRequest(columnRequest.getAvailableColumns());
                });
                break;
            case WINNER:
                WinnerMessage winnerMessage = (WinnerMessage) message;
                queue.add(() -> {
                    view.showWinner(winnerMessage.getWinnerNickname());
                });
                break;
            case SERVER_INFO:

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
                    view.showGameStarted(gameStartedMessage.getPlayers(), gameStartedMessage.getGame());
                });
                break;
            default:
                break;
        }
    }

    @Override
    public void updateServerInfoSocket(DisconnectionHandler disconnectionHandler, String address,String port) {
        try{
            //creo una connessione con il server che ha ipaddress e port come serverInfo.
            this.client =  new SocketClient(disconnectionHandler,address,port);
            client.connection();
            this.client.addObserver(this);
            this.clientUpdater = new ClientUpdater(this.client, this);
            //attendo il messaggio dal server
            //this.client.readMessage();
            this.view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,this.client.getUsername());
        }
    }

   @Override
    public void updateServerInfoRmi(DisconnectionHandler disconnectionHandler, String address, String port) throws RemoteException {
        /*try {
            this.client = new RMIClient(disconnectionHandler, address, port);
            this.client.connection();
            this.client.addObserver(this);
            this.clientUpdater = new ClientUpdater(this.client, this);
            view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,null);
        }*/
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

    public static boolean validAddress(String address) {
        if (address == null || address.equals("localhost")) {
            return true;
        }
        return address.matches("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");
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

}
