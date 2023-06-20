package it.polimi.ingsw;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCardTest {

    @Test
    void test1(){
        CommonGoalCard card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        for (int j = 0; j < 5; j++) {
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, j);
        }

        int count = card.FindAdjacentTiles(bookshelf.getTile(5,2),bookshelf,checkTile,4,0);

        assertEquals(4,count);
        assertEquals(false,checkTile[5][0]);
        assertTrue(checkTile[5][1]);

        for(int i=0; i<5;i++){
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 0);
        }

        int count1 = card.FindAdjacentTiles(bookshelf.getTile(2,0),bookshelf,checkTile,4,0);

        assertEquals(4,count1);
    }

    @Test
    void Test2(){
        CommonGoalCard card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                Tile cat = new Tile(TileType.CAT);
                ArrayList<Tile> TileCat = new ArrayList<>();
                TileCat.add(cat);
                bookshelf.insertTiles(TileCat, j);
            }
        }

        int count = card.FindAdjacentTiles(bookshelf.getTile(5,0),bookshelf,checkTile,4,0);

        assertEquals(4,count);

    }

    @Test
    void FourColumnTest(){
        CommonGoalCard card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        for(int i=0; i<4; i++){
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat,0);
        }

        int count = card.FindAdjacentTiles(bookshelf.getTile(2,0),bookshelf,checkTile,4,0);

        assertEquals(4,count);

        for(int i=0; i<4; i++){
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook,1);
        }

        int count1 = card.FindAdjacentTiles(bookshelf.getTile(5,1),bookshelf,checkTile,4,0);

        assertEquals(4,count1);

        for(int i=0; i<4; i++){
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame,3);
        }

        int count2 = card.FindAdjacentTiles(bookshelf.getTile(5,3),bookshelf,checkTile,4,0);

        assertEquals(4,count2);

    }

    @Test
    void test3(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;


        for(int i=0; i<3; i++){
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 0);
        }
        Tile cat = new Tile(TileType.CAT);
        ArrayList<Tile> TileCat = new ArrayList<>();
        TileCat.add(cat);
        bookshelf.insertTiles(TileCat, 1);


        for(int i=0; i<3; i++){
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 1);
        }
        Tile book = new Tile(TileType.BOOK);
        ArrayList<Tile> TileBook = new ArrayList<>();
        TileBook.add(book);
        bookshelf.insertTiles(TileBook, 0);


        for(int i=0; i<3; i++){
            Tile frame = new Tile(TileType.FRAME);
            ArrayList<Tile> TileFrame = new ArrayList<>();
            TileFrame.add(frame);
            bookshelf.insertTiles(TileFrame, 2);
        }
        Tile frame = new Tile(TileType.FRAME);
        ArrayList<Tile> TileFrame = new ArrayList<>();
        TileFrame.add(frame);
        bookshelf.insertTiles(TileFrame, 3);


        for(int i=0; i<3; i++){
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame, 3);
        }
        Tile game = new Tile(TileType.GAME);
        ArrayList<Tile> TileGame = new ArrayList<>();
        TileGame.add(game);
        bookshelf.insertTiles(TileGame, 2);

        int count0 = Card.FindAdjacentTiles(bookshelf.getTile(3,0),bookshelf,checkTile,4,0);
        int count1 = Card.FindAdjacentTiles(bookshelf.getTile(2,0),bookshelf,checkTile,4,0);
        int count2 = Card.FindAdjacentTiles(bookshelf.getTile(3,2),bookshelf,checkTile,4,0);
        int count3 = Card.FindAdjacentTiles(bookshelf.getTile(2,2),bookshelf,checkTile,4,0);

        assertEquals(4,count0);
        assertEquals(4,count1);
        assertEquals(4,count2);
        assertEquals(4,count3);
    }

    @Test
    void Test4(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        for(int i=0; i<4; i++){
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 4);
        }

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                Tile book = new Tile(TileType.BOOK);
                ArrayList<Tile> TileBook = new ArrayList<>();
                TileBook.add(book);
                bookshelf.insertTiles(TileBook, j);
            }
        }

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                Tile frame = new Tile(TileType.FRAME);
                ArrayList<Tile> TileFrame = new ArrayList<>();
                TileFrame.add(frame);
                bookshelf.insertTiles(TileFrame, j);
            }
        }

        for(int i=2; i<4; i++){
            for(int j=2; j<4; j++){
                Tile game = new Tile(TileType.GAME);
                ArrayList<Tile> TileGame = new ArrayList<>();
                TileGame.add(game);
                bookshelf.insertTiles(TileGame, j);
            }
        }

        int count0 = Card.FindAdjacentTiles(bookshelf.getTile(4,0),bookshelf,checkTile,4,0);
        int count1 = Card.FindAdjacentTiles(bookshelf.getTile(2,0),bookshelf,checkTile,4,0);
        int count2 = Card.FindAdjacentTiles(bookshelf.getTile(4,2),bookshelf,checkTile,4,0);
        int count3 = Card.FindAdjacentTiles(bookshelf.getTile(2,4),bookshelf,checkTile,4,0);

        assertEquals(4,count0);
        assertEquals(4,count1);
        assertEquals(4,count2);
        assertEquals(4,count3);


    }

    @Test
    void Test5(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                Tile frame = new Tile(TileType.FRAME);
                ArrayList<Tile> TileFrame = new ArrayList<>();
                TileFrame.add(frame);
                bookshelf.insertTiles(TileFrame, j);
            }
        }

        int count3 = Card.FindAdjacentTiles(bookshelf.getTile(2,0),bookshelf,checkTile, 7,0);

        assertEquals(7,count3);
    }

    @Test
    void test6(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();
        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;


        Tile frame = new Tile(TileType.FRAME);
        ArrayList<Tile> TileFrame = new ArrayList<>();
        TileFrame.add(frame);
        bookshelf.insertTiles(TileFrame, 0);

        int count = Card.FindAdjacentTiles(bookshelf.getTile(5,0),bookshelf,checkTile,4,0);
        int count0 = Card.FindAdjacentTiles(bookshelf.getTile(0,0),bookshelf,checkTile,4,0);

        assertEquals(1,count);
        assertEquals(0,count0);
    }

}