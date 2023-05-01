package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.RMIClient;
import it.polimi.ingsw.Network.Message.LoginReply;
import it.polimi.ingsw.Network.Message.LoginRequest;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.View;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
public class ClientController implements Observer, ViewObserver {


    private final View view;
    private RMIClient client;
    private String nickname;

    public ClientController(View view) {
        this.view = view;
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
    public void updateServerInfo(Map<String, String> serverInfo) {

    }

    @Override
    public void updateNickname(String nickname) throws RemoteException {
        this.nickname = nickname;
        client.notifyMessageSent(new LoginRequest(nickname));      //questo è il pattern: viewObserver è l'interfaccia da cui prendere i metodi da overridare. Poi il client creerà nuovi messaggi in base al metodo in cui mi trovo tramite sendMessage
    }                                                       // da noi MatchImpl dovrebbe diventare Observable, perchè sono la stessa cosa; infatti il client dovrà estendere proprio observable

    @Override
    public void updateNumOfPlayers(int num) {

    }

    @Override
    public void updateChosenTiles(ArrayList<Tile> chosen) {

    }

    @Override
    public void updateChosenColumn(int col) {

    }

    @Override
    public void handleDisconnection() {

    }

    public boolean validIP(String address){
        String regex = "";
        return address.matches(regex);
    }

    public boolean validPort(String  port){
        int p = Integer.parseInt(port);
        return p >= 1 && p <= 65535;
    }


}
