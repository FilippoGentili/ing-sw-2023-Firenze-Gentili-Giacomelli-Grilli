package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard11 extends CommonGoalCard{
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col, i, j, count = 0;

        for(row=0; row<6; row++){
            for(col=0; col<5; col++){
                if(!isNull(bookshelf.getTile(row,col))) {
                    for (i = 0; i < 6; i++) {
                        for (j = 0; j < 5; j++) {
                            if(!isNull(bookshelf.getTile(i,j))) {
                                if (bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(i,j).getTileType())
                                    count++;
                            }
                        }
                    }
                    count--;

                    if (count >= 8) {
                        return true;
                    } else {
                        count = 0;
                    }

                }
            }
        }

        return false;
    }
}
