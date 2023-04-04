package it.polimi.ingsw;

public class End implements State{
    private Player player;
    @Override
    public void stateAction (){
        if(Game.getCommonGoal1().check(player)){
            player.setScore(player.getScore()+Game.getCommonGoal1().getValue());
            Game.getCommonGoal1().updateValue();
        }
        if(Game.getCommonGoal2().check(player)){
            player.setScore(player.getScore()+Game.getCommonGoal2().getValue());
            Game.getCommonGoal2().updateValue();
        }
        if(player.getBookshelf().fullBookshelf()) {
            Game.endGameTrigger(player.getBookshelf(), player);
        }
    }
}
