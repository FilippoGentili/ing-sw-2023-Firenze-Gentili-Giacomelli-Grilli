package it.polimi.ingsw.Model;


import static java.util.Objects.isNull;

public class CommonGoalCard6 extends CommonGoalCard {

    private static final long serialVersionUID = -4387837490485654750L;
    private final int id=6;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col, k, count=0;
        boolean verifica=false, uguali, CellaVuota;

        for(col=0; col<5 && count<2; col++){
            for(row=0, uguali=false, CellaVuota=false; row<5 && !uguali && !CellaVuota; row++){
                if(!isNull(bookshelf.getTile(row,col))) {
                    for (k = row + 1; k < 6 && !uguali; k++) {
                        if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(k, col).getTileType())
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
