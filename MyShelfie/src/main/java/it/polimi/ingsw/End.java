package it.polimi.ingsw;

import static it.polimi.ingsw.Game.endGameTrigger;

public class End implements State{
    private Player player;
    @Override
    public void stateAction (){
        if(Game.getCommonGoal1().check(player.getBookshelf()) && !player.getPointscg1()){
            player.setScore(player.getScore()+Game.getCommonGoal1().getValue());
            Game.getCommonGoal1().updateValue();
            player.setPointscg1();
        }
        if(Game.getCommonGoal2().check(player.getBookshelf()) && !player.getPointscg2()){
            player.setScore(player.getScore()+Game.getCommonGoal2().getValue());
            Game.getCommonGoal2().updateValue();
            player.setPointscg2();
        }
        if(player.getBookshelf().fullBookshelf()) {
            endGameTrigger(player.getBookshelf(), player);
        }
    }
}
