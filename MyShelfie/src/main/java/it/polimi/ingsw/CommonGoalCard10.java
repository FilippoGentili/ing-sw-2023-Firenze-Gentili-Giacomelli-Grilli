package it.polimi.ingsw;

public class CommonGoalCard10 extends CommonGoalCard{
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col;

        for(row=0; row<4; row++){
            for(col=0; col<3; col++){
                if(bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row,col+2).getTileType() &&
                bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row+2,col).getTileType() &&
                bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row+1,col+1).getTileType() &&
                bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row+2,col+2).getTileType())
                    return true;
            }
        }
        return false;
    }
}
