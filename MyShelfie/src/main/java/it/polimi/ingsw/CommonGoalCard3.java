package it.polimi.ingsw;

public class CommonGoalCard3 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {

        if(player.getBookshelf().getTile(0,0).getTileType().equals(
                player.getBookshelf().getTile(0,4).getTileType()) &&
                player.getBookshelf().getTile(0,0).getTileType().equals(
                        player.getBookshelf().getTile(5,4).getTileType()) &&
                player.getBookshelf().getTile(0,0).getTileType().equals(
                        player.getBookshelf().getTile(5,0).getTileType()))
            return true;
        else
            return false;
    }
}
