package it.polimi.ingsw;

public class CommonGoalCard4 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, uguale;
        int row, column, k, countTile, countRow=0;

        for(row=0; row<6; row++){
            for(column=1, countTile=1; column<5; column++){
                for(k=0, uguale=false; k<column && !uguale; k++){
                    if(player.getBookshelf().getTile(row,k).getTileType().equals(
                            player.getBookshelf().getTile(row,column).getTileType()))
                        uguale=true;
                }
                if(!uguale)
                    countTile++;
            }
            if(countTile<=3)
                countRow++;
        }
        if(countRow>3)
            verifica=true;

        return verifica;
    }
}
