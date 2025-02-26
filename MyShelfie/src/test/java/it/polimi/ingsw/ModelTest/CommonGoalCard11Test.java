package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard11Test {
    @Test
    void AllBookshelfHasOneTileType(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++) {
            for(int j=0; j < 5; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat= new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

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

        for(int i=0; i<5; i++) {
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat= new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, i);
        }

        assertFalse(Card.check(bookshelf));

    }

    @Test
    void TwoRowsEquals(){
        CommonGoalCard Card = new CommonGoalCard11();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(i==0 || i==1) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                }
            }
        }

        assertTrue(Card.check(bookshelf));

    }
    @Test
    void EachColumnIsDifferent(){
        CommonGoalCard Card = new CommonGoalCard11();
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

}