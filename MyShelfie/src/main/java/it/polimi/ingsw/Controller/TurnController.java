package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.View.VirtualView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

import static it.polimi.ingsw.Model.Game.endGameTrigger;

/**
 * this class is used to handle the dynamics of each turn of the game.
 */
public class TurnController {

    private GameController gameController;
    private InputController inputController;
    private Map<Player, VirtualView> virtualViewMap;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private boolean lastTurn;
    Timer timer; //da gestire

    public TurnController(GameController gameController, Map<Player, VirtualView> virtualViewMap){
        this.gameController = gameController;
        this.virtualViewMap = virtualViewMap;
        this.players = new ArrayList<>();
        currentPlayer = gameController.getCurrentPlayer();
        lastTurn = false;

        for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()){
            players.add(map.getKey());
        }
    }

    /**
     * This methods set the currentPlayer who is going play the turn
     */

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

        ArrayList<Tile> chosenTiles = new ArrayList<>();
        virtualViewMap.get(currentPlayer).TilesRequest(chosenTiles);

    }

    /**
     * This method receives the tiles chosen from the current Player on the livingRoom. If the selection is valid,
     * it asks the client to select the column, otherwise it asks to select the tiles again.
     * @param message tiles the client chose
     */
    public void chooseTiles(Message message){
        ChosenTilesMessage chosenTilesMessage = (ChosenTilesMessage) message;
        ArrayList<Tile> chosen = chosenTilesMessage.getChosenTiles();

        if(inputController.livingRoomChosenTiles(chosenTilesMessage)){
            ArrayList<Tile> TemporaryChosenTiles = new ArrayList<>();

            for(int i=0; i<chosen.size(); i++)
                TemporaryChosenTiles.add(chosen.get(i));

            currentPlayer.setChosenTiles(TemporaryChosenTiles);
            ArrayList<Integer> availableColumns = new ArrayList<>();
            availableColumns = currentPlayer.getBookshelf().getFreeColumns(chosen.size());
            virtualViewMap.get(currentPlayer).columnRequest(currentPlayer.getNickname(),availableColumns);
        }else{
            ArrayList<Tile> chosenTiles = new ArrayList<>();
            virtualViewMap.get(currentPlayer).TilesRequest(chosenTiles);
        }
    }

    /**
     * this method check if the column chosen by the client is valid. If it's not, it asks the user to select another
     * column, otherwise it asks him to order the tiles he has already chosen.
     * @param message
     */

    public void SelectedColumn(Message message){
        ColumnReply chosenColumn = (ColumnReply) message;
        int chosen = chosenColumn.getColumn();

        if(inputController.selectedColumn(chosenColumn)){
            currentPlayer.setChosenColumn(chosen);
            virtualViewMap.get(currentPlayer).OrderTiles(currentPlayer.getChosenTiles());
        }else{
            ArrayList<Integer> availableColumns = new ArrayList<>();
            availableColumns = currentPlayer.getBookshelf().getFreeColumns(currentPlayer.getChosenTiles().size());
            virtualViewMap.get(currentPlayer).columnRequest(currentPlayer.getNickname(),availableColumns);
        }
    }

    public void InsertTiles(Message message){
        OrderedTiles orderedTiles = (OrderedTiles) message;
        ArrayList<Tile> chosenTiles = orderedTiles.getOrderedTiles();

        currentPlayer.InsertTiles(chosenTiles, currentPlayer.getChosenColumn());

        /*CheckCommonGoal(currentPlayer);
        EndTurn();*/ //vanno messi qui o in un'altra classe del server?
    }

    public void CheckCommonGoal(Player player){

        if(gameController.getGame().getCommonGoal1().check(player.getBookshelf()) && !player.getPointscg1()){
            virtualViewMap.get(player).showMessage("Congratulations! You reached the first Common Goal! You earn " +
                    gameController.getGame().getCommonGoal1().getValue() + " points!");
            player.setScore(player.getScore()+ Game.getCommonGoal1().getValue());
            Game.getCommonGoal1().updateValue();
            player.setPointscg1();
        }

        if(gameController.getGame().getCommonGoal2().check(player.getBookshelf()) && !player.getPointscg2()){
            virtualViewMap.get(player).showMessage("Congratulations! You reached the first Common Goal! You earn " +
                    gameController.getGame().getCommonGoal2().getValue() + " points!");
            player.setScore(player.getScore()+Game.getCommonGoal2().getValue());
            Game.getCommonGoal2().updateValue();
            player.setPointscg2();
        }
    }

    public void EndTurn(){
        if(currentPlayer.getBookshelf().fullBookshelf()) {
            for(Map.Entry<Player, VirtualView> map : virtualViewMap.entrySet()) {
                map.getValue().showMessage("" + currentPlayer.getNickname() + " finished his bookshelf! Last Round!");
            }
            virtualViewMap.get(currentPlayer).showMessage("You earn one points for finishing your " +
                    "                                       bookshelf before the other players.");
            endGameTrigger(currentPlayer.getBookshelf(), currentPlayer);
            lastTurn(); //da rivedere
        }else{
            virtualViewMap.get(currentPlayer).showMessage("Your turn ended.");
            nextPlayer();
            newTurn(); //da rivedere
        }
    }

    public void lastTurn(){
        lastTurn = true;
        nextPlayer();
    }
}