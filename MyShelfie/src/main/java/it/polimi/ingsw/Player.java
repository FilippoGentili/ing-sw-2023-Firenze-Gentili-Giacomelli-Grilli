package it.polimi.ingsw;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private State currentState;
    private int score;
    private Game game;
    private Bookshelf bookshelf;

    private boolean FirstPlayer;
    private PersonalGoalCard personalGoalCard;
    private boolean Pointscg1 = false;

    private boolean Pointscg2 = false;

    /*This method asks the user to choose a Nickname
    public String chooseNickname(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your nickname");

        //Da verificare che non sia uguale a quello di un altro

        return scanner.nextLine();
    }
     */


   public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickName){
    nickname=nickName;
    }



    //The player is created with the chosen nickname and an initial score of 0 points
    public Player(){
        this.score = 0;
        //this.nickname = chooseNickname();
        this.bookshelf = new Bookshelf();
        this.personalGoalCard = new PersonalGoalCard();
    }

    public void InsertTiles(ArrayList<Tile> chosenTiles, int column){

    }

    //The player gets a bookshelf to play with
    public Bookshelf getBookshelf(){
        return this.bookshelf;
    }

    //When a player wants to join a game, it calls this method. the method addPlayer in game adds the player in the list of player dor the specific game
    public void joinGame(Game game){
        if(game==null)
            throw new IllegalArgumentException("Game can't be null");

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
        if(chat==null)
            throw new IllegalArgumentException("Chat can't be null");
        chat.removeParticipant(this);
    }

    public Game getGame(){
        return game;
    }

    public void setPersonalGoalCard(int personalGoalCard) {
        this.personalGoalCard.setID(personalGoalCard);
        this.personalGoalCard.setPlayer(this);
    }

    public PersonalGoalCard getPersonalGoalCard(){
        return personalGoalCard;
    }

    public boolean getPointscg1(){
        return Pointscg1;
    }

    public boolean getPointscg2(){
        return Pointscg2;
    }

    public void setPointscg1(){
        this.Pointscg1=true;
    }

    public void setPointscg2(){
        this.Pointscg2=true;
    }

}

