package it.polimi.ingsw;

public class CommonGoalCard10 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica = false;
        int row, column;

        for(row=0; row<4 && !verifica; row++){
            for(column=0; column<3 && !verifica; column++){
                if(player.getBookshelf().getTile(row,column).getTileType().equals(
                        player.getBookshelf().getTile(row,column+2).getTileType()) &&
                        player.getBookshelf().getTile(row,column).getTileType().equals(
                                player.getBookshelf().getTile(row+2,column).getTileType()) &&
                        player.getBookshelf().getTile(row,column).getTileType().equals(
                                player.getBookshelf().getTile(row+1,column+1).getTileType()) &&
                        player.getBookshelf().getTile(row,column).getTileType().equals(
                                player.getBookshelf().getTile(row+2,column+2).getTileType()))
                    verifica=true;
            }
        }
        return verifica;
    }
}
