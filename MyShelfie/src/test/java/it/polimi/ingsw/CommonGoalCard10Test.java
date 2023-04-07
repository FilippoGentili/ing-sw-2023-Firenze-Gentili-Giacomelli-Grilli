package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard10Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard10();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);

        for(int i=0; i<6; i++)
            for(int j=0; j<5; j++)
                bookshelf.insertTiles(TileCat,j);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void EmptyBookshelf(){
        CommonGoalCard Card = new CommonGoalCard10();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void CreatingOneX(){
        CommonGoalCard Card = new CommonGoalCard10();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);

        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileBook,0);
        bookshelf.insertTiles(TileCat,0);

        bookshelf.insertTiles(TileBook,1);
        bookshelf.insertTiles(TileCat,1);

        bookshelf.insertTiles(TileCat,2);
        bookshelf.insertTiles(TileBook,2);
        bookshelf.insertTiles(TileCat,2);

        assertTrue(Card.check(bookshelf));
    }

}