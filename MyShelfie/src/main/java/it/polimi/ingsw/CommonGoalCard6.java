package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard6 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, col, k, count=0;
        boolean verifica=false, uguali, CellaVuota;

        for(col=0; col<5 && count<2; col++){
            for(row=0, uguali=false, CellaVuota=false; row<5 && !uguali && !CellaVuota; row++){
                if(!isNull(player.getBookshelf().getTile(row,col))) {
                    for (k = row + 1; k < 6 && !uguali; k++) {
                        if (player.getBookshelf().getTile(row, col).getTileType().equals(
                                player.getBookshelf().getTile(k, col).getTileType()))
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
