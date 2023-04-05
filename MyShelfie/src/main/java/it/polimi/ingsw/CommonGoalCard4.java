package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard4 extends CommonGoalCard{
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean uguale, cellaVuota;
        int row, col, k, countTile, countRow;

        for(row=0, countRow=0; row<6; row++){

            if(!isNull(bookshelf.getTile(row,0))) {
                for (col = 1, countTile = 1, cellaVuota=false; col < 5 && !cellaVuota; col++) {

                    if(!isNull(bookshelf.getTile(row,col))) {
                        for (k = 0, uguale = false; k < col && !uguale; k++) {

                            if (bookshelf.getTile(row, k).getTileType() == bookshelf.getTile(row, col).getTileType())
                                uguale = true;
                        }

                        if (!uguale)
                            countTile++;

                    }else{
                        cellaVuota = true;
                    }

                }

                if(!cellaVuota) {
                    if (countTile <= 3)
                        countRow++;

                }

            }
        }

        if(countRow>3)
            return true;
        else
            return false;
    }
}
