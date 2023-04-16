package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard7Test {

    @Test
    void FullBookshelfAllEquals(){
        CommonGoalCard Card = new CommonGoalCard7();
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
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void JustOneSquare(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat,i);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void TwoEqualsSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<4; i++) {
            for (int j = 0; j < 2; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, i);
            }
        }

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void TwoDifferentSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<2; i++) {
            for (int j = 0; j < 2; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        for(int i=0; i<2; i++) {
            for (int j = 0; j < 2; j++) {
                Tile book = new Tile(TileType.BOOK);
                ArrayList<Tile> TileBook = new ArrayList<>();
                TileBook.add(book);
                bookshelf.insertTiles(TileBook, j);
            }
        }

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void FullBookshelfButJustTwoEqualsSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<2; i++) {
            for (int j = 0; j < 2; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        for(int i=0; i<2; i++) {
            for (int j = 0; j < 2; j++) {
                Tile book = new Tile(TileType.BOOK);
                ArrayList<Tile> TileBook = new ArrayList<>();
                TileBook.add(book);
                bookshelf.insertTiles(TileBook,j + 2);
            }
        }

        for(int i=0; i<6; i++) {
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame,4);
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i==0) {
                    Tile plant = new Tile(TileType.PLANT);
                    ArrayList<Tile> TilePlant = new ArrayList<>();
                    TilePlant.add(plant);
                    bookshelf.insertTiles(TilePlant, j);

                }else if(i==1) {
                    Tile frame = new Tile(TileType.FRAME);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, j);

                }else if(i==2) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);

                }else {
                    Tile book = new Tile(TileType.BOOK);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, j);
                }
            }
        }

        assertTrue(Card.check(bookshelf));
    }

}