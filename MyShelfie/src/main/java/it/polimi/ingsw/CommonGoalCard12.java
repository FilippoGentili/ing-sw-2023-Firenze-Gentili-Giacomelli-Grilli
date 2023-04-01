package it.polimi.ingsw;

public class CommonGoalCard12 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, prove=true;
        int row, column, count;

        for(row=0, count=0, prove=true; row<5 && prove; row++){
            count++;
            for(column=0; column<count && prove; column++){
                if(player.getBookshelf().getTile(row,column).getTileType().equals(null));
                    prove=false;
            }
        }
        if(!prove){
            for(row=1, count=0, prove=true; row<6 && prove; row++){
                count++;
                for(column=0; column<count && prove; column++){
                    if(player.getBookshelf().getTile(row,column).getTileType().equals(null))
                        prove=false;
                }
            }
        }
        if(!prove){
            for(row=5, count=0, prove=true; row>0 && prove; row--){
                for(column=4; column>=count && prove; column--){
                    if(player.getBookshelf().getTile(row,column).getTileType().equals(null))
                        prove=false;
                }
                count++;
            }
        }
        if(!prove){
            for(row=4, count=0, prove=true; row>=0 && prove; row--){
                for(column=4; column>=count && prove; column--){
                    if(player.getBookshelf().getTile(row,column).getTileType().equals(null))
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
