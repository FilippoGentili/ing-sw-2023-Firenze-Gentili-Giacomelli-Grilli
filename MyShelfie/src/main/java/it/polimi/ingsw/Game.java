package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private int currentPlayer;

    public Game() {
        listOfPlayers = new ArrayList<>();

        //scegliere carte comuni e personali
        // livingroom
    }

    //process of one round
    public static void gameLoop(){

    }

    //returns the current player that is playing
    public Player getCurrentPlayer() {
        return listOfPlayers.get(currentPlayer);
    }

    //returns the next player that must play
    public static Player getNextPlayer(){
        return listOfPlayers.get(currentPlayer+1);

    }

    //return ArrayList of all participants
    public static ArrayList<Player> getPlayers() {
        return listOfPlayers;
    }

    //adds player to ArrayList
    public void addPlayer(Player player) {
        this.listOfPlayers.add(player);
    }

    //removes player from ArrayList
    public void removePlayer(Player player) {
        this.listOfPlayers.remove(player);
    }

    //return number of tiles on living room board for different amount of players
    public int numberOfTiles() {
        int numberOfTiles;

        switch (listOfPlayers.size()) {
            case 2:
                numberOfTiles = 29;
                break;
            case 3:
                numberOfTiles = 37;
                break;
            case 4:
                numberOfTiles = 45;
                break;
            default:
                throw new IllegalArgumentException("Invalid number of players");
        }

        return numberOfTiles;
    }

    //picks 2 random common goal cards
    public pickCommonGoalCards(){

    }

    //picks 1 random personal goal card for each player
    public pickPersonalGoalCard(){

    }


    //notify that it is the last round and gives the first player one extra point
    public static void endGameTrigger(Bookshelf bookshelf, @NotNull Player player) {
        int score = player.getScore();
        player.setScore(score + 1);
        while (Game.getNextPlayer()!=player)
            Game.gameLoop();

        // continua il giro finchè non arrivi al primo giocatore
    }

    //aasigns all points to player
    public void assignPoints(@NotNull ArrayList<Player> players, PersonalGoalCard personalGoalCard, CommonGoalCard commonGoalCard){
        for (Player player : players) {
            int personalGoalPoints = personalGoalCard.assignPoints(player);
            int commonGoalPoints = commonGoalCard.assignPoints(player);
            int totalPoints = player.getScore() + personalGoalPoints + commonGoalPoints;
            player.setScore(totalPoints);
        }
    }

}
