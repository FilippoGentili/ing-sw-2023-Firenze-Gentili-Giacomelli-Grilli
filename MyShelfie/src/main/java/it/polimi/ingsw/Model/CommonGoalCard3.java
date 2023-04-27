package it.polimi.ingsw.Model;

import static java.util.Objects.isNull;

public class CommonGoalCard3 extends CommonGoalCard {
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
