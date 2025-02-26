package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Model.Tile;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class InputController implements Serializable {
    @Serial
    private static final long serialVersionUID = 6905901343913742095L;
    private final GameController gameController;
    private final Server server;

    /**
     * Constructor
     */
    public InputController(GameController gameController, Server server){
        this.gameController = gameController;
        this.server = server;
    }

    /**
     * This method checks if the nickname inserted by the client during login is valid
     * @param nickname nickname chosen by the client
     * @return {code @true} if nickname is valid {code @false} if nickname is not valid
     */
    public boolean checkNickname(String nickname) {
        if(nickname.isEmpty()){
            gameController.getServer().sendMessage(new GenericMessage("nickname missing"),nickname);
            return false;
        }

        for(Player player : gameController.getPlayers()){
            if(nickname.equals(player.getNickname())){
                gameController.getServer().sendMessage(new GenericMessage("this nickname is already used"),nickname);
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks if the chosen tiles from the livingRoom are valid
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

        boolean valid = gameController.getGame().getLivingRoom().checkValid(chosenTiles);
        if(!valid){
            server.sendMessage(new GenericMessage("the selected tiles are not valid"),gameController.getCurrentPlayer().getNickname());
            return false;
        }

        return true;
    }

    /**
     * This method checks if the column selected from the client has enough free cells for inserting the selected tiles.
     * @param message column selected from the client
     * @return {code @true} if the column is valid {code @false} if the column is invalid.
     */
    public boolean selectedColumn(Message message){
        ColumnReply chosenColumn = (ColumnReply) message;
        int column = chosenColumn.getColumn();
        ArrayList<Integer> availableColumns = chosenColumn.getAvailableColumns();

        for(int i=0; i < availableColumns.size(); i++){
            if(column == availableColumns.get(i))
                return true;
        }

        return false;

    }

}