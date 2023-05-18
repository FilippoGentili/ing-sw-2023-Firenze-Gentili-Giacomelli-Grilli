package it.polimi.ingsw.Model;


import static java.util.Objects.isNull;

public class CommonGoalCard3 extends CommonGoalCard {

    private static final long serialVersionUID = 6598748641515473980L;
    private final int id=3;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {

        if(!isNull(bookshelf.getTile(0,0)) && !isNull(bookshelf.getTile(0,4)) &&
        !isNull(bookshelf.getTile(5,4)) && !isNull(bookshelf.getTile(5,0))) {
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
