package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard3Test {
    @Test
    void FullBookshelf(){
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
    void AllCornersAreDifferent(){
        CommonGoalCard Card = new CommonGoalCard3();
        int i,j;
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile trophie = new Tile(TileType.TROPHIE, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
        Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();
        ArrayList<Tile> TilePlant = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileTrophie.add(trophie);
        TileGame.add(game);
        TilePlant.add(plant);

        for(i=0;i<6;i++){
            for(j=0;j<5;j++){
                if(i==0 && j==0)
                    bookshelf.insertTiles(TileCat,j);
                else if(i==0 && j==4)
                    bookshelf.insertTiles(TileBook,j);
                else if(i==5 && j==0)
                    bookshelf.insertTiles(TileGame,j);
                else if(i==5 && j==4)
                    bookshelf.insertTiles(TilePlant,j);
                else
                    bookshelf.insertTiles(TileTrophie,j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void JustTwoCornersAreEquals(){
        CommonGoalCard Card = new CommonGoalCard3();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);

        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileBook,4);

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void TwoEqualsColumns(){
        CommonGoalCard Card = new CommonGoalCard3();
        Bookshelf bookshelf = new Bookshelf();

        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);

        ArrayList<Tile> TileBook = new ArrayList<>();

        TileBook.add(book);

        for(int i=0; i<6; i++)
            bookshelf.insertTiles(TileBook,0);
        for(int i=0; i<6; i++)
            bookshelf.insertTiles(TileBook,4);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void EmptyBookshelf(){
        CommonGoalCard Card = new CommonGoalCard3();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

}