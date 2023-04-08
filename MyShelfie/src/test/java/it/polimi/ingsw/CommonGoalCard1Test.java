package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard1Test {
    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard1();
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
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void ThereAreCouplesOfAllTiles(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile trophie = new Tile(TileType.TROPHIE, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
        Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);
        Tile frame = new Tile(TileType.FRAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();
        ArrayList<Tile> TilePlant = new ArrayList<>();
        ArrayList<Tile> TileFrame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileTrophie.add(trophie);
        TileGame.add(game);
        TilePlant.add(plant);
        TileFrame.add(frame);

        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                if(i==0)
                    bookshelf.insertTiles(TileCat,i);
                if(i==1)
                    bookshelf.insertTiles(TileBook,i);
                if(i==2)
                    bookshelf.insertTiles(TileFrame,i);
                if(i==3)
                    bookshelf.insertTiles(TileGame,i);
                if(i==4)
                    bookshelf.insertTiles(TilePlant,i);
            }
        }

        bookshelf.insertTiles(TileCat,0);
        bookshelf.insertTiles(TileCat,0);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void ThreeHorizzAndThreeVertCouples(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);

        for(int i=0; i<6; i++)
            bookshelf.insertTiles(TileBook, 0);

        for(int i=1; i<5; i++)
            bookshelf.insertTiles(TileCat,i);

        bookshelf.insertTiles(TileCat,4);
        bookshelf.insertTiles(TileCat,3);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void AlternateTiles(){
        CommonGoalCard Card = new CommonGoalCard1();
        Bookshelf bookshelf = new Bookshelf();

        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile trophie = new Tile(TileType.TROPHIE, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
        Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);
        Tile frame = new Tile(TileType.FRAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();
        ArrayList<Tile> TilePlant = new ArrayList<>();
        ArrayList<Tile> TileFrame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileTrophie.add(trophie);
        TileGame.add(game);
        TilePlant.add(plant);
        TileFrame.add(frame);

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                if(i==0){
                    if(j%2==0)
                        bookshelf.insertTiles(TileCat,j);
                    else
                        bookshelf.insertTiles(TileBook,j);
                }
                if(i==1){
                    if(j%2!=0)
                        bookshelf.insertTiles(TileCat,j);
                    else
                        bookshelf.insertTiles(TileBook,j);
                }
                if(i==2){
                    if(j%2==0)
                        bookshelf.insertTiles(TileTrophie,j);
                    else
                        bookshelf.insertTiles(TileFrame,j);
                }
                if(i==3){
                    if(j%2!=0)
                        bookshelf.insertTiles(TileTrophie,j);
                    else
                        bookshelf.insertTiles(TileFrame,j);
                }
                if(i==4){
                    if(i%2==0)
                        bookshelf.insertTiles(TilePlant,j);
                    else
                        bookshelf.insertTiles(TileGame,j);
                }
                if(i==5){
                    if(i%2!=0)
                        bookshelf.insertTiles(TilePlant,j);
                    else
                        bookshelf.insertTiles(TileGame,j);
                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }

}