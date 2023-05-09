package it.polimi.ingsw.Model;

import static java.util.Objects.isNull;

public class CommonGoalCard11 extends CommonGoalCard {

    private final int id=11;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col, count;

        for(TileType t: TileType.values()){
            count=0;

            for(row=0; row<6; row++){
                for(col=0; col<5; col++){
                    if(!isNull(bookshelf.getTile(row,col)) && bookshelf.getTile(row,col).getTileType() == t){
                        count++;
                    }
                }
            }

            if(count>=8)  return true;

        }

        return false;
    }
}
