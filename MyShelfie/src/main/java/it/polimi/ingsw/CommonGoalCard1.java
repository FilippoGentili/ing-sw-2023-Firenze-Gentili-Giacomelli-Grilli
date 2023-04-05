package it.polimi.ingsw;

public class CommonGoalCard1 extends CommonGoalCard{

    @Override
    public boolean check(Bookshelf bookshelf) {
        int count=0, countGroup, row, col, i;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0, countGroup=0; row<6; row++){
            for(col=0; col<5; col++){
                if(!checkTile[row][col]){
                    count= HorizontalCheck(bookshelf.getTile(row,col),bookshelf,checkTile);
                }
                if(count>1) {
                    countGroup++;
                }
                if(count>2){
                    for(i=0; i<count; i++)
                        checkTile[row][col+2+i] = false;
                }
                if(count<2)
                    checkTile[row][col] = false;
            }
        }

        if(countGroup<6){
            for(row=0, countGroup=0; row<6; row++) {
                for (col = 0; col < 5; col++) {
                    if (!checkTile[row][col]) {
                        count = VerticalCheck(bookshelf.getTile(row, col), bookshelf, checkTile);
                    }
                    if (count > 1) {
                        countGroup++;
                    }
                }
            }
        }

        if(countGroup>5)
            return true;
        else
            return false;
    }
}
