package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard1Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard1();
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
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void ThereAreCouplesOfAllTiles(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        Tile trophie = new Tile(TileType.TROPHIE);
        Tile trophie1 = new Tile(TileType.TROPHIE);

        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileTrophie1 = new ArrayList<>();

        TileTrophie.add(trophie);
        TileTrophie1.add(trophie1);

        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                if(i==0) {
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, i);
                }
                if(i==1) {
                    Tile book = new Tile(TileType.BOOK);
                    ArrayList<Tile> TileBook = new ArrayList<>();
                    TileBook.add(book);
                    bookshelf.insertTiles(TileBook, i);
                }
                if(i==2) {
                    Tile frame = new Tile(TileType.FRAME);
                    ArrayList<Tile> TileFrame = new ArrayList<>();
                    TileFrame.add(frame);
                    bookshelf.insertTiles(TileFrame, i);
                }
                if(i==3) {
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, i);
                }
                if(i==4) {
                    Tile plant = new Tile(TileType.PLANT);
                    ArrayList<Tile> TilePlant = new ArrayList<>();
                    TilePlant.add(plant);
                    bookshelf.insertTiles(TilePlant, i);
                }
            }
        }

        bookshelf.insertTiles(TileTrophie,0);
        bookshelf.insertTiles(TileTrophie1,0);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void ThreeHorizzAndThreeVertCouples(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        Tile trophie = new Tile(TileType.TROPHIE);
        Tile trophie1 = new Tile(TileType.TROPHIE);

        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileTrophie1 = new ArrayList<>();

        TileTrophie.add(trophie);
        TileTrophie1.add(trophie1);

        for(int i=0; i<6; i++) {
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 0);
        }

        for(int i=1; i<5; i++) {
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, i);
        }

        bookshelf.insertTiles(TileTrophie,4);
        bookshelf.insertTiles(TileTrophie1,3);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void AlternateTiles(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(i==0){
                    if(j%2==0) {
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
                if(i==1){
                    if(j%2!=0) {
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
                if(i==2){
                    if(j%2==0) {
                        Tile trophie = new Tile(TileType.TROPHIE);
                        ArrayList<Tile> TileTrophie = new ArrayList<>();
                        TileTrophie.add(trophie);
                        bookshelf.insertTiles(TileTrophie, j);
                    }else {
                        Tile frame = new Tile(TileType.FRAME);
                        ArrayList<Tile> TileFrame = new ArrayList<>();
                        TileFrame.add(frame);
                        bookshelf.insertTiles(TileFrame, j);
                    }
                }
                if(i==3){
                    if(j%2!=0) {
                        Tile trophie = new Tile(TileType.TROPHIE);
                        ArrayList<Tile> TileTrophie = new ArrayList<>();
                        TileTrophie.add(trophie);
                        bookshelf.insertTiles(TileTrophie, j);
                    }else {
                        Tile frame = new Tile(TileType.FRAME);
                        ArrayList<Tile> TileFrame = new ArrayList<>();
                        TileFrame.add(frame);
                        bookshelf.insertTiles(TileFrame, j);
                    }
                }
                if(i==4){
                    if(i%2==0) {
                        Tile plant = new Tile(TileType.PLANT);
                        ArrayList<Tile> TilePlant = new ArrayList<>();
                        TilePlant.add(plant);
                        bookshelf.insertTiles(TilePlant, j);
                    }else {
                        Tile game = new Tile(TileType.GAME);
                        ArrayList<Tile> TileGame = new ArrayList<>();
                        TileGame.add(game);
                        bookshelf.insertTiles(TileGame, j);
                    }
                }
                if(i==5){
                    if(i%2!=0) {
                        Tile plant = new Tile(TileType.PLANT);
                        ArrayList<Tile> TilePlant = new ArrayList<>();
                        TilePlant.add(plant);
                        bookshelf.insertTiles(TilePlant, j);
                    }else {
                        Tile game = new Tile(TileType.GAME);
                        ArrayList<Tile> TileGame = new ArrayList<>();
                        TileGame.add(game);
                        bookshelf.insertTiles(TileGame, j);
                    }
                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void fiveCouples(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<2; i++){
            for(int j=0; j<5; j++){
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void simpleTest(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<2; i++){
            for(int j=0; j<5; j++){
                if(j%2==0){
                    Tile cat = new Tile(TileType.CAT);
                    ArrayList<Tile> TileCat = new ArrayList<>();
                    TileCat.add(cat);
                    bookshelf.insertTiles(TileCat, j);
                }else{
                    Tile game = new Tile(TileType.GAME);
                    ArrayList<Tile> TileGame = new ArrayList<>();
                    TileGame.add(game);
                    bookshelf.insertTiles(TileGame, j);
                }
            }
        }

        Tile cat = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);
        bookshelf.insertTiles(TileCat, 0);

        Tile cat1 = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        TileCat1.add(cat1);
        bookshelf.insertTiles(TileCat1, 1);

        assertTrue(Card.check(bookshelf));
    }

}