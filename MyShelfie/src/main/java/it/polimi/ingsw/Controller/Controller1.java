package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Game;

import java.util.HashMap;
import java.util.Map;

public class Controller1 {

    private Map<GameController, Game> allGames;

    public Controller1(){
        allGames = new HashMap<GameController, Game>();
    }

    public void login(String nickname, int num /*cambia parametri in messaggi?*/){
        //scorri la mappa
        for(Map.Entry<GameController, Game> map : allGames.entrySet()){
            if(map.getKey().getNumOfPlayers() == num) {
                if (!map.getKey().isFull()) {
                    map.getKey().addPlayer(nickname);
                    return;
                }
            }
        }

        GameController newGame = new GameController(num);
        newGame.addPlayer(nickname);
        allGames.put(newGame, newGame.getGame());
    }
}
