package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard4Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard4();
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
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void AllColumnsAreDifferent(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
        Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);
        Tile frame = new Tile(TileType.FRAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();
        ArrayList<Tile> TilePlant = new ArrayList<>();
        ArrayList<Tile> TileFrame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileGame.add(game);
        TilePlant.add(plant);
        TileFrame.add(frame);

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(j==0)
                    bookshelf.insertTiles(TileCat,j);
                if(j==1)
                    bookshelf.insertTiles(TileBook,j);
                if(j==2)
                    bookshelf.insertTiles(TileFrame,j);
                if(j==3)
                    bookshelf.insertTiles(TileGame,j);
                if(j==4)
                    bookshelf.insertTiles(TilePlant,j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void JustOneRowIsFull(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileGame.add(game);

        for(int i=0; i<3; i++)
            bookshelf.insertTiles(TileGame,i);

        bookshelf.insertTiles(TileBook,3);
        bookshelf.insertTiles(TileCat,4);

        assertFalse(Card.check(bookshelf));

    }

    @Test
    void FourRowsAreFull(){
        CommonGoalCard Card = new CommonGoalCard4();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileGame.add(game);

        for(int i=0; i<3; i++)
            for(int j=0; j<4; j++)
                bookshelf.insertTiles(TileGame,i);

        for(int j=0; j<4; j++)
            bookshelf.insertTiles(TileBook,3);

        for(int j=0; j<4; j++)
            bookshelf.insertTiles(TileCat,4);

        assertTrue(Card.check(bookshelf));
    }

}