package it.polimi.ingsw;

import java.util.Scanner;

public class Player {
    private final String nickname;
    private State currentState;
    private int score;
    private Game game;
    private Bookshelf bookshelf;
    private final int goalCard;
    private boolean FirstPlayer;

    //This method asks the user to choose a Nickname
    public String chooseNickname(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your nickname");
        String nickname = scanner.nextLine();

        //Da verificare che non sia uguale a quello di un altro

        return nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    //The player is created with the chosen nickname and an initial score of 0 points
    public Player(){
        this.score = 0;
        this.goalCard=game.pickPersonalGoalCard();
        this.nickname=chooseNickname();
    }

    public int getGoalCard(){
        return goalCard;
    }

    //The player gets a bookshelf to play with
    public Bookshelf getBookshelf(){
        return this.bookshelf;
    }

    //When a player wants to join a game, it calls this method. the method addPlayer in game adds the player in the list of player dor the specific game
    public void joinGame(Game game){
        game.addPlayer(this);
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    //If the player wants to quit the game he is in, it calls this method. The method remove Player in game eliminates the player from the player list of the specific game
    public void quitGame(Game game){
        if(game!=null){
            game.removePlayer(this);
        }
    }

    public void setState(State state){
        currentState = state;
    }

    public State getState(){
        return currentState;
    }
    public void stateAction(){
        currentState.stateAction();
    }

    public void exitChat(Chat chat){
        chat.removeParticipant(this);
    }

    public Game getGame(){
        return game;
    }

}

