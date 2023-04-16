package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard6Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard6();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++) {
            for (int j = 0; j < 5; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void EmptyBookshelf(){
        CommonGoalCard Card = new CommonGoalCard6();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void AllColumnsHaveAllTiles(){
        CommonGoalCard Card = new CommonGoalCard6();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(i==0) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);

                }else if(i==1) {
                    Tile book = new Tile(TileType.BOOK);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, j);

                }else if(i==2) {
                    Tile frame = new Tile(TileType.FRAME);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, j);

                }else if(i==3) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);

                }else if(i==4){
                    Tile trophie = new Tile(TileType.TROPHIE);
                    ArrayList<Tile> TileTrophie = new ArrayList<>();
                    TileTrophie.add(trophie);
                    bookshelf.insertTiles(TileTrophie,j);

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
    void JustTwoColumnsHaveAllTiles(){
        CommonGoalCard Card = new CommonGoalCard6();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<2; j++){
                if(i==0) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);

                }else if(i==1) {
                    Tile book = new Tile(TileType.BOOK);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, j);

                }else if(i==2) {
                    Tile frame = new Tile(TileType.FRAME);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, j);

                }else if(i==3) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);

                }else if(i==4){
                    Tile trophie = new Tile(TileType.TROPHIE);
                    ArrayList<Tile> TileTrophie = new ArrayList<>();
                    TileTrophie.add(trophie);
                    bookshelf.insertTiles(TileTrophie,j);

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
    void JustTwoColumsHaveOneTile(){
        CommonGoalCard Card = new CommonGoalCard6();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++) {
            for (int j = 0; j < 2; j++) {
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

}