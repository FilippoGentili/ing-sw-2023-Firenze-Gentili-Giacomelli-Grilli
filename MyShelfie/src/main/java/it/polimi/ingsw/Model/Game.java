package it.polimi.ingsw.Model;

import it.polimi.ingsw.Observer.Observable;

import java.util.*;

//le classi che estendono observable sono quelle che notificheranno l'evento all'esterno
public class Game extends Observable {
    private static ArrayList<Player> listOfPlayers;
    private static Player currentPlayer;
    private static Player nextPlayer;
    private static Player winner;
    private static Player firstPlayer;
    private static CommonGoalCard CommonGoal1, CommonGoal2;

    private static LivingRoom living;
    private static final String SERVER_NAME = "Server";

    public Game() {
        listOfPlayers = new ArrayList<>();
        this.initializeLivingRoom();
    }

    /**
     * @return the name Server, is used in the reply messages
     */
    public static String getServerName(){
        return SERVER_NAME;
    }
    /**
     * the next player of the list becomes the current player and the state is set to start
     *
     */

    public static void gameLoop() {
        currentPlayer.setState(new End());
        Game.setCurrentPlayer(getNextPlayer());
        currentPlayer.setState(new Start());
        currentPlayer.getState().stateAction();
    }

    /**
     * random selection of the first player
     * @return the first player of the match
     * @throws IllegalStateException if the list of players is empty
     */
    public static Player pickFirstPlayer(){
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");
        Random random = new Random();
        int i = random.nextInt(listOfPlayers.size());
        firstPlayer = listOfPlayers.get(i);

        return firstPlayer;
    }

    /**
     *
     * @return the current player that is playing
     * @throws IllegalStateException if the list of players is empty
     */
    public static Player getCurrentPlayer() {
        if(listOfPlayers.isEmpty())
            throw new IllegalStateException("There are no players");
        return currentPlayer;
    }

    /**
     * sets current player
     * @param player
     */
    public static void setCurrentPlayer(Player player) {
        currentPlayer = player;

    }

    /**
     * @return the next player int the list of players
     */

    public static Player getNextPlayer() {
        nextPlayer = listOfPlayers.get((listOfPlayers.indexOf(currentPlayer)+1) % listOfPlayers.size());
        currentPlayer = nextPlayer;
        return nextPlayer;

    }

    /**
     * sets next player
     */

    public static void setNextPlayer(Player player){
        nextPlayer = player;
    }

    /** If there is a tie, the most distant player from the first player wins the game
     * @return winner of the game
     */
    public static Player getWinner(){
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

    /**
     * sets the winner
     */
    public void setWinner(Player player){
        winner = player;
    }

    /**
     *
     * @return list of all players
     */
    public static ArrayList<Player> getPlayers() {
        return listOfPlayers;
    }

    /**
     * adds player to the list of players
     */

    public void addPlayer(Player player) {

        listOfPlayers.add(player);
    }

    /**
     * removes player from the list of players
     * @param player
     */
    public void removePlayer(Player player) {
        if(!listOfPlayers.contains(player)){
            System.out.println("The player is not part of the game");
            return;
        }
        int i = listOfPlayers.indexOf(player);
        listOfPlayers.remove(player);
        if(listOfPlayers.indexOf(currentPlayer) == i){
            currentPlayer = listOfPlayers.get((listOfPlayers.indexOf(currentPlayer) + 1) % listOfPlayers.size());
        }
        System.out.println("The player has been removed from the game");
    }

    /**
     *
     * @return number of tiles on living room board for different amount of players
     */
    public int numberOfTiles() {

        return switch (listOfPlayers.size()) {
            case 2 -> 29;
            case 3 -> 37;
            case 4 -> 45;
            default -> throw new IllegalArgumentException("Invalid number of players");
        };
    }

    /**
     * sets the valid cells of the living room
     */
    public void initializeLivingRoom(){

        living = LivingRoom.getInstance();

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
     * picks two random common goal cards
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
     * sets the personal goal card for each player
     */
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

    /**
     * notifies that it is the last round and gives the first player that calls the method one extra point
     * @param bookshelf
     * @param player
     */
    public static void endGameTrigger(Bookshelf bookshelf, Player player) {
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        int score = player.getScore();
        player.setScore(score + 1);
        // the game goes on until it's the first player's turn
        while (Game.getCurrentPlayer() != Game.pickFirstPlayer())
            Game.gameLoop();
    }

    /**
     * assigns personal goal card points for each player
     * @param players
     */
    public void assignPoints(ArrayList<Player> players) {
        if(players==null || players.isEmpty())
            throw new IllegalArgumentException("The list of players can't be null or empty");

        for (Player player : players) {
            int personalGoalCardPoints = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            int totalPoints = player.getScore() + personalGoalCardPoints ;
            player.setScore(totalPoints);
        }

    }

    /**
     * gets the scoreboard
     * @param players
     * @return arraylist of players in decreasing order of their score
     */
    public ArrayList<Player> getScoreBoard(ArrayList<Player> players){
        ArrayList<Player> scoreBoard = new ArrayList<>(players);
        scoreBoard.sort(Comparator.comparingInt(Player::getScore).reversed());

        return scoreBoard;
    }

    /**
     *
     * @return common goal card 1
     */
    public static CommonGoalCard getCommonGoal1(){
        return CommonGoal1;
    }

    /**
     *
     * @return common goal card 2
     */
    public static CommonGoalCard getCommonGoal2(){
        return CommonGoal2;
    }

    /**
     *
     * @return living room
     */
    public static LivingRoom getLivingRoom(){
        LivingRoom livingRoom = LivingRoom.getInstance();
        return livingRoom;
    }

}