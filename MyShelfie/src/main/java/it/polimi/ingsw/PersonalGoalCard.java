package it.polimi.ingsw;

public class PersonalGoalCard {
    private Tile[][] pGoal;
    private Player player;
    private int points;

    public PersonalGoalCard(Player player){
        this.player = player;
        this.points = 0;
    }

    public int countPoints(){

        return points;
    }
}
