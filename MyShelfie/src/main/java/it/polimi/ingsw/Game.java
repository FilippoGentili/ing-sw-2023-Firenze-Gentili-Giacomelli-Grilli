package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private static int currentPlayer;
    private final ArrayList<Integer> availablePersonaGoalCards;
    private static CommonGoalCard CommonGoal1, CommonGoal2;
    private static LivingRoom livingRoom;


    public Game() {
        listOfPlayers = new ArrayList<>();

        //initialize personalGoalCard
        availablePersonaGoalCards = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            availablePersonaGoalCards.add(i);
        }


    }

    //next player becomes the current player and puts the state to start
    public static void gameLoop() {
        Player currentPlayer = getNextPlayer();
        currentPlayer.setState(new Start());
        currentPlayer.getState().stateAction();
    }

    //returns the first player of the match (random)
    public static Player pickFirstPlayer(){
        Random random = new Random();
        int i = random.nextInt(listOfPlayers.size());
        return listOfPlayers.get(i);
    }

    //returns the current player that is playing
    public static Player getCurrentPlayer() {
        return listOfPlayers.get(currentPlayer);
    }

    //returns the next player that must play
    public static Player getNextPlayer() {
        return listOfPlayers.get(currentPlayer + 1);

    }

    //returns winner of the game, if there is a tie the most distant player from the first player wins the game
    public Player getWinner(){
        Player winner = null;
        int maxScore = 0;
        for(Player player : listOfPlayers){
            int score = player.getScore();
            if(score>maxScore){
                maxScore = score;
                winner = player;
            }else if(score == maxScore){
                int firstPlayer = listOfPlayers.indexOf(Game.pickFirstPlayer());
                int var = (listOfPlayers.indexOf(player) - firstPlayer + listOfPlayers.size()) % listOfPlayers.size();
                int win = (listOfPlayers.indexOf(winner) - firstPlayer + listOfPlayers.size()) % listOfPlayers.size();
                if(var > win){
                    winner = player;
                }

            }
        }
        return winner;
    }

    //returns ArrayList of all participants
    public static ArrayList<Player> getPlayers() {
        return listOfPlayers;
    }

    //adds player to ArrayList
    public void addPlayer(Player player) {
        listOfPlayers.add(player);
    }

    //removes player from ArrayList
    public void removePlayer(Player player) {
        listOfPlayers.remove(player);
    }

    //return number of tiles on living room board for different amount of players
    public int numberOfTiles() {

        return switch (listOfPlayers.size()) {
            case 2 -> 29;
            case 3 -> 37;
            case 4 -> 45;
            default -> throw new IllegalArgumentException("Invalid number of players");
        };
    }

    //picks 2 random common goal cards
    public void pickCommonGoalCards() {
        List<Integer> availableCommonGoalCards = new ArrayList<>();
        for(int i=1; i<=12; i++){
            availableCommonGoalCards.add(i);
        }

        Collections.shuffle(availableCommonGoalCards);
        int commonGoalCard1 = availableCommonGoalCards.get(0);
        int commonGoalCard2 = availableCommonGoalCards.get(1);

        while(commonGoalCard1 == commonGoalCard2){
            Collections.shuffle(availableCommonGoalCards);
            commonGoalCard1 = availableCommonGoalCards.get(0);
            commonGoalCard2 = availableCommonGoalCards.get(1);
        }

        CommonGoal1 = switch(commonGoalCard1){
            case 1 -> new CommonGoalCard1();
            case 2 -> new CommonGoalCard2();
            case 3 -> new CommonGoalCard3();
            case 4 -> new CommonGoalCard4();
            case 5 -> new CommonGoalCard5();
            case 6 -> new CommonGoalCard6();
            case 7 -> new CommonGoalCard7();
            case 8 -> new CommonGoalCard8();
            case 9 -> new CommonGoalCard9();
            case 10 -> new CommonGoalCard10();
            case 11 -> new CommonGoalCard11();
            case 12 -> new CommonGoalCard12();
            default ->  throw new IllegalArgumentException("Invalid commonGoalCardNumber");
        };

        CommonGoal2 = switch(commonGoalCard2){
            case 1 -> new CommonGoalCard1();
            case 2 -> new CommonGoalCard2();
            case 3 -> new CommonGoalCard3();
            case 4 -> new CommonGoalCard4();
            case 5 -> new CommonGoalCard5();
            case 6 -> new CommonGoalCard6();
            case 7 -> new CommonGoalCard7();
            case 8 -> new CommonGoalCard8();
            case 9 -> new CommonGoalCard9();
            case 10 -> new CommonGoalCard10();
            case 11 -> new CommonGoalCard11();
            case 12 -> new CommonGoalCard12();
            default ->  throw new IllegalArgumentException("Invalid commonGoalCardNumber");
        };

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
    public static void endGameTrigger(Bookshelf bookshelf,Player player) {
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        int score = player.getScore();
        player.setScore(score + 1);
        // the game goes on until it's the first player's turn
        while (Game.getCurrentPlayer() != Game.pickFirstPlayer())
            Game.gameLoop();
    }

    //assigns personalGoalCard points to player
    public void assignPoints(ArrayList<Player> players, PersonalGoalCard personalGoalCard) {
        if(players==null || players.isEmpty())
            throw new IllegalArgumentException("The list of players can't be null or empty");

        for (Player player : players) {
            int personalGoalCardPoints = personalGoalCard.assignPoints(pickPersonalGoalCard());
            int totalPoints = player.getScore() + personalGoalCardPoints;
            player.setScore(totalPoints);
        }
    }

    //gets Common Goal Card 1
    public static CommonGoalCard getCommonGoal1(){
        return CommonGoal1;
    }

    //gets Common Goal Card 2
    public static CommonGoalCard getCommonGoal2(){
        return CommonGoal2;
    }

    //gets the Living room
    public static LivingRoom getLivingRoom(){
        return livingRoom;
    }

}