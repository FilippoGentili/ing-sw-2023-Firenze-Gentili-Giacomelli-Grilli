package it.polimi.ingsw;

public class CommonGoalCard3 extends CommonGoalCard{
    @Override
    public boolean check(Bookshelf bookshelf) {

        if(bookshelf.getTile(0,0).getTileType() == bookshelf.getTile(0,4).getTileType() &&
        bookshelf.getTile(0,0).getTileType() == bookshelf.getTile(5,4).getTileType() &&
        bookshelf.getTile(0,0).getTileType() == bookshelf.getTile(5,0).getTileType())
            return true;
        else
            return false;
    }
}
