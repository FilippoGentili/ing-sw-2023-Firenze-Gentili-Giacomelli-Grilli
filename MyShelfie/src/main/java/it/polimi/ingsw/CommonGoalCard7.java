package it.polimi.ingsw;

//HELP

public class CommonGoalCard7 extends CommonGoalCard{
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean[][] checkTile = new boolean[6][5];
        TileType TypeSearched;
        int row, col, i, j;

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<5; row++){
            for(col=0; col<4; col++){
                if(!checkTile[row][col]){
                    if(bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row,col+1).getTileType() &&
                    bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row+1,col).getTileType() &&
                    bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row+1,col+1).getTileType()){

                        checkTile[row][col] = true;
                        checkTile[row][col+1] = true;
                        checkTile[row+1][col] = true;
                        checkTile[row+1][col+1] = true;
                        TypeSearched = bookshelf.getTile(row,col).getTileType();

                        for(i=0; i<5; i++){
                            for(j=0; j<4; j++){
                                if(!checkTile[i][j] && !checkTile[i][j+1] && !checkTile[i+1][j] && !checkTile[i+1][j+1]){
                                    if(bookshelf.getTile(i,j).getTileType() == TypeSearched &&
                                    bookshelf.getTile(i,j+1).getTileType() == TypeSearched &&
                                    bookshelf.getTile(i+1,j).getTileType() == TypeSearched &&
                                    bookshelf.getTile(i,j).getTileType() == TypeSearched)
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
