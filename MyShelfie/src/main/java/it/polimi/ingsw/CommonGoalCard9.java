package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard9 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean uguale, cellaVuota;
        int countCol, countTile, col, row, k;

        for(col=0, countCol=0; col<5; col++){

            if(!isNull(player.getBookshelf().getTile(0,col))) {

                for (row = 1, countTile = 1, cellaVuota=false; row < 6 && !cellaVuota; row++) {
                    if(!isNull(player.getBookshelf().getTile(row,col))) {

                        for (k = 0, uguale = false; k < row && !uguale; k++) {
                            if (player.getBookshelf().getTile(k, col).getTileType().equals(
                                    player.getBookshelf().getTile(row, col).getTileType()))
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
