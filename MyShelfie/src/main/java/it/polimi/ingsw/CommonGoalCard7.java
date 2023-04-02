package it.polimi.ingsw;

//HELP

public class CommonGoalCard7 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean[][] checkTile = new boolean[6][5];
        TileType TypeSearched;
        int row, col, i, j;

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<5; row++){
            for(col=0; col<4; col++){
                if(!checkTile[row][col]){
                    if(player.getBookshelf().getTile(row,col).getTileType().equals(
                    player.getBookshelf().getTile(row,col+1).getTileType()) &&
                    player.getBookshelf().getTile(row,col).getTileType().equals(
                    player.getBookshelf().getTile(row+1,col).getTileType()) &&
                    player.getBookshelf().getTile(row,col).getTileType().equals(
                    player.getBookshelf().getTile(row+1,col+1).getTileType())){

                        checkTile[row][col] = true;
                        checkTile[row][col+1] = true;
                        checkTile[row+1][col] = true;
                        checkTile[row+1][col+1] = true;
                        TypeSearched = player.getBookshelf().getTile(row,col).getTileType();

                        for(i=0; i<5; i++){
                            for(j=0; j<4; j++){
                                if(!checkTile[i][j] && !checkTile[i][j+1] && !checkTile[i+1][j] && !checkTile[i+1][j+1]){
                                    if(player.getBookshelf().getTile(i,j).getTileType().equals(TypeSearched) &&
                                    player.getBookshelf().getTile(i,j+1).getTileType().equals(TypeSearched) &&
                                    player.getBookshelf().getTile(i+1,j).getTileType().equals(TypeSearched) &&
                                    player.getBookshelf().getTile(i,j).getTileType().equals(TypeSearched))
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
