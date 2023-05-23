package it.polimi.ingsw.Model;


import static java.util.Objects.isNull;

public class CommonGoalCard9 extends CommonGoalCard {

    private static final long serialVersionUID = -1428008211323344134L;
    private final int id=9;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean uguale, cellaVuota;
        int countCol, countTile, col, row, k;

        for(col=0, countCol=0; col<5; col++){

            if(bookshelf.getTile(0,col).getTileType()!=TileType.NULL) {

                for (row = 1, countTile = 1, cellaVuota=false; row < 6 && !cellaVuota; row++) {
                    if(bookshelf.getTile(row,col).getTileType()!=TileType.NULL) {

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
