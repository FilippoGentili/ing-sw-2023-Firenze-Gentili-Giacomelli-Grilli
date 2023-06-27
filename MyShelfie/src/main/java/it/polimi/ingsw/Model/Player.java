package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Player implements Serializable {
    private static final long serialVersionUID = 859312485853764712L;
    private String nickname;
    private int score;
    private Game game;
    private Bookshelf bookshelf;
    private boolean lastPlayer;
    private PersonalGoalCard personalGoalCard;
    private boolean Pointscg1 = false;
    private boolean Pointscg2 = false;
    private ArrayList<Tile> chosenTiles;
    private Integer ChosenColumn;

    /**
     * Gets nickname of the player
     * @return nickname of current player
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Sets nickname of the player
     * @param nickName chosen by the player
     */
    public void setNickname(String nickName){
        this.nickname=nickName;
    }

    /**
     * Creates a player identified by a nickname and with a personal goal card and a score, initially of zero points
     */
    public Player(Game game) {
        this.game = game;
        this.score = 0;
        this.bookshelf = new Bookshelf();
        this.personalGoalCard = new PersonalGoalCard();
        this.lastPlayer = false;
    }

    /**
     * Reload player attributes when reloading a game
     * @param savedPlayer
     */
    public void loadPlayer(Player savedPlayer){
        this.game = savedPlayer.getGame();
        this.score = savedPlayer.getScore();
        this.bookshelf = savedPlayer.getBookshelf();
        this.personalGoalCard = savedPlayer.getPersonalGoalCard();
        this.lastPlayer = savedPlayer.isLastPlayer();
        this.Pointscg1 = savedPlayer.hasPointscg1();
        this.Pointscg2 = savedPlayer.hasPointscg2();
    }

    /**
     * Boolean used to check if a player has reached common goal card 2
     * @return true if it has, false otherwise
     */
    private boolean hasPointscg2() {
        return Pointscg2;
    }
    /**
     * Boolean used to check if a player has reached common goal card 1
     * @return true if it has, false otherwise
     */
    private boolean hasPointscg1() {
        return Pointscg1;
    }

    /**
     * Checks if player is last player
     * @return true if it is, false otherwise
     */
    private boolean isLastPlayer() {
        return lastPlayer;
    }

    /**
     * Gets player bookshelf
     * @return bookshelf of the current player
     */
    public Bookshelf getBookshelf(){
        return this.bookshelf;
    }

    /**
     * Gets score of the player
     * @return current score of the player
     */
    public int getScore(){
        return score;
    }

    /**
     * Sets score of the player
     * @param score points to be set for the player
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the game the player is playing in
     * @return current game
     */
    public Game getGame(){
        return game;
    }

    /**
     * Assigns the personalGoalCard to the player
     * @param personalGoalCard drawn in game
     */
    public void setPersonalGoalCard(int personalGoalCard) {
        this.personalGoalCard.setID(personalGoalCard);
        this.personalGoalCard.setPlayer(this);
    }

    /**
     * Gets personal goal card of the player
     * @return the specific personal goal card of the player
     */
    public PersonalGoalCard getPersonalGoalCard(){
        return personalGoalCard;
    }

    /**
     * Gets the value of boolean for the common goal card one
     * @return true if the goal has been reached, false otherwise
     */
    public boolean getPointscg1(){
        return Pointscg1;
    }

    /**
     * Gets the value of boolean for the common goal card two
     * @return true if the goal has been reached, false otherwise
     */
    public boolean getPointscg2(){
        return Pointscg2;
    }

    /**
     * Sets to true the common goal card attribute number one after the player completes the goal
     */
    public void setPointscg1(){
        this.Pointscg1=true;
    }

    /**
     * Sets to true the common goal card attribute number two after the player completes the goal
     */
    public void setPointscg2(){
        this.Pointscg2=true;
    }

    /**
     * Gets chosen tiles of the player
     * @return arraylist of tiles chosen
     */
    public ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }

    /**
     * Sets chosen tiles for the player
     * @param chosen tiles chosen by the player
     */
    public void setChosenTiles(ArrayList<Tile> chosen){
        chosenTiles = new ArrayList<>();
        for(int i=0; i<chosen.size(); i++)
            chosenTiles.add(chosen.get(i));
    }

    /**
     * Gets chosen column by the player
     * @return chosen column
     */
    public Integer getChosenColumn() {
        return ChosenColumn;
    }

    /**
     * Sets the column chosen by the player
     * @param chosenColumn in the bookshelf to set the tile
     */
    public void setChosenColumn(Integer chosenColumn) {
        ChosenColumn = chosenColumn;
    }

    /**
     * Inserts tile chosen in the bookshelf
     * @param chosen arraylist of chosen tiles
     * @param column where to insert the tiles
     */
    public void insertTiles(ArrayList<Tile> chosen, int column){
        getBookshelf().insertTiles(chosenTiles, column);
    }

    /**
     * Sets if player is the last or not
     * @param lastPlayer true if it's the last, false otherwise
     */
    public void setLastPlayer(boolean lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

}

