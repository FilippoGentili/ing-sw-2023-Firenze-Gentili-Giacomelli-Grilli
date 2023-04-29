package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.View.View;
import it.polimi.ingsw.View.VirtualView;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.Model.Tile;

import java.util.ArrayList;
import java.util.Map;

/**
 * this class is used to handle all the input messages arriving from the client
 */
public class InputController {
    private GameController gameController;
    private Map<Player, VirtualView> virtualViewMap;

    public InputController(GameController gameController, Map<Player, VirtualView> virtualViewMap){
        this.gameController = gameController;
        this.virtualViewMap = virtualViewMap;
    }

    /**
     * this method check if the nickname inseted from the client during the login is valid.
     * @param nickname nickname chosen by the client
     * @param view view of the client
     * @return {code @true} if nickname is valid {code @false} if nickname is not valid
     */
    public boolean checkNickname(String nickname, View view){
        if(nickname.isEmpty()){
            view.showMessage("nickname missing");
            view.loginResult();
            return false;
        }

        for(Map.Entry<Player, VirtualView> map : gameController.getVirtualViewMap().entrySet()){
            if(nickname.equals(map.getKey().getNickname())){
                view.showMessage("this nickname is already used");
                view.loginResult();
                return false;
            }
        }
        return true;
    }

    /**
     * this method checks if the chosen tiles from the livingRoom are valid.
     * @param message message from the client
     * @return {code @true} if the tiles are valid {code @false} if the tiles are invalid.
     */
    public boolean LivingRoomChosenTiles(Message message){

        ChosenTilesMessage chosen = (ChosenTilesMessage) message;
        ArrayList<Tile> chosenTiles = chosen.getChosenTiles();

        int max = gameController.getCurrentPlayer().getBookshelf().getMaxPossibleTiles();

        if(chosenTiles.size() > max){
            virtualViewMap.get(gameController.getCurrentPlayer()).showMessage("You can't choose so many tiles");
            virtualViewMap.get(gameController.getCurrentPlayer()).TilesRequest();
            return false;
        }

        boolean valid = gameController.getGame().getLivingRoom().checkValid(chosenTiles);
        if(!valid){
            virtualViewMap.get(gameController.getCurrentPlayer()).showMessage("the selected tiles are not valid");
            return false;
        }

        return true;
    }
    //chiama gameController

}
