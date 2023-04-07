package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static java.util.Objects.isNull;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard11Test {
    @Test
    void AllBookshelfHasOneTileType(){
        CommonGoalCard Card = new CommonGoalCard11();
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
    void BookshelfStillEmpty(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void JustFirstLineFull(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();
        int i;

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        ArrayList<Tile> TileCat= new ArrayList<>();

        for(i=0; i<5; i++)
            bookshelf.insertTiles(TileCat, i);

        assertFalse(Card.check(bookshelf));

    }

    @Test
    void TwoRowsEquals(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();
        int i,j;

        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);

        ArrayList<Tile> TileGame = new ArrayList<>();

        TileGame.add(game);

        for(i=0; i<6; i++){
            for(j=0; j<5; j++){
                if(i==0 || i==1)
                    bookshelf.insertTiles(TileGame,j);
            }
        }

        assertTrue(Card.check(bookshelf));

    }
    @Test
    void EachColumnIsDifferent(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();
        int i,j;

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

        for(i=0; i<6; i++) {
            for (j = 0; j < 5; j++){
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

}