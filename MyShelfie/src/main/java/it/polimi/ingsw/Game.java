package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private static int currentPlayer;
    private ArrayList<Integer> availablePersonaGoalCards;


    public Game() {
        listOfPlayers = new ArrayList<>();
        //initialize personalGoalCard
        availablePersonaGoalCards = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            availablePersonaGoalCards.add(i);


            // inizializza livingroom
        }
    }

    //process of one round
    public static void gameLoop() {

    }

    //returns the current player that is playing
    public Player getCurrentPlayer() {
        return listOfPlayers.get(currentPlayer);
    }

    //returns the next player that must play
    public static Player getNextPlayer() {
        return listOfPlayers.get(currentPlayer + 1);

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
    public List<CommonGoalCard> pickCommonGoalCards() {
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

        return listOfCards.subList(0, 2);
    }

    //picks 1 random personal goal card (int) removes that so that another player can't pick the same
    public int pickPersonalGoalCard() {
        Random random = new Random();
        int i = random.nextInt(availablePersonaGoalCards.size());
        int pickedCard = availablePersonaGoalCards.get(i);

        availablePersonaGoalCards.remove(i);
        return pickedCard;
    }


    //notify that it is the last round and gives the first player one extra point
    public static void endGameTrigger(Bookshelf bookshelf, @NotNull Player player) {
        int score = player.getScore();
        player.setScore(score + 1);
        while (Game.getNextPlayer() != player)
            Game.gameLoop();

        // continua il giro finchè non arrivi al primo giocatore
    }

    //assigns all points to player
    public void assignPoints(@NotNull ArrayList<Player> players, PersonalGoalCard personalGoalCard, CommonGoalCard commonGoalCard) {
        for (Player player : players) {
            int personalGoalPoints = personalGoalCard.assignPoints(player);
            int commonGoalPoints = commonGoalCard.assignPoints(player);
            int totalPoints = player.getScore() + personalGoalPoints + commonGoalPoints;
            player.setScore(totalPoints);
        }
    }

}
