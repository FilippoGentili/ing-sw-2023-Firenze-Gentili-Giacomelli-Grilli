package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.GameState;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.View.VirtualView;

import java.util.Map;

import static it.polimi.ingsw.Model.GameState.*;

public class GameController {

    private Game game;
    private GameState gameState;
    private final int numOfPlayers;
    private Player currentPlayer;
    private Player firstPlayer;
    private TurnController turnController;
    private InputController inputController;
    private Map<Player, VirtualView> virtualViewMap;

    public GameController(int num){
        this.game = new Game();
        this.numOfPlayers = num;
        this.turnController = new TurnController(this,virtualViewMap);
        this.inputController = new InputController(this,virtualViewMap);
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public boolean isFull(){
        if(game.getPlayers().size() == numOfPlayers)
            return true;
        else return false;
    }

    public void addVirtualView(Player player, VirtualView vv){
        virtualViewMap.put(player, vv);
        game.addObserver(vv);
        game.getLivingRoom().addObserver(vv);
        player.getBookshelf().addObserver(vv);
    }

    public void removeVirtualView(Player player, VirtualView vv){
        virtualViewMap.remove(player, vv);
        game.removeObserver(vv);
        game.getLivingRoom().removeObserver(vv);
        player.getBookshelf().removeObserver(vv);
    }

    public void handleLogin(String nickname, VirtualView vv){
        Player player = new Player();
        player.setNickname(nickname);

        if(virtualViewMap.isEmpty()){
            player.setNickname(nickname);
            game.addPlayer(player);
            virtualViewMap.put(player,vv);

            vv.loginResult(true,true,nickname);
            vv.askNumberOfPlayers();

        }else{

        }
    }

    /*public void addPlayer(String nickname){
        Player player = new Player();
        player.setNickname(nickname);
        VirtualView vv = new VirtualView();
        virtualViewMap.put(player,vv);
        game.addPlayer(player);
    }*/

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Game getGame() {
        return game;
    }

    public void HandleMessage(Message message){
        if(gameState==GameState.LOGIN){

        }
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

    public void startGame(){
        setGameState(PLAY);
    }

    public void setupGame(){
        firstPlayer = game.pickFirstPlayer();
        currentPlayer = firstPlayer;
    }

    public Map<Player,VirtualView> getVirtualViewMap(){
        return virtualViewMap;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean waitingForPlayers(){
        if(gameState == GameState.LOGIN) return true;
        else return false;
    }
    /*gestione list of player
    dobbiamo far partire il game quando il numero dei giocatori è uguale al numero stabilito per la partita

    if(listOfPlayers.contains(player)){
        System.out.println("The player is already in the game");
        return;
    }
        if(listOfPlayers.size() == 4)

    {
        System.out.println("The game is full");
        return;
    }
    System.out.println("The player has been added to the game");

    */

}

