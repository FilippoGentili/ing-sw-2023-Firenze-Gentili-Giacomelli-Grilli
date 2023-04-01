package it.polimi.ingsw;

public class CommonGoalCard8 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, column, k, count=0;
        boolean verifica=false, uguali;

        for(row=0; row<6 && count<2; row++){
            for(column=0, uguali=false; column<4 && !uguali; column++){
                for(k=column+1; k<5 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,column).getTileType().equals(
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
