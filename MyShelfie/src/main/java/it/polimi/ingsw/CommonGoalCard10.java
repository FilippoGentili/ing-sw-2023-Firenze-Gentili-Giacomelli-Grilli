package it.polimi.ingsw;

public class CommonGoalCard10 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica = false;
        int row, col;

        for(row=0; row<4 && !verifica; row++){
            for(col=0; col<3 && !verifica; col++){
                if(player.getBookshelf().getTile(row,col).getTileType().equals(
                        player.getBookshelf().getTile(row,col+2).getTileType()) &&
                        player.getBookshelf().getTile(row,col).getTileType().equals(
                                player.getBookshelf().getTile(row+2,col).getTileType()) &&
                        player.getBookshelf().getTile(row,col).getTileType().equals(
                                player.getBookshelf().getTile(row+1,col+1).getTileType()) &&
                        player.getBookshelf().getTile(row,col).getTileType().equals(
                                player.getBookshelf().getTile(row+2,col+2).getTileType()))
                    verifica=true;
            }
        }
        return verifica;
    }
}
