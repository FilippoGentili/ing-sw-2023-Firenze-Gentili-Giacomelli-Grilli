package it.polimi.ingsw;

public class CommonGoalCard8 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, col, k, count=0;
        boolean verifica=false, uguali;

        for(row=0; row<6 && count<2; row++){
            for(col=0, uguali=false; col<4 && !uguali; col++){
                for(k=col+1; k<5 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,col).getTileType().equals(
                            player.getBookshelf().getTile(row,k).getTileType()))
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
