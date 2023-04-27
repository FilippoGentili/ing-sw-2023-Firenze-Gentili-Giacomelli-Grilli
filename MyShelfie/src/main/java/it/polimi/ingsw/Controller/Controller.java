package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private HashMap<Game, gameController> allGames;

    public Controller(){
        allGames = new HashMap<Game, gameController>();
    }

    public void login(String nickname, int num /*cambia parametri in messaggi?*/){
        //scorri la mappa
        for(Map.Entry<Game, gameController> map : allGames.entrySet()){
            if(map.getValue().getNumOfPlayers() == num) {
                if (!map.getValue().isFull()) {
                    map.getValue().addPlayer(nickname);
                    return;
                }
            }
        }
        allGames.put(new Game(), new gameController(num));
    }
}
