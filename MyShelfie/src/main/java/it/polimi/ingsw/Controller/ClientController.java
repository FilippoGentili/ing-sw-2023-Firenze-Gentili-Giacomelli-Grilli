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
    private final ExecutorService taskQueue;
    private Client client;
    private String nickname;

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
            case LOGIN_REPLY:
                LoginReply loginReply = (LoginReply) message;


        }
    }

    @Override
    public static void updateServerInfoSocket(Map<String, String> serverInfo) throws IOException {
        String Ipaddress = null;
        String portString;
        int port = 0;

        for(Map.Entry<String, String> map : serverInfo.entrySet()){
            Ipaddress = map.getKey();
            portString = map.getValue();
            port = Integer.parseInt(portString);
            break;
        }

        try{
            //creo una connessione con il server che ha ipaddress e port come serverInfo.
            client = new SocketClient();
            client.addObserver(this);
            //attendo il messaggio dal server
            client.readMessage();
            view.nicknameRequest();
        }catch (IOException e){
            view.loginResult(false,false,this.nickname);
        }
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
