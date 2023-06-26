package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.*;

//le classi che estendono observable sono quelle che notificheranno l'evento all'esterno
public class Game implements Serializable {
    private static final long serialVersionUID = -4957685347178142310L;
    private ArrayList<Player> listOfPlayers;
    private int numOfPlayers;
    private  Player currentPlayer;
    private  Player nextPlayer;
    private  Player winner;
    private  Player firstPlayer;
    private  CommonGoalCard CommonGoal1, CommonGoal2;
    private LivingRoom living;
    private Bag bag;
    private static final String SERVER_NAME = "Server";

    /**
     * Constructor of class game
     */
    public Game() {
        listOfPlayers = new ArrayList<Player>();
        pickCommonGoalCards();
        living = new LivingRoom();
        bag = new Bag(this);
    }

    /**
     * Returns the bag set for this game
     * @return bag of the current game
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * @return the name Server, is used in the reply messages
     */
    public static String getServerName(){
        return SERVER_NAME;
    }

    /**
     * Sets number of player for the game
     * @param num number of player selected by the first player to join the game
     */
    public void setNumOfPlayers(int num){
        this.numOfPlayers = num;
    }


    /**
     * Random selection of the first player
     * @return the first player of the match
     * @throws IllegalStateException if the list of players is empty
     */
    public Player pickFirstPlayer(){
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");
        Random random = new Random();
        int i = random.nextInt(listOfPlayers.size());
        firstPlayer = listOfPlayers.get(i);

        return firstPlayer;
    }

    /**
     * Returns current player of the turn
     * @return the current player that is playing
     * @throws IllegalStateException if the list of players is empty
     */
    public Player getCurrentPlayer() {
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");
        return currentPlayer;
    }

    /**
     * Sets current player
     * @param player that is set as current player
     */
    public  void setCurrentPlayer(Player player) {
        currentPlayer = player;

    }

    /**
     * Returns next player
     * @return the next player int the list of players
     */
    public Player getNextPlayer() {
        nextPlayer = listOfPlayers.get((listOfPlayers.indexOf(currentPlayer)+1) % listOfPlayers.size());
        currentPlayer = nextPlayer;
        return nextPlayer;

    }


    /** If there is a tie, the most distant player from the first player wins the game
     * @return winner of the game
     */
    public Player getWinner(){
        int maxScore = 0;
        for(Player player : listOfPlayers){
            int score = player.getScore();
            if(score>maxScore){
                maxScore = score;
                winner = player;
            }else if(score == maxScore){
                int firstPlayer = listOfPlayers.indexOf(pickFirstPlayer());
                int var = (listOfPlayers.indexOf(player) - firstPlayer + listOfPlayers.size()) % listOfPlayers.size();
                int win = (listOfPlayers.indexOf(winner) - firstPlayer + listOfPlayers.size()) % listOfPlayers.size();
                if(var > win){
                    winner = player;
                }

            }
        }
        return winner;
    }

    /**
     * Sets the winner
     * @param player that is winning the game
     */
    public void setWinner(Player player){
        winner = player;
    }

    /**
     * Returns the list of players for the current game
     * @return list of all players
     */
    public ArrayList<Player> getPlayers() {

        ArrayList<Player> players = new ArrayList<>();

        players.addAll(0, listOfPlayers);

        return players;
    }


    /**
     * Adds player to the list of players
     * @param player that has to be added
     */
    public void addPlayer(Player player) {

        listOfPlayers.add(player);
    }

    /**
     * Removes player from the list of players
     * @param player
     */
    public void removePlayer(Player player) {
        if(listOfPlayers.contains(player))
            listOfPlayers.remove(player);
    }

    /**
     * Returns number of tiles depending on the number of players for the game
     * @return number of tiles on living room board
     */
    public int numberOfTiles() {

        return switch (numOfPlayers) {
            case 2 -> 29;
            case 3 -> 37;
            case 4 -> 45;
            default -> throw new IllegalArgumentException("Invalid number of players");
        };
    }

    /**
     * Sets the valid cells of the living room
     */
    public void initializeLivingRoom(){

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

    /**
     * Picks two random common goal cards
     */
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

    /**
     * Sets the personal goal card for each player
     */
    public void setPersonalGoalCard(){

        ArrayList<Integer> availablePersonaGoalCards = new ArrayList<>();
        for(int i=1; i<=12; i++) {
            availablePersonaGoalCards.add(i);
        }
        Collections.shuffle(availablePersonaGoalCards);

        int i = 0;
        for(Player player: listOfPlayers){
            player.setPersonalGoalCard(availablePersonaGoalCards.get(i));
            i++;
        }

    }

    /**
     * Notifies that it is the last round and gives the first player that calls the method one extra point
     * @param bookshelf of the  player ending the turn
     * @param player ending the turn
     */
    public void endGameTrigger(Bookshelf bookshelf, Player player) {
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        int score = player.getScore();
        player.setScore(score + 1);
        player.setLastPlayer(true);
    }

    /**
     * Assigns personal goal card points for each player
     * @param players list of players of the game
     */
    public void assignPoints(ArrayList<Player> players) {
        if(players==null || players.isEmpty())
            throw new IllegalArgumentException("The list of players can't be null or empty");

        for (Player player : players) {
            int personalGoalCardPoints = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            int bookshelfPoints = player.getBookshelf().countPoints();
            int totalPoints = player.getScore() + personalGoalCardPoints + bookshelfPoints;
            player.setScore(totalPoints);
        }

    }

    /**
     * Gets the scoreboard
     * @param players list of players of the game
     * @return arraylist of players in decreasing order of their score
     */
    public ArrayList<Player> getScoreBoard(ArrayList<Player> players){
        ArrayList<Player> scoreBoard = new ArrayList<>(players);
        scoreBoard.sort(Comparator.comparingInt(Player::getScore).reversed());

        return scoreBoard;
    }

    /**
     * Returns common goal card 1
     * @return first common goal extracted
     */
    public CommonGoalCard getCommonGoal1(){
        return CommonGoal1;
    }

    /**
     * Returns common goal card 2
     * @return second common goal card extracted
     */
    public CommonGoalCard getCommonGoal2(){
        return CommonGoal2;
    }

    /**
     * Returns living room
     * @return living room board
     */
    public LivingRoom getLivingRoom() {
        return living;
    }

    /**
     * Reloads a saved game
     * @param savedGame to be reloaded
     */
    public void loadGame(Game savedGame){
        listOfPlayers=savedGame.getPlayers();
        numOfPlayers=savedGame.getNumOfPlayers();
        currentPlayer=savedGame.getCurrentPlayer();
        nextPlayer=savedGame.getNextPlayer();
        winner=savedGame.getWinner();
        firstPlayer=savedGame.getFirstPlayer();
        CommonGoal1=savedGame.getCommonGoal1();
        CommonGoal2= savedGame.getCommonGoal2();
        living=savedGame.getLivingRoom();
        bag=savedGame.getBag();

        for(Player player : listOfPlayers){
            player.loadPlayer(player);
        }
    }

    /**
     * Returns first player
     * @return first player of the game
     */
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * Returns number of players of the game
     * @return number of players
     */
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

}