package it.polimi.ingsw;

public class CommonGoalCard1 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int count=0, countGroup, row, col;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0, countGroup=0; row<6; row++){
            for(col=0; col<5; col++){
                if(!checkTile[row][col]){
                    count= FindSubmatrix(player.getBookshelf().getTile(row, col), player, checkTile);
                }
                if(count>1)
                    countGroup++;
            }
        }

        if(countGroup>5)
            return true;
        else
            return false;
    }
}
