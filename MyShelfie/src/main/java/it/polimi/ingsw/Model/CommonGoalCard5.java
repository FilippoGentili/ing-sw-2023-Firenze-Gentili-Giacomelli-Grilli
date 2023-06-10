package it.polimi.ingsw.Model;


public class CommonGoalCard5 extends CommonGoalCard {

    private static final long serialVersionUID = 2238529378610966421L;
    private final int id=5;

    public int getId(){return this.id;}

    @Override
    public boolean check(Bookshelf bookshelf) {
        int count, countGroup, row, col;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0, countGroup=0; row<6; row++){
            for(col=0; col<5; col++){
                count=0;
                if(bookshelf.getTile(row,col).getTileType() != TileType.NULL) {
                    if (!checkTile[row][col])
                        count = FindAdjacentTiles(bookshelf.getTile(row,col),bookshelf,checkTile,4,0);

                    if(count==4)
                        countGroup++;

                    if(count < 4)
                        ResetCheckTile(bookshelf.getTile(row,col),bookshelf,checkTile);
                }
            }
        }

        if(countGroup>3)
            return true;
        else
            return false;
    }
}
