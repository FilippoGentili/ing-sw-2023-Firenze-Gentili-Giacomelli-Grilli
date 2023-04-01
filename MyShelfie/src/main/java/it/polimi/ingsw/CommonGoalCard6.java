package it.polimi.ingsw;

public class CommonGoalCard6 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, column, k, count=0;
        boolean verifica=false, uguali;

        for(column=0; column<5 && count<2; column++){
            for(row=0, uguali=false; row<5 && !uguali; row++){
                for(k=row+1; k<6 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,column).getTileType().equals(
                            player.getBookshelf().getTile(k,column).getTileType()))
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
