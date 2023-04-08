package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard7Test {

    @Test
    void FullBookshelfAllEquals(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);

        for(int i=0; i<6; i++)
            for(int j=0; j<5; j++)
                bookshelf.insertTiles(TileCat,j);

        for(int i=0; i<6; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(bookshelf.getTile(i,j).getTileType() + " ");
            }
            System.out.println();
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

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);

        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileCat,1);
        bookshelf.insertTiles(TileCat,1);

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void TwoEqualsSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);

        for(int i=0; i<4; i++)
            for(int j=0; j<2; j++)
            bookshelf.insertTiles(TileCat,i);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void TwoDifferentSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK,Location.BOOKSHELF);
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);
        TileBook.add(book);

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                bookshelf.insertTiles(TileCat,j);

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                bookshelf.insertTiles(TileBook,j);

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void FullBookshelfButJustTwoEqualsSquares(){
        CommonGoalCard Card = new CommonGoalCard7();
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

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                bookshelf.insertTiles(TileCat,j);

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                bookshelf.insertTiles(TileBook,j+2);

        for(int i=0; i<6; i++)
            bookshelf.insertTiles(TileGame,4);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i==0)
                    bookshelf.insertTiles(TilePlant,j);
                if(i==1)
                    bookshelf.insertTiles(TileFrame,j);
                if(i==2)
                    bookshelf.insertTiles(TileCat,j);
                if(i==3)
                    bookshelf.insertTiles(TileBook,j);
            }
        }

        assertTrue(Card.check(bookshelf));
    }

}