package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Start;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.View.VirtualView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

/**
 * this class is used to handle the dynamics of each turn of the game.
 */
public class TurnController {

    private GameController gameController;
    private InputController inputController;
    private Map<Player, VirtualView> virtualViewMap;
    private Player currentPlayer;
    private ArrayList<Player> players;
    Timer timer; //da gestire

    public TurnController(GameController gameController, Map<Player, VirtualView> virtualViewMap){
        this.gameController = gameController;
        this.virtualViewMap = virtualViewMap;
        this.players = new ArrayList<>();
        currentPlayer = gameController.getCurrentPlayer();

        for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()){
            players.add(map.getKey());
        }
    }

    public void nextPlayer(){
        int indexPlayer = players.indexOf(currentPlayer);

        if(indexPlayer+1 < players.size())
            currentPlayer = players.get(indexPlayer + 1);
        else
            currentPlayer = players.get(0);

        gameController.setCurrentPlayer(currentPlayer);
    }

    /**
     * this method initializes a new turn.
     */
    public void newTurn(){
        //yourTurn(gameController.getCurrentPlayer());

        for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()){
            if(!map.getKey().equals(currentPlayer))
                map.getValue().showMessage("It's the turn of " + currentPlayer.getNickname());
            else
                map.getValue().showMessage("It's your turn, " + currentPlayer.getNickname() + "!");
        }

        chooseTiles();

    }

    public void chooseTiles(){
        Player player = gameController.getCurrentPlayer();
    }

    public void turnMessage(String message){

    }
}
