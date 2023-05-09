package it.polimi.ingsw.Model;

import static java.util.Objects.isNull;

public class CommonGoalCard8 extends CommonGoalCard {

    private final int id=8;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col, k, count=0;
        boolean verifica=false, uguali, CellaVuota;

        for(row=0; row<6 && count<2; row++){
            for(col=0, uguali=false, CellaVuota=false; col<4 && !uguali && !CellaVuota; col++){
                if(!isNull(bookshelf.getTile(row,col))) {
                    for (k = col + 1; k < 5 && !uguali; k++) {
                        if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row, k).getTileType())
                            uguali = true;
                    }
                }else{
                    CellaVuota = true;
                }
            }
            if(!uguali && !CellaVuota)
                count++;
        }
        if(count==2)
            verifica=true;

        return verifica;
    }
}
