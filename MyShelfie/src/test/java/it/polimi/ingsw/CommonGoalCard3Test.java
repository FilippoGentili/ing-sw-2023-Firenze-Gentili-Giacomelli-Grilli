package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard3Test {
    @Test
    void FourCornersAsCats(){
        CommonGoalCard Card = new CommonGoalCard3();
        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        ArrayList<Tile> TileCat= new ArrayList<>();
        int i,j;

        TileCat.add(cat);
        Bookshelf bookshelf = new Bookshelf();

        for(i=0; i<4; i++)
            for(j=0; j<5; j++)
                bookshelf.insertTiles(TileCat, i);

        assertTrue(Card.check(bookshelf));
    }

}