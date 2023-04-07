package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard2Test {

    @Test
    void FullBookshelfAllEquals(){
        CommonGoalCard Card = new CommonGoalCard2();
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
        CommonGoalCard Card = new CommonGoalCard2();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void FullBokkshelfOneDiagonalHasEqualsTiles(){
        CommonGoalCard Card = new CommonGoalCard2();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        TileCat.add(cat);
        TileBook.add(book);

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(i==j)
                    bookshelf.insertTiles(TileCat,j);
                else
                    bookshelf.insertTiles(TileBook,j);
            }
        }

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void AllDiagonalsHasDifferentTiles(){
        CommonGoalCard Card = new CommonGoalCard2();
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

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(j==0)
                    bookshelf.insertTiles(TileCat,j);
                if(j==1)
                    bookshelf.insertTiles(TileBook,j);
                if(j==2)
                    bookshelf.insertTiles(TileTrophie,j);
                if(j==3)
                    bookshelf.insertTiles(TileGame,j);
                if(j==4)
                    bookshelf.insertTiles(TilePlant,j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void TwoDiagonalsAreEquals(){
        CommonGoalCard Card = new CommonGoalCard2();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile trophie = new Tile(TileType.TROPHIE, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileTrophie = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileTrophie.add(trophie);

        for(int i=0; i<6; i++) {
            for (int j=0; j<5; j++) {
                if(i==j)
                    bookshelf.insertTiles(TileCat,j);
                else if(i==j+1)
                    bookshelf.insertTiles(TileBook,j);
                else
                    bookshelf.insertTiles(TileTrophie,j);
            }
        }

        assertTrue(Card.check(bookshelf));
    }

}