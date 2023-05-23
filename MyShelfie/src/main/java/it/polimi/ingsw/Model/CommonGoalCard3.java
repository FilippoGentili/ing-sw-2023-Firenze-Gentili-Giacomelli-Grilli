package it.polimi.ingsw.Model;

public class CommonGoalCard3 extends CommonGoalCard {

    private static final long serialVersionUID = 6598748641515473980L;
    private final int id=3;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {

        if(bookshelf.getTile(0,0).getTileType() != TileType.NULL && bookshelf.getTile(0,4).getTileType() != TileType.NULL &&
        bookshelf.getTile(5,4).getTileType() != TileType.NULL && bookshelf.getTile(5,0).getTileType() != TileType.NULL) {
            if (bookshelf.getTile(0, 0).getTileType() == bookshelf.getTile(0, 4).getTileType() &&
            bookshelf.getTile(0, 0).getTileType() == bookshelf.getTile(5, 4).getTileType() &&
            bookshelf.getTile(0, 0).getTileType() == bookshelf.getTile(5, 0).getTileType())
                return true;
            else
                return false;
        }else{
            return false;
        }
    }
}
