package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.CommonGoalCard;
import it.polimi.ingsw.Model.Game;

/**
 * Message used from Server to client to let the clients know the updated value for a specific commonGoalCard
 */
public class UpdatePoints extends Message{
    private static final long serialVersionUID = 1477878597230914222L;
    private final int updatedValue;
    private final CommonGoalCard commonGoalCard;
    public UpdatePoints(int updatedValue, CommonGoalCard commonGoalCard) {
        super(Game.getServerName(), MessageType.UPDATE_POINTS);
        this.updatedValue=updatedValue;
        this.commonGoalCard=commonGoalCard;
    }


    public int getUpdatedValue(){
        return updatedValue;
    }

    public CommonGoalCard getCommonGoalCard(){
        return commonGoalCard;
    }

    @Override
    public String toString(){
        return "The points for CommonGoalCard " + getCommonGoalCard() + "have been updated to " + getUpdatedValue();
    }
}
