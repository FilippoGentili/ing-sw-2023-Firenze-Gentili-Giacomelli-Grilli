package it.polimi.ingsw.Model;

import static java.util.Objects.isNull;

public class CommonGoalCard9 extends CommonGoalCard {
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean uguale, cellaVuota;
        int countCol, countTile, col, row, k;

        for(col=0, countCol=0; col<5; col++){

            if(!isNull(bookshelf.getTile(0,col))) {

                for (row = 1, countTile = 1, cellaVuota=false; row < 6 && !cellaVuota; row++) {
                    if(!isNull(bookshelf.getTile(row,col))) {

                        for (k = 0, uguale = false; k < row && !uguale; k++) {
                            if (bookshelf.getTile(k, col).getTileType() == bookshelf.getTile(row, col).getTileType())
                                uguale = true;
                        }
                        if (!uguale)
                            countTile++;
                    }else{
                        cellaVuota=true;
                    }
                }

                if(!cellaVuota) {
                    if (countTile < 4)
                        countCol++;
                }
            }
        }

        if(countCol>2)
            return true;
        else
            return false;
    }
}
