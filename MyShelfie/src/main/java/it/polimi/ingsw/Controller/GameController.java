package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;

public class GameController {

    private Game game;
    private final int numOfPlayers;
    private Player currentPlayer;
    private Player firstPlayer;

    public GameController(int num){
        this.game = new Game();
        this.numOfPlayers = num;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public boolean isFull(){
        if(game.getPlayers().size() == numOfPlayers)
            return true;
        else return false;
    }

    public void addPlayer(String nickname){
        Player player = new Player();
        player.setNickname(nickname);
        game.addPlayer(player);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Game getGame() {
        return game;
    }

    public void startGame(){
        firstPlayer = game.pickFirstPlayer();
        currentPlayer = firstPlayer;
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

