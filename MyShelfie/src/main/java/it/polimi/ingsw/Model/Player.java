package it.polimi.ingsw.Model;

import it.polimi.ingsw.Observer.Observable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Player implements Serializable {
    private static final long serialVersionUID = 859312485853764712L;
    private String nickname;
    private int score;
    private Game game;
    private Bookshelf bookshelf;

    private boolean FirstPlayer;
    private boolean lastPlayer;
    private PersonalGoalCard personalGoalCard;
    private boolean Pointscg1 = false;
    private boolean Pointscg2 = false;
    private ArrayList<Tile> chosenTiles;
    private Integer ChosenColumn;

    /**
     * @return the nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * sets the nickname of the player
     * @param nickName
     */
    public void setNickname(String nickName){
        this.nickname=nickName;
    }


    /**
     * creates a player identified by a nickname and with a personal goal card and a score, initially of zero points
     */
    public Player(Game game) {
        this.game = game;
        this.score = 0;
        this.bookshelf = new Bookshelf();
        this.personalGoalCard = new PersonalGoalCard();
        this.lastPlayer = false;
    }

    public void loadPlayer(Player savedPlayer){
        this.game = savedPlayer.getGame();
        this.score = savedPlayer.getScore();
        this.bookshelf = savedPlayer.getBookshelf();
        this.personalGoalCard = savedPlayer.getPersonalGoalCard();
        this.lastPlayer = savedPlayer.isLastPlayer();
        this.Pointscg1 = savedPlayer.hasPointscg1();
        this.Pointscg2 = savedPlayer.hasPointscg2();
    }

    private boolean hasPointscg2() {
        return Pointscg2;
    }

    private boolean hasPointscg1() {
        return Pointscg1;
    }

    private boolean isLastPlayer() {
        return lastPlayer;
    }

    /**
     * @return the bookshelf of the player
     */
    public Bookshelf getBookshelf(){
        return this.bookshelf;
    }

    /**
     * When a player wants to join a game, it calls this method. the method addPlayer in game adds the player
     * in the list of player dor the specific game
     * @param game
     */
    public void joinGame(Game game){
        if(game==null)
            throw new IllegalArgumentException("Game can't be null");

        game.addPlayer(this);
    }

    /**
     * @return the score of the player
     */
    public int getScore(){
        return score;
    }

    /**
     * sets the score of the player
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * If the player wants to quit the game he is in, it calls this method. The method remove Player in game
     * eliminates the player from the player list of the specific game
     * @param game
     */
    public void quitGame(Game game){
        if(game!=null){
            game.removePlayer(this);
        }
    }

    /**
     * Method called when the player wants to exit the chat
     * @param chat
     */
    public void exitChat(Chat chat){
        if(chat==null)
            throw new IllegalArgumentException("Chat can't be null");
        chat.removeParticipant(this);
    }

    /**
     * @return the instance of the game
     */
    public Game getGame(){
        return game;
    }

    /**
     * Method to assign the personalGoalCard to the player
     * @param personalGoalCard drawn in game
     */
    public void setPersonalGoalCard(int personalGoalCard) {
        this.personalGoalCard.setID(personalGoalCard);
        this.personalGoalCard.setPlayer(this);
    }

    /**
     * @return the specific personal goal card of the player
     */
    public PersonalGoalCard getPersonalGoalCard(){
        return personalGoalCard;
    }

    /**
     * @return the value of the common goal card one attribute
     */
    public boolean getPointscg1(){
        return Pointscg1;
    }

    /**
     * @return the value of the common goal card two attribute
     */
    public boolean getPointscg2(){
        return Pointscg2;
    }

    /**
     * sets to true the common goal card attribute number one after the player completes the goal
     */
    public void setPointscg1(){
        this.Pointscg1=true;
    }

    /**
     * sets to true the common goal card attribute number two after the player completes the goal
     */
    public void setPointscg2(){
        this.Pointscg2=true;
    }

    public void drawTile(int i, int j) throws RemoteException {
        chosenTiles.add(game.getLivingRoom().pickTile(i, j));
    }

    public ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }

    public void setChosenTiles(ArrayList<Tile> chosen){
        chosenTiles = new ArrayList<>();
        for(int i=0; i<chosen.size(); i++)
            chosenTiles.add(chosen.get(i));
    }

    public void ClearChosenTiles(){
        for(int i=0; i<chosenTiles.size(); i++)
            chosenTiles.remove(i);
    }

    public Integer getChosenColumn() {
        return ChosenColumn;
    }

    public void setChosenColumn(Integer chosenColumn) {
        ChosenColumn = chosenColumn;
    }

    public void insertTiles(ArrayList<Tile> chosen, int column){
        getBookshelf().insertTiles(chosenTiles, column);
    }

    public void setLastPlayer(boolean lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public boolean getLastPlayer(){
        return lastPlayer;
    }
}

