package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bookshelf;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.DisconnectionHandler;
import it.polimi.ingsw.Network.Client.SocketClient;
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


    public ClientController(View view) throws RemoteException {
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
                    try {
                        view.showMessage(message.toString());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case LOGIN_REQUEST:
                queue.add(() -> {
                    try {
                        view.nicknameRequest();
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case LOGIN_RESULT:
                LoginResult loginResult = (LoginResult) message;
                queue.add(() -> {
                    try {
                        view.loginResult(loginResult.isNicknameAccepted(), loginResult.isSuccessfulAccess(), loginResult.getChosenNickname());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case NUM_OF_PLAYERS_REQUEST:
                queue.add(() -> {
                    try {
                        view.askNumberOfPlayers();
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case GAME_STATE:
                queue.add(() -> {
                    try {
                        view.updateGameState(client.getUsername());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case DISCONNECTION_REQUEST:

                break;
            case DISCONNECTION_REPLY:

                break;
            case PING:

                break;
            case ACK:

                break;
            case CHOSEN_TILES_REQUEST:
                ChosenTilesRequest chosenTilesRequest = (ChosenTilesRequest) message;
                queue.add(() -> {
                    try {
                        view.TilesRequest(chosenTilesRequest.getLivingroom());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case ORDERED_TILES_REQUEST:
                OrderedTilesRequest orderedTilesRequest = (OrderedTilesRequest) message;
                queue.add(() -> {
                    try {
                        view.OrderTiles(orderedTilesRequest.getChosenTiles());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case COLUMN_REQUEST:
                ColumnRequest columnRequest = (ColumnRequest) message;
                queue.add(() -> {
                    try {
                        view.columnRequest(columnRequest.getAvailableColumns());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case WINNER:
                WinnerMessage winnerMessage = (WinnerMessage) message;
                queue.add(() -> {
                    view.showWinner(winnerMessage.getWinnerNickname());
                });
                break;
            case MATCH_INFO:

                break;
            case SERVER_INFO:

                break;
            case LIVING_ROOM:
                LivingRoomMessage livingRoomMessage = (LivingRoomMessage) message;
                LivingRoom livingRoom = livingRoomMessage.getLivingRoom();
                queue.add(() -> {
                    try {
                        view.showLivingRoom(livingRoom);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case PLAYER_MESSAGE:
                PlayerMessage playerMessage = (PlayerMessage) message;
                Player player = playerMessage.getPlayer();
                queue.add(() -> {
                    try {
                        view.showBookshelf(player);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case HEARTBEAT:

                break;
            default:
                break;
        }
    }

    @Override
    public void updateServerInfoSocket(DisconnectionHandler disconnectionHandler) throws IOException {
        try{
            //creo una connessione con il server che ha ipaddress e port come serverInfo.
            this.client =  new SocketClient(client.getUsername(), disconnectionHandler;
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
    public void updateServerInfoRmi(DisconnectionHandler disconnectionHandler) throws RemoteException {
        this.client = new RMIClient(client.getUsername(), this);
        this.client.addObserver(this);
        view.nicknameRequest();
        this.clientUpdater = new ClientUpdater(this.client, this);
    }

    @Override
    public void updateNickname(String nickname) throws RemoteException {
        this.client.setUsername(nickname);
        client.sendMessage(new LoginRequest(nickname));
    }

    @Override
    public void updateNumOfPlayers(int num) throws RemoteException {
        client.sendMessage(new NumOfPlayersReply(client.getUsername(), num));
    }

    @Override
    public void updateChosenTiles(ArrayList<Tile> chosen) throws RemoteException {
        client.sendMessage(new ChosenTilesReply(client.getUsername(), chosen));
    }

    @Override
    public void updateChosenColumn(int col, ArrayList<Integer> availableColumns) throws RemoteException {
        client.sendMessage(new ColumnReply(client.getUsername(), col,availableColumns));
    }

    public void updateOrderedTiles(ArrayList<Tile> orderedTiles) throws RemoteException {
        client.sendMessage(new OrderedTilesReply(client.getUsername(), orderedTiles));
    }

    @Override
    public void handleDisconnection() throws RemoteException {
        client.sendMessage(new DisconnectionRequest(client.getUsername()));
    }


}
