package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard1 extends CommonGoalCard{

    @Override
    public boolean check(Bookshelf bookshelf) {
        int count, countGroup=0, row, col, i;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<6; row++){
            for(col=0, count=1; col<4; col++){
                if(!checkTile[row][col]){
                    if(!isNull(bookshelf.getTile(row,col)) && !isNull(bookshelf.getTile(row,col+1))) {
                        if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row, col + 1).getTileType()) {
                            count++;
                            checkTile[row][col] = true;
                            checkTile[row][col + 1] = true;
                        }
                    }
                }
                if(count==2) {
                    countGroup++;
                }
            }
        }

        if(countGroup<6){
            for(row=0; row<5; row++) {
                for (col = 0, count=1; col < 5; col++) {
                    if (!checkTile[row][col]) {
                        if(!isNull(bookshelf.getTile(row,col)) && !isNull(bookshelf.getTile(row+1,col))) {
                            if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col).getTileType()) {
                                count++;
                                checkTile[row][col] = true;
                                checkTile[row + 1][col] = true;
                            }
                        }
                    }
                    if (count==2) {
                        countGroup++;
                    }
                }
            }
        }

        if(countGroup>5)
            return true;
        else
            return false;
    }
}
