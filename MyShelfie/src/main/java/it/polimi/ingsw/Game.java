package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private static int currentPlayer;

    public Game() {
        listOfPlayers = new ArrayList<>();


        //inizialliza livingroom

    }

    //
    public static void gameLoop(){

    }

    //returns the current player playing
    public Player getCurrentPlayer() {
        return listOfPlayers.get(currentPlayer);
    }

    //returns next player that must play
    public static Player getNextPlayer(){
        return listOfPlayers.get(currentPlayer+1);
    }

    //returns the ArrayList of participants
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

    //returns number of tiles on the living room board for the number of players that are playing
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

    //picks the first player
    public Player pickFirstPlayer(){

    }

    //pick random 2 common goalcards
    public List<CommonGoalCard> pickCommonGoalCards(){
        List<CommonGoalCard> listOfCards = new ArrayList<>();

        listOfCards.add(new CommonGoalCard1());
        listOfCards.add(new CommonGoalCard2());
        listOfCards.add(new CommonGoalCard3());
        listOfCards.add(new CommonGoalCard4());
        listOfCards.add(new CommonGoalCard5());
        listOfCards.add(new CommonGoalCard6());
        listOfCards.add(new CommonGoalCard7());
        listOfCards.add(new CommonGoalCard8());
        listOfCards.add(new CommonGoalCard9());
        listOfCards.add(new CommonGoalCard10());
        listOfCards.add(new CommonGoalCard11());
        listOfCards.add(new CommonGoalCard12());

        Collections.shuffle(listOfCards);

        List<CommonGoalCard> pickedCards = listOfCards.subList(0, 2);

        return pickedCards;
    }

    //pick random one personal goal card for each player
    public pickPersonalGoalCard(){

    }

    //notify last round and assign one point to the first player that finished
    public static void endGameTrigger(Bookshelf bookshelf, @NotNull Player player) {
        int score = player.getScore();
        player.setScore(score + 1);
        while(Game.getNextPlayer()!=player){
            Game.gameLoop();
        }



        // continua il giro finchè non arrivi al primo giocatore
    }

    //assign all points to the player
    public void assignPoints(@NotNull ArrayList<Player> players, PersonalGoalCard personalGoalCard, CommonGoalCard commonGoalCard){
        for (Player player : players) {
            int personalGoalPoints = personalGoalCard.assignPoints(player);
            int commonGoalPoints = commonGoalCard.assignPoints(player);
            int totalPoints = player.getScore() + personalGoalPoints + commonGoalPoints;
            player.setScore(totalPoints);
        }
    }

}