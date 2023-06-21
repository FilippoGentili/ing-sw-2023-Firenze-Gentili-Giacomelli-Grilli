package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard4Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++) {
            for (int j=0; j<5; j++) {
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
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void AllColumnsAreDifferent(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(j==0) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);
                }else if(j==1) {
                    Tile book = new Tile(TileType.BOOK);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, j);
                }else if(j==2) {
                    Tile frame = new Tile(TileType.FRAME);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, j);
                }else if(j==3) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                } else {
                    Tile plant = new Tile(TileType.PLANT);
                    ArrayList<Tile> TilePlant = new ArrayList<>();
                    TilePlant.add(plant);
                    bookshelf.insertTiles(TilePlant, j);
                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void JustOneRowIsFull(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT);
        Tile book = new Tile(TileType.BOOK);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);

        for(int i=0; i<3; i++) {
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame, i);
        }

        bookshelf.insertTiles(TileBook,3);
        bookshelf.insertTiles(TileCat,4);

        assertFalse(Card.check(bookshelf));

    }

    @Test
    void FourRowsAreFull(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                Tile game = new Tile(TileType.GAME);
                ArrayList<Tile> TileGame = new ArrayList<>();
                TileGame.add(game);
                bookshelf.insertTiles(TileGame, i);
            }
        }

        for(int j=0; j<4; j++) {
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 3);
        }

        for(int j=0; j<4; j++) {
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 4);
        }

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void ThreeColumnsDifferent(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(j==0) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);
                }else if(j==1) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                }else if(j==2) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);
                }else if(j==3) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                } else {
                    Tile plant = new Tile(TileType.PLANT);
                    ArrayList<Tile> TilePlant = new ArrayList<>();
                    TilePlant.add(plant);
                    bookshelf.insertTiles(TilePlant, j);
                }
            }
        }

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void genericTest(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();


        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        bookshelf.insertTiles(tiles, 0);
        tiles.clear();

        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        bookshelf.insertTiles(tiles, 1);
        tiles.clear();

        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        bookshelf.insertTiles(tiles, 2);
        tiles.clear();

        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        bookshelf.insertTiles(tiles, 3);
        tiles.clear();

        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        bookshelf.insertTiles(tiles, 4);
        tiles.clear();

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void genericTest2(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();


        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        bookshelf.insertTiles(tiles, 0);
        tiles.clear();

        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        tiles.add(new Tile(TileType.PLANT));
        bookshelf.insertTiles(tiles, 1);
        tiles.clear();

        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        tiles.add(new Tile(TileType.GAME));
        bookshelf.insertTiles(tiles, 2);
        tiles.clear();

        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        tiles.add(new Tile(TileType.BOOK));
        bookshelf.insertTiles(tiles, 3);
        tiles.clear();

        tiles.add(new Tile(TileType.CAT));
        tiles.add(new Tile(TileType.CAT));
        tiles.add(new Tile(TileType.CAT));
        tiles.add(new Tile(TileType.CAT));
        tiles.add(new Tile(TileType.CAT));
        tiles.add(new Tile(TileType.CAT));
        bookshelf.insertTiles(tiles, 4);
        tiles.clear();

        assertFalse(Card.check(bookshelf));
    }

}