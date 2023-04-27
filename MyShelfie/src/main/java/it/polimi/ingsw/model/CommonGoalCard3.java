package it.polimi.ingsw.model;
import it.polimi.ingsw.model.Bookshelf;
import it.polimi.ingsw.model.CommonGoalCard;

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
