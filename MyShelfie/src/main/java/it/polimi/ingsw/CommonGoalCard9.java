package it.polimi.ingsw;

public class CommonGoalCard9 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, uguale;
        int countRow=0, countTile, column, row, k;

        for(column=0; column<5; column++){
            for(row=1, countTile=1; row<6; row++){
                for(k=0, uguale=false; k<row && !uguale; k++){
                    if(player.getBookshelf().getTile(k,column).getTileType().equals(
                            player.getBookshelf().getTile(row,column).getTileType()))
                        uguale=true;
                }
                if(!uguale)
                    countTile++;
            }
            if(countTile<4)
                countRow++;
        }
        if(countRow>2)
            verifica=true;

        return verifica;
    }
}
