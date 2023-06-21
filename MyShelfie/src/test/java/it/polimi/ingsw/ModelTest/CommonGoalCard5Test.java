package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard5Test {

    @Test
    void FullBookshelfWithOneTile(){
        CommonGoalCard Card = new CommonGoalCard5();
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
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void FourCorrectColumn(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<4; i++){
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat, 0);
        }

        for(int i=0; i<4; i++){
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, 1);
        }

        for(int i=0; i<4; i++){
            Tile frame = new Tile(TileType.FRAME);
            ArrayList<Tile> TileFrame = new ArrayList<>();
            TileFrame.add(frame);
            bookshelf.insertTiles(TileFrame, 2);
        }

        for(int i=0; i<4; i++){
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame, 3);
        }

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void FourGroupsShapeOfL(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

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

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void ThreeSquaresOneColumn(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

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

        assertTrue(Card.check(bookshelf));

    }

    @Test
    void ThreeLinesWithThreeTiles(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<3; i++){
            Tile cat = new Tile(TileType.CAT);
            ArrayList<Tile> TileCat = new ArrayList<>();
            TileCat.add(cat);
            bookshelf.insertTiles(TileCat,i);
        }

        for(int i=0; i<3; i++){
            Tile book = new Tile(TileType.BOOK);
            ArrayList<Tile> TileBook = new ArrayList<>();
            TileBook.add(book);
            bookshelf.insertTiles(TileBook, i);
        }

        for(int i=0; i<3; i++){
            Tile frame = new Tile(TileType.FRAME);
            ArrayList<Tile> TileFrame = new ArrayList<>();
            TileFrame.add(frame);
            bookshelf.insertTiles(TileFrame, 2);
        }

        for(int i=0; i<3; i++){
            Tile game = new Tile(TileType.GAME);
            ArrayList<Tile> TileGame = new ArrayList<>();
            TileGame.add(game);
            bookshelf.insertTiles(TileGame, 3);
        }

        assertFalse(Card.check(bookshelf));

    }

    @Test
    void genericTest(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                switch (j){
                    case 0:
                        Tile cat = new Tile(TileType.CAT);
                        ArrayList<Tile> TileCat = new ArrayList<>();
                        TileCat.add(cat);
                        bookshelf.insertTiles(TileCat,j);
                        break;
                    case 1:
                        Tile book = new Tile(TileType.BOOK);
                        ArrayList<Tile> TileBook = new ArrayList<>();
                        TileBook.add(book);
                        bookshelf.insertTiles(TileBook, j);
                        break;
                    case 2:
                        Tile frame = new Tile(TileType.FRAME);
                        ArrayList<Tile> TileFrame = new ArrayList<>();
                        TileFrame.add(frame);
                        bookshelf.insertTiles(TileFrame, j);
                        break;
                    case 3:
                        Tile game = new Tile(TileType.GAME);
                        ArrayList<Tile> TileGame = new ArrayList<>();
                        TileGame.add(game);
                        bookshelf.insertTiles(TileGame, j);
                        break;
                }
            }
        }

        boolean[][] checkTile = new boolean[6][5];

        for(int row=0; row<6; row++)
            for(int col=0; col<5; col++)
                checkTile[row][col]=false;

        int count = Card.FindAdjacentTiles(bookshelf.getTile(5,4),bookshelf,checkTile,4,0);

        assertTrue(Card.check(bookshelf));
    }

    @Test
    void genericTest2(){
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for(int j=0; j<4; j++){

            ArrayList<Tile> first = new ArrayList<>();
            first.add(new Tile(TileType.BOOK));
            first.add(new Tile(TileType.GAME));
            first.add(new Tile(TileType.PLANT));
            first.add(new Tile(TileType.BOOK));
            bookshelf.insertTiles(first,j);

        }


        assertTrue(Card.check(bookshelf));
    }

    @Test
    void genericTest3() {
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for (int i = 0; i < 6; i++) {
            for(int j=0; j<5; j++){
                switch (i){
                    case 0:
                        if(j==0){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==1){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 1:
                        if(j==3){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 2:
                        if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.CAT));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==3 || j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 3:
                        if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.CAT));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==3 || j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 4:
                        if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.PLANT));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 5:
                        if(j==0){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==1 || j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==3){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.CAT));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;

                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }

    @Test
    void genericTest4() {
        CommonGoalCard Card = new CommonGoalCard5();
        Bookshelf bookshelf = new Bookshelf();

        for (int i = 0; i < 6; i++) {
            for(int j=0; j<5; j++){
                switch (i){
                    case 0:
                        if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==3) {
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList, j);
                        }else if(j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList, j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 1:
                        if(j==0){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList,j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 2:
                        if(j==4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==0 || j==1) {
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList, j);
                        }else if(j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList, j);
                        }else{
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;
                    case 3:
                        if(j!=4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.TROPHIE));
                            bookshelf.insertTiles(arrayList, j);
                        }
                        break;
                    case 4:
                        if(j==0 || j==3){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.FRAME));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==1){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.PLANT));
                            bookshelf.insertTiles(arrayList,j);
                        }else if(j==2){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.BOOK));
                            bookshelf.insertTiles(arrayList, j);
                        }
                        break;
                    case 5:
                        if(j!= 3 && j!=4){
                            ArrayList<Tile> arrayList = new ArrayList<>();
                            arrayList.add(new Tile(TileType.GAME));
                            bookshelf.insertTiles(arrayList,j);
                        }
                        break;

                }
            }
        }

        assertFalse(Card.check(bookshelf));
    }


}