package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.RMIClient;
import it.polimi.ingsw.Network.Client.SocketClient;
import it.polimi.ingsw.Network.Message.LoginReply;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.Network.Server.SocketServer;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.View;


import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Integer.parseInt;

public class ClientController implements Observer, ViewObserver {


    private final View view;
    private Client client;
    private String nickname;
    private final ExecutorService taskQueue;


    public ClientController(View view) throws RemoteException {
        this.view = view;
        taskQueue = Executors.newSingleThreadExecutor();

    }

    public void setClient(Client client){
        this.client = client;
    }

    public String getNickname(){return this.nickname;}

    @Override
    public void update(Message message) {
        switch(message.getMessageType()){
            case GENERIC_MESSAGE:
                taskQueue.execute(() -> {
                    try {
                        view.showMessage(message.toString());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case LOGIN_REQUEST:
                taskQueue.execute(() -> {
                    try {
                        view.nicknameRequest();
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case LOGIN_REPLY:
                //???
                break;
            case LOGIN_RESULT:
                LoginResult loginResult = (LoginResult) message;
                taskQueue.execute(() -> {
                    try {
                        view.loginResult(loginResult.isNicknameAccepted(), loginResult.isSuccessfulAccess(), loginResult.getChosenNickname());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case NUM_OF_PLAYERS_REQUEST:
                taskQueue.execute(() -> {
                    try {
                        view.askNumberOfPlayers();
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case NUM_OF_PLAYERS_REPLY:
                break;
            case PICK_FIRST_PLAYER:

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
                taskQueue.execute(() -> {
                    try {
                        view.TilesRequest(chosenTilesRequest.getLivingroom());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case CHOSEN_TILES_REPLY:

                break;
            case ORDERED_TILES_REQUEST:
                OrderedTilesRequest orderedTilesRequest = (OrderedTilesRequest) message;
                taskQueue.execute(() -> {
                    try {
                        view.OrderTiles(orderedTilesRequest.getChosenTiles());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case ORDERED_TILES_REPLY:

                break;
            case COLUMN_REQUEST:
                ColumnRequest columnRequest = (ColumnRequest) message;
                taskQueue.execute(() -> {
                    try {
                        view.columnRequest(columnRequest.getAvailableColumns());
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
            case COLUMN_REPLY:

                break;
            case GIVE_POINTS:

                break;
            case UPDATE_POINTS:

                break;
            case WINNER:

                break;
            case MATCH_INFO:

                break;
            case SERVER_INFO:

                break;
            case LIVING_ROOM:

                break;
            case BOOKSHELF:

                break;
            case HEARTBEAT:

                break;
            default:
                break;
        }
    }

    @Override
    public void updateServerInfoSocket() throws IOException {
        try{
            //creo una connessione con il server che ha ipaddress e port come serverInfo.
            this.client =  new SocketClient();
            this.client.addObserver(this);
            //attendo il messaggio dal server
            this.client.readMessage();
            this.view.nicknameRequest();
        }catch (IOException e){
            this.view.loginResult(false,false,this.nickname);
        }
    }

   @Override
    public void updateServerInfoRmi() {
        //client = new RMIClient();
        client.addObserver(this);
    }

    @Override
    public void updateNickname(String nickname) throws RemoteException {
        this.nickname = nickname;
        client.sendMessage(new LoginRequest(nickname));      //questo è il pattern: viewObserver è l'interfaccia da cui prendere i metodi da overridare. Poi il client creerà nuovi messaggi in base al metodo in cui mi trovo tramite sendMessage
    }                                                       // da noi MatchImpl dovrebbe diventare Observable, perchè sono la stessa cosa; infatti il client dovrà estendere proprio observable

    @Override
    public void updateNumOfPlayers(int num) throws RemoteException {
        client.sendMessage(new NumOfPlayersReply(nickname,num));

    }

    @Override
    public void updateChosenTiles(ArrayList<Tile> chosen) throws RemoteException {
        client.sendMessage(new ChosenTilesReply(nickname,chosen));
    }

    @Override
    public void updateChosenColumn(int col, ArrayList<Integer> availableColumns) throws RemoteException {
        client.sendMessage(new ColumnReply(nickname,col,availableColumns));
    }

    public void updateOrderedTiles(ArrayList<Tile> orderedTiles) throws RemoteException {
        client.sendMessage(new OrderedTilesReply(nickname,orderedTiles));
    }

    @Override
    public void handleDisconnection() throws RemoteException {
        client.sendMessage(new DisconnectionRequest(nickname));
    }


}
