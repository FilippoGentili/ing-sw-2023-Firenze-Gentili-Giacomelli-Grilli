package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard11Test {
    @Test
    void AllBookshelfHasOneTileType(){
        CommonGoalCard Card = new CommonGoalCard3();
        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat= new ArrayList<>();
        int i,j;

        TileCat.add(cat);
        Bookshelf bookshelf = new Bookshelf();

        for(i=0; i<6; i++)
            for(j=0; j<5; j++)
                bookshelf.insertTiles(TileCat, j);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void BookshelfStillEmpty(){
        CommonGoalCard Card = new CommonGoalCard3();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

}