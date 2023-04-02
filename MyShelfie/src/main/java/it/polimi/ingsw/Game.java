package it.polimi.ingsw;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private int currentPlayer;
    private CommonGoalCard CommonGoal1, CommonGoal2;

    public Game() {
        listOfPlayers = new ArrayList<>();

        //scegliere carte comuni e personali
        // livingroom
    }

    public Player getCurrentPlayer() {
        return listofplayers.get(currentPlayer);
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

    public static void endGameTrigger(Bookshelf bookshelf, @NotNull Player player) {
        int score = player.getScore();
        player.setScore(score + 1);



        // continua il giro finchè non arrivi al primo giocatore
    }


    public void assignPoints(@NotNull ArrayList<Player> players, PersonalGoalCard personalGoalCard, CommonGoalCard commonGoalCard){
        for (Player player : players) {
            int personalGoalPoints = personalGoalCard.assignPoints(player);
            int commonGoalPoints = commonGoalCard.assignPoints(player);
            int totalPoints = player.getScore() + personalGoalPoints + commonGoalPoints;
            player.setScore(totalPoints);
        }
    }

    public CommonGoalCard getCommonGoal1(){
        return this.CommonGoal1;
    }
    public CommonGoalCard getCommonGoal2(){
        return this.CommonGoal2;
    }

}
