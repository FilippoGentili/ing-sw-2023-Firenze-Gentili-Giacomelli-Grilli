package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Start;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.View.VirtualView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

public class TurnController {

    private GameController gameController;
    private InputController inputController;
    private Map<Player, VirtualView> virtualViewMap;
    Timer timer; //da gestire

    public TurnController(GameController gameController, Map<Player, VirtualView> virtualViewMap){
        this.gameController = gameController;
        this.virtualViewMap = virtualViewMap;
    }

    public void newTurn(){
        yourTurn(gameController.getCurrentPlayer());

        for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()){
            if(!map.getKey().equals(gameController.getCurrentPlayer()))
                map.getValue().showMessage("It's the turn of " + gameController.getCurrentPlayer().getNickname());
        }


    }

    public void yourTurn(Player player){
        virtualViewMap.get(player).showMessage("It's your turn!");
        timer = new Timer();
        //bisogna gestire il timer

        ArrayList<Tile> chosenTiles;
        boolean check;

        int max = player.getBookshelf().getMaxPossibleTiles();

        do{
            chosenTiles = inputController.TilesRequest();
            check = gameController.getGame().getLivingRoom().checkValid(chosenTiles);
        } while(!check);

    }

    public void turnMessage(String message){

    }
}
