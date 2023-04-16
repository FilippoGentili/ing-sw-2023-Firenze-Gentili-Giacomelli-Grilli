package it.polimi.ingsw;

//import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static ArrayList<Player> listOfPlayers;
    private static int currentPlayer;
    private static CommonGoalCard CommonGoal1, CommonGoal2;
    private static LivingRoom livingRoom;


    public Game() {
        listOfPlayers = new ArrayList<>();
        currentPlayer = 0;
        CommonGoal1 = null;
        CommonGoal2 = null;
        livingRoom = null;
    }

    //next player becomes the current player and puts the state to start
    public static void gameLoop() {
        Player currentPlayer = getNextPlayer();
        currentPlayer.setState(new Start());
        currentPlayer.getState().stateAction();
    }

    //returns the first player of the match (random)
    public static Player pickFirstPlayer(){
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");

        Random random = new Random();
        int i = random.nextInt(listOfPlayers.size());
        return listOfPlayers.get(i);
    }

    //returns the current player that is playing
    public static Player getCurrentPlayer() {
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");

        if(currentPlayer < listOfPlayers.size()) {
            return listOfPlayers.get(currentPlayer);
        }else{
            return null;
        }
    }

    //returns the next player that must play
    public static Player getNextPlayer() {
        int nextPlayer = (currentPlayer+1) % listOfPlayers.size();
        currentPlayer = nextPlayer;
        return listOfPlayers.get(nextPlayer);

    }

    //returns winner of the game, if there is a tie the most distant player from the first player wins the game
    public static Player getWinner(){
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
        if(listOfPlayers.contains(player)){
            System.out.println("The player is already in the game");
            return;
        }
        if(listOfPlayers.size() == 4){
            System.out.println("The game is full");
            return;
        }
        listOfPlayers.add(player);
        System.out.println("The player has been added to the game");
    }

    //removes player from ArrayList
    public void removePlayer(Player player) {
        if(!listOfPlayers.contains(player)){
            System.out.println("The player is not part of the game");
            return;
        }
        int i = listOfPlayers.indexOf(player);
        listOfPlayers.remove(player);
        if(currentPlayer == i){
            currentPlayer = (currentPlayer + 1) % listOfPlayers.size();
        }
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

    public void initializeLivingRoom(){

        LivingRoom living = LivingRoom.getInstance();

        switch(numberOfTiles()){
            case 29:
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if((i==1 && (j==3 || j==4)) ||
                                (i==2 && (j==3 || j==4 || j==5)) ||
                                (i==3 && j!=0 && j!=1 && j!=8) ||
                                (i==4 && j!=0 && j!=8) ||
                                (i==5 && j!=0 && j!=7 && j!=8) ||
                                (i==6 && (j==3 || j==4 || j==5)) ||
                                (i==7 && (j==4 || j==5)))
                            living.setValid(i, j, true);
                        else living.setValid(i, j, false);
                    }
                }
                break;
            case 37:
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if((i==0 && j==3) ||
                                (i==1 && (j==3 || j==4)) ||
                                (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==3 && j!=0 && j!=1) ||
                                (i==4 && j!=0 && j!=8) ||
                                (i==5 && j!=7 && j!=8) ||
                                (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==7 && (j==4 || j==5)) ||
                                (i==8 && j==5))
                            living.setValid(i, j, true);
                        else living.setValid(i, j, false);
                    }
                }
                break;
            case 45:
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if((i==0 && (j==3 || j==4)) ||
                                (i==1 && (j==3 || j==4 || j==5)) ||
                                (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==3 && j!=0) ||
                                (i==4) ||
                                (i==5 && j!=8) ||
                                (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==7 && (j==3 || j==4 || j==5)) ||
                                (i==8 && (j==4 || j==5)))
                            living.setValid(i, j, true);
                        else living.setValid(i, j, false);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal number of tiles");
        }
    }

    //picks 2 random common goal cards
    public void pickCommonGoalCards() {
        List<Integer> availableCommonGoalCards = new ArrayList<>();
        int commonGoalCard1, commonGoalCard2;


        for(int i=1; i<=12; i++){
            availableCommonGoalCards.add(i);
        }

        do{
            Collections.shuffle(availableCommonGoalCards);
            commonGoalCard1 = availableCommonGoalCards.get(0);
            commonGoalCard2 = availableCommonGoalCards.get(1);
        }while(commonGoalCard1 == commonGoalCard2);


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

    //picks 4 random personal goal card (int), removes that so that another player can't pick the same
    /*public ArrayList<Integer> pickPersonalGoalCard() {
        Random random = new Random();
        ArrayList<Integer> pickedCards = new ArrayList<Integer>();

        while (pickedCards.size() < listOfPlayers.size()) {
            int i = random.nextInt(availablePersonaGoalCards.size());
            int pickedCard = availablePersonaGoalCards.get(i);
            if (!pickedCards.contains(pickedCard)) {
                pickedCards.add(pickedCard);
                availablePersonaGoalCards.remove(i);
            }
        }
    }

    //set personalGoalCard to every player
    public void setPersonalGoalCard(){
        ArrayList<Integer> pickedPersonalGoalCards = pickPersonalGoalCard();
        for (int i = 0; i < listOfPlayers.size(); i++) {
            Player player = listOfPlayers.get(i);
            PersonalGoalCard personalGoalCard = new PersonalGoalCard(pickedPersonalGoalCards.get(i));
            player.setPersonalGoalCard(personalGoalCard);
        }
    }*/

    public void setPersonalGoalCard(){

        ArrayList<Integer> availablePersonaGoalCards = new ArrayList<>();
        for(int i=0; i<12; i++) {
            availablePersonaGoalCards.add(i);
        }
        Collections.shuffle(availablePersonaGoalCards);

        int i = 0;
        for(Player player: listOfPlayers){
            player.setPersonalGoalCard(availablePersonaGoalCards.get(i));
            i++;
        }

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
    public void assignPoints(ArrayList<Player> players) {
        if(players==null || players.isEmpty())
            throw new IllegalArgumentException("The list of players can't be null or empty");

        for (Player player : players) {
            int personalGoalCardPoints = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
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