package it.polimi.ingsw.Model;

import static it.polimi.ingsw.Model.Game.endGameTrigger;

public class End implements State {
    private Player player;

    /**
     * In the class end the method state action is used to check if the player has completed any of the common goals.
     * A boolean attribute in player is set to check every turn if the points from a specific goal have already been
     * given to the player currently in End
     */
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
