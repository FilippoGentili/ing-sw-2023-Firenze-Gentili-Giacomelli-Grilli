package it.polimi.ingsw.Model;


public class CommonGoalCard10 extends CommonGoalCard {

    private static final long serialVersionUID = -6788028669467636406L;
    private final int id=10;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col;

        for(row=0; row<4; row++){
            for(col=0; col<3; col++){
                if(bookshelf.getTile(row,col).getTileType()!=TileType.NULL && bookshelf.getTile(row,col+2).getTileType()!=TileType.NULL &&
                bookshelf.getTile(row+2,col).getTileType()!=TileType.NULL && bookshelf.getTile(row+2,col+2).getTileType()!=TileType.NULL &&
                bookshelf.getTile(row+1,col+1).getTileType()!=TileType.NULL) {
                    if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row, col + 2).getTileType() &&
                    bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 2, col).getTileType() &&
                    bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col + 1).getTileType() &&
                    bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 2, col + 2).getTileType())
                        return true;
                }
            }
        }
        return false;
    }
}
