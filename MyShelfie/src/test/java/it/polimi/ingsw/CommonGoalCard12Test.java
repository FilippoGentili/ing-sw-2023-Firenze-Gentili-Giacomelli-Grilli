package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard12Test {
    @Test
    void FullBookshelf(){
        CommonGoalCard Card = new CommonGoalCard12();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(j==0) {
                    Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);
                }else if(j==1) {
                    Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, j);
                }else if(j==2) {
                    Tile frame = new Tile(TileType.FRAME, Location.BOOKSHELF);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, j);
                }else if(j==3) {
                    Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                } else {
                    Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);
                    ArrayList<Tile> TilePlant = new ArrayList<>();
                    TilePlant.add(plant);
                    bookshelf.insertTiles(TilePlant, j);
                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void EmptyBookshelf(){
        CommonGoalCard Card = new CommonGoalCard12();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void ScaleFromLeftToRight(){
        CommonGoalCard Card = new CommonGoalCard12();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat1 = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        TileCat1.add(cat1);

        for(int i=0; i<5; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 0);
        }
        for(int i=0; i<4; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 1);
        }
        for(int i=0; i<3; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 2);
        }
        for(int i=0; i<2; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 3);
        }

        bookshelf.insertTiles(TileCat1,4);

        assertTrue(Card.check(bookshelf));

        for(int j=0; j<5; j++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, j);
        }

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void ScaleFromRightToLeft(){
        CommonGoalCard Card = new CommonGoalCard12();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat1 = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        TileCat1.add(cat1);

        for(int i=0; i<5; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 4);
        }
        for(int i=0; i<4; i++) {
            Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 3);
        }
        for(int i=0; i<3; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 2);
        }
        for(int i=0; i<2; i++) {
            Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 1);
        }

        bookshelf.insertTiles(TileCat1,0);

        assertTrue(Card.check(bookshelf));

        for(int j=0; j<5; j++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, j);
        }

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void OneExtraTile(){
        CommonGoalCard Card = new CommonGoalCard12();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat1 = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        TileCat1.add(cat1);

        Tile book1 = new Tile(TileType.BOOK, Location.BOOKSHELF);
        ArrayList<Tile> TileBook1 = new ArrayList<>();
        TileBook1.add(book1);

        for(int i=0; i<5; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 4);
        }
        for(int i=0; i<4; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 3);
        }
        for(int i=0; i<3; i++) {
            Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 2);
        }
        for(int i=0; i<2; i++) {
            Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 1);
        }

        bookshelf.insertTiles(TileCat1,0);

        bookshelf.insertTiles(TileBook1,2);

        assertFalse(Card.check(bookshelf));
    }

}