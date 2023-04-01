package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Player> listOfPlayers;

    public Game() {
        this.listOfPlayers = new ArrayList<>();
    }

    public static ArrayList<Player> getPlayers() {
        return listOfPlayers;
    }

    public void addPlayer(Player player) {
        this.listOfPlayers.add(player);
    }

    public void removePlayer(Player player) {
        this.listOfPlayers.remove(player);
    }

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

    public void endGameTrigger(@NotNull Bookshelf bookshelf, Player player) {
        if (bookshelf.fullBookshelf()) {
            int score = player.getScore();
            player.setScore(score + 1);
        }

        // si può fare solo un giro poi il gioco finisce
    }


    public void assignPoints(@NotNull ArrayList<Player> players, PersonalGoalCard personalGoalCard, CommonGoalCard commonGoalCard){
        for (Player player : players) {
            int personalGoalPoints = personalGoalCard.assignPoints(player);
            int commonGoalPoints = commonGoalCard.assignPoints(player);
            int totalPoints = player.getScore() + personalGoalPoints + commonGoalPoints;
            player.setScore(totalPoints);
        }
    }

}
