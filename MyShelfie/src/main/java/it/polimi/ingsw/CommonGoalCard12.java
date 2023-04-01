package it.polimi.ingsw;
import static java.util.Objects.isNull;

public class CommonGoalCard12 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, prove;
        int row, col, count;

        for(row=0, count=0, prove=true; row<5 && prove; row++){
            count++;
            for(col=0; col<count && prove; col++){
                if(isNull(player.getBookshelf().getTile(row,col)))
                    prove=false;
            }
        }
        if(!prove){
            for(row=1, count=0, prove=true; row<6 && prove; row++){
                count++;
                for(col=0; col<count && prove; col++){
                    if(isNull(player.getBookshelf().getTile(row,col)))
                        prove=false;
                }
            }
        }
        if(!prove){
            for(row=5, count=0, prove=true; row>0 && prove; row--){
                for(col=4; col>=count && prove; col--){
                    if(isNull(player.getBookshelf().getTile(row,col)))
                        prove=false;
                }
                count++;
            }
        }
        if(!prove){
            for(row=4, count=0, prove=true; row>=0 && prove; row--){
                for(col=4; col>=count && prove; col--){
                    if(isNull(player.getBookshelf().getTile(row,col)))
                        prove=false;
                }
                count++;
            }
        }

        if(prove)
            verifica=true;

        return verifica;
    }
}
