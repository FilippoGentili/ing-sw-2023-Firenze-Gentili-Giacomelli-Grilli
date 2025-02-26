package it.polimi.ingsw.Model;

public class CommonGoalCard4 extends CommonGoalCard {

    private static final long serialVersionUID = 2215764961371107103L;
    private final int id=4;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean uguale, cellaVuota;
        int row, col, k, countTile, countRow;

        for(row=0, countRow=0; row<6; row++){

            if(bookshelf.getTile(row,0).getTileType() != TileType.NULL) {
                for (col = 1, countTile = 1, cellaVuota=false; col < 5 && !cellaVuota; col++) {

                    if(bookshelf.getTile(row,col).getTileType() != TileType.NULL) {
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
