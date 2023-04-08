package it.polimi.ingsw;

import static it.polimi.ingsw.Game.endGameTrigger;

public class End implements State{
    private Player player;
    @Override
    public void stateAction (){
        if(Game.getCommonGoal1().check(player.getBookshelf())){
            player.setScore(player.getScore()+Game.getCommonGoal1().getValue());
            Game.getCommonGoal1().updateValue();
        }
        if(Game.getCommonGoal2().check(player.getBookshelf())){
            player.setScore(player.getScore()+Game.getCommonGoal2().getValue());
            Game.getCommonGoal2().updateValue();
        }
        if(player.getBookshelf().fullBookshelf()) {
            endGameTrigger(player.getBookshelf(), player);
        }
    }
}
