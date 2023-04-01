package it.polimi.ingsw;

public class CommonGoalCard6 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, col, k, count=0;
        boolean verifica=false, uguali;

        for(col=0; col<5 && count<2; col++){
            for(row=0, uguali=false; row<5 && !uguali; row++){
                for(k=row+1; k<6 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,col).getTileType().equals(
                            player.getBookshelf().getTile(k,col).getTileType()))
                        uguali=true;
                }
            }
            if(!uguali)
                count++;
        }
        if(count==2)
            verifica=true;

        return verifica;
    }
}
