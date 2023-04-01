package it.polimi.ingsw;

public class CommonGoalCard7 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean[][] checkTile = new boolean[6][5];
        TileType TileType;
        int row, col, i, j;

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<5; row++){
            for(col=0; col<4; col++){

            }
        }

        return false;
    }
}
