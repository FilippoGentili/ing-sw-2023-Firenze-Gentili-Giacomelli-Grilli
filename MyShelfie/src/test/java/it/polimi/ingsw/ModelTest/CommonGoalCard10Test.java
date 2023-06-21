package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard10Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard10();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++) {
            for (int j = 0; j < 5; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

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

        Tile cat = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);

        Tile cat1 = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        TileCat1.add(cat1);

        Tile cat2 = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat2 = new ArrayList<>();
        TileCat2.add(cat2);

        Tile cat3 = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat3 = new ArrayList<>();
        TileCat3.add(cat3);

        Tile cat4 = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat4 = new ArrayList<>();
        TileCat4.add(cat4);

        Tile book = new Tile(TileType.BOOK);
        ArrayList<Tile> TileBook = new ArrayList<>();
        TileBook.add(book);

        Tile book1 = new Tile(TileType.BOOK);
        ArrayList<Tile> TileBook1 = new ArrayList<>();
        TileBook1.add(book1);

        Tile book2 = new Tile(TileType.BOOK);
        ArrayList<Tile> TileBook2 = new ArrayList<>();
        TileBook2.add(book2);


        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileBook,0);
        bookshelf.insertTiles(TileCat1,0);

        bookshelf.insertTiles(TileBook1,1);
        bookshelf.insertTiles(TileCat2,1);

        bookshelf.insertTiles(TileCat3,2);
        bookshelf.insertTiles(TileBook2,2);
        bookshelf.insertTiles(TileCat4,2);

        assertTrue(Card.check(bookshelf));
    }

}