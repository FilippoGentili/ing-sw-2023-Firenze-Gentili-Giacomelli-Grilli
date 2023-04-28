package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.View.VirtualView;

import java.util.Map;

public class TurnController1 {

    private GameController gameController;
    private Map<Player, VirtualView> virtualViewMap;

    public TurnController(GameController gameController, Map<Player, VirtualView> virtualViewMap){
        this.gameController = gameController;
        this.virtualViewMap = virtualViewMap;
    }

    public void newTurn(){
        yourTurn(gameController.getCurrentPlayer());


    }

    public void yourTurn(Player player){

    }

    public void turnMessage(String message){

    }
}
