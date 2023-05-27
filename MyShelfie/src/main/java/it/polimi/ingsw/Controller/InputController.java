package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.View;
import it.polimi.ingsw.View.VirtualView;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Model.Tile;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 * this class is used to handle and check all the input messages arriving from the client
 */
public class InputController {
    private final GameController gameController;
    private final Server server;

    /**
     * constructor
     */
    public InputController(GameController gameController, Server server){
        this.gameController = gameController;
        this.server = server;
    }

    /**
     * this method check if the nickname inseted from the client during the login is valid.
     * @param nickname nickname chosen by the client
     * @param view view of the client
     * @return {code @true} if nickname is valid {code @false} if nickname is not valid
     */
    public boolean checkNickname(String nickname, View view) {
        if(nickname.isEmpty()){
            view.showMessage("nickname missing");
            return false;
        }

        for(Map.Entry<Player, VirtualView> map : gameController.getVirtualViewMap().entrySet()){
            if(nickname.equals(map.getKey().getNickname())){
                view.showMessage("this nickname is already used");
                return false;
            }
        }

        view.loginResult(true, true, nickname);
        return true;
    }

    /**
     * this method checks if the chosen tiles from the livingRoom are valid.
     * @param message message from the client
     * @return {code @true} if the tiles are valid {code @false} if the tiles are invalid.
     */
    public boolean livingRoomChosenTiles(Message message) {

        ChosenTilesReply chosen = (ChosenTilesReply) message;
        ArrayList<Tile> chosenTiles = chosen.getChosenTiles();

        int max = gameController.getCurrentPlayer().getBookshelf().getMaxPossibleTiles();

        if(chosenTiles.size() > max){
            server.sendMessage(new GenericMessage("You can't choose so many tiles"), gameController.getCurrentPlayer().getNickname());
            return false;
        }

        boolean valid = LivingRoom.getInstance().checkValid(chosenTiles);
        if(!valid){
            server.sendMessage(new GenericMessage("the selected tiles are not valid"),gameController.getCurrentPlayer().getNickname());
            return false;
        }

        return true;
    }


    /**
     * this method checks if the column selected from the client has enough free cells for inserting
     * the selected tiles.
     * @param message column selected from the client
     * @return {code @true} if the column is valid {code @false} if the column is invalid.
     */
    public boolean selectedColumn(Message message){
        ColumnReply chosenColumn = (ColumnReply) message;
        int column = chosenColumn.getColumn();
        ArrayList<Integer> availableColumns = chosenColumn.getAvailableColumns();

        for(int i=0; i> availableColumns.size(); i++){
            if(column == availableColumns.get(i))
                return true;
        }

        return false;

    }

}