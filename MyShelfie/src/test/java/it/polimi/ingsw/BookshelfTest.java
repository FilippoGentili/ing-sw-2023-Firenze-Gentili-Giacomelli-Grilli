package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookshelfTest {

    @Test
    void getTile_emptySlot(){

        int i=0;
        int j=0;

        Bookshelf bookshelf = new Bookshelf();

        assertNull(bookshelf.getTile(i, j));
    }

    @Test
    void isEmptyTest(){
        int i=0;
        int j=0;

        Bookshelf bookshelf = new Bookshelf();

        assertTrue(bookshelf.isEmpty(i, j));
    }

    @Test
    void spaceAvailable_TrueTest(){

        int col=0;
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, col);

        assertTrue(bookshelf.spaceAvailable(tiles, col));
    }

    @Test
    void spaceAvailable_FalseTest(){

        int col=0;
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, col);

        assertFalse(bookshelf.spaceAvailable(tiles, col));
    }

    @Test
    void insertCorrectly(){
        int col=0;
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.TROPHIE, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.CAT, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.CAT, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, col);

        assertEquals(bookshelf.getTile(5, col), tiles.get(0));
        assertEquals(bookshelf.getTile(4, col), tiles.get(1));
        assertEquals(bookshelf.getTile(3, col), tiles.get(2));
        assertEquals(bookshelf.getTile(2, col), tiles.get(3));
        assertEquals(bookshelf.getTile(1, col), tiles.get(4));
        assertEquals(bookshelf.getTile(0, col), tiles.get(5));
    }

    @Test
    void get4SameAdjacentTilesTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);

        tiles.set(0, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.BOOK, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 1);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 2);

        assertEquals(bookshelf.getSameAdjacentTiles(bookshelf.getTile(4,1)).size(), 4);
    }

    @Test
    void get3SameAdjacentTilesTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);

        tiles.set(0, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.BOOK, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 1);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 2);

        assertEquals(bookshelf.getSameAdjacentTiles(bookshelf.getTile(4,1)).size(), 3);
    }

    @Test
    void get2SameAdjacentTilesTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.BOOK, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 1);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 2);

        assertEquals(bookshelf.getSameAdjacentTiles(bookshelf.getTile(4,1)).size(), 2);
    }

    @Test
    void get1SameAdjacentTilesTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 1);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 2);

        assertEquals(bookshelf.getSameAdjacentTiles(bookshelf.getTile(4,1)).size(), 1);
    }

    @Test
    void get0SameAdjacentTilesTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.CAT, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);

        tiles.set(0, new Tile(TileType.CAT, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.CAT, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 1);

        tiles.set(0, new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.set(1, new Tile(TileType.TROPHIE, Location.BOOKSHELF));
        tiles.set(2, new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 2);

        assertEquals(bookshelf.getSameAdjacentTiles(bookshelf.getTile(4,1)).size(), 0);
    }

    @Test
    void TrueFullBookshelfTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);
        bookshelf.insertTiles(tiles, 1);
        bookshelf.insertTiles(tiles, 2);
        bookshelf.insertTiles(tiles, 3);
        bookshelf.insertTiles(tiles, 4);

        assertTrue(bookshelf.fullBookshelf());
    }

    @Test
    void FalseFullBookshelfTest(){
        Bookshelf bookshelf = new Bookshelf();
        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.BOOK, Location.BOOKSHELF));
        tiles.add(new Tile(TileType.GAME, Location.BOOKSHELF));

        bookshelf.insertTiles(tiles, 0);
        bookshelf.insertTiles(tiles, 1);
        bookshelf.insertTiles(tiles, 2);
        bookshelf.insertTiles(tiles, 3);

        assertFalse(bookshelf.fullBookshelf());
    }





}