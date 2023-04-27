package it.polimi.ingsw.Model;

import static java.util.Objects.isNull;

public class CommonGoalCard7 extends CommonGoalCard {
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean[][] checkTile = new boolean[6][5];
        int row, col, i, j, count=0;

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<5; row++){
            for(col=0; col<4; col++){
                if(!isNull(bookshelf.getTile(row,col)) && !isNull(bookshelf.getTile(row,col+1)) &&
                !isNull(bookshelf.getTile(row+1,col)) && !isNull(bookshelf.getTile(row+1,col+1))){
                    if(!checkTile[row][col] && !checkTile[row][col+1] && !checkTile[row+1][col] && !checkTile[row+1][col+1]) {
                        if (bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row,col + 1).getTileType() &&
                        bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col).getTileType() &&
                        bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col + 1).getTileType()) {
                            checkTile[row][col] = true;
                            checkTile[row][col + 1] = true;
                            checkTile[row + 1][col] = true;
                            checkTile[row + 1][col + 1] = true;
                            count++;
                        }
                    }
                }
            }
        }

        if(count>1) return true;
        else return false;
    }
}
