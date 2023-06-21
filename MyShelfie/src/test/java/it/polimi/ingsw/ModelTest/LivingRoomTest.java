package it.polimi.ingsw.ModelTest;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Collections.addAll;
import static org.junit.jupiter.api.Assertions.*;

class LivingRoomTest {

    @Test
    void insertTest(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        ArrayList<Tile> chosen = game.getBag().extract(45);
        ArrayList<Tile> copy = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        for(int i=0; i<chosen.size(); i++){
            copy.add(chosen.get(i));
        }

        living.insertTiles(chosen);
        int curr=0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(living.validCell(i, j)) {
                    assertSame(living.getTile(i, j).getTileType(), copy.get(curr).getTileType());
                    curr++;
                }
            }
        }

        assertEquals(living.getNumberOfTiles(), 45);

    }

    @Test
    public void decrementTilesTest(){
        LivingRoom living = new LivingRoom();
        int num = living.getNumberOfTiles();
        Tile t = new Tile(TileType.BOOK);

        living.setValid(1,1,true);
        living.setTile(t,1,1);

        living.pickTile(1,1);

        assertEquals(num-1, living.getNumberOfTiles());
    }

    @Test
    void getTileTest(){
        LivingRoom living = new LivingRoom();
        Tile t1 = new Tile(TileType.CAT);
        living.setTile(t1, 4, 0);

        assertSame(living.getTile(4, 0).getTileType(), t1.getTileType());
    }

    @Test
    void checkAdjacentVertical(){
        LivingRoom living = new LivingRoom();
        Tile t1 = new Tile(TileType.TROPHIE);
        Tile t2 = new Tile(TileType.TROPHIE);

        living.setTile(t1, 0, 0);
        living.setTile(t2, 0, 1);

        t1.setRow(0);
        t1.setCol(0);
        t2.setRow(0);
        t2.setCol(1);

        assertTrue(living.isAdjacent(living.getTile(0,0), living.getTile(0,1)));
    }

    @Test
    void checkAdjacentHorizontal(){
        LivingRoom living = new LivingRoom();
        Tile t1 = new Tile(TileType.TROPHIE);
        Tile t2 = new Tile(TileType.TROPHIE);

        living.setTile(t1, 0, 0);
        living.setTile(t2, 1, 0);

        t1.setRow(0);
        t1.setCol(0);
        t2.setRow(1);
        t2.setCol(0);

        assertTrue(living.isAdjacent(living.getTile(0,0), living.getTile(1,0)));
    }

    @Test
    void checkAdjacentFalse(){
        LivingRoom living = new LivingRoom();
        Tile t1 = new Tile(TileType.TROPHIE);
        Tile t2 = new Tile(TileType.TROPHIE);

        living.setTile(t1, 0, 0);
        living.setTile(t2, 2, 0);

        t1.setRow(0);
        t1.setCol(0);
        t2.setRow(2);
        t2.setCol(0);

        assertFalse(living.isAdjacent(living.getTile(0,0), living.getTile(2,0)));
    }

    @Test
    void checkValidTest1True(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        check.add(living.getTile(4,0));

        assertTrue(living.checkValid(check));
    }

    @Test
    void checkValidTest1False(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        check.add(living.getTile(4,1));

        assertFalse(living.checkValid(check));
    }

    @Test
    void checkValidTest2True(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        check.add(living.getTile(4,0));
        check.add(living.getTile(5,0));

        assertTrue(living.checkValid(check));
    }

    @Test
    void checkValidTest2False(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        check.add(living.getTile(4,0));
        check.add(living.getTile(4,1));

        assertFalse(living.checkValid(check));
    }

    @Test
    void checkValidTest3True(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        living.setNull(8,4);
        living.setNull(8,5);

        check.add(living.getTile(7,3));
        check.add(living.getTile(7, 4));
        check.add(living.getTile(7, 5));

        assertTrue(living.checkValid(check));
    }

    @Test
    void checkValidTest3False(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);
        ArrayList<Tile> check = new ArrayList<Tile>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);


        check.add(living.getTile(4, 0));
        check.add(living.getTile(4, 1));
        check.add(living.getTile(8, 6));

        assertFalse(living.checkValid(check));
    }

    @Test
    void pickTilesTest(){
        Game game = new Game();
        LivingRoom living = game.getLivingRoom();
        Bag bag = game.getBag();
        ArrayList<Tile> chosen = bag.extract(45);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && (j==3 || j==4)) ||
                        (i==1 && (j==3 || j==4 || j==5)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0) ||
                        (i==4) ||
                        (i==5 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==3 || j==4 || j==5)) ||
                        (i==8 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }

        living.insertTiles(chosen);

        String prova = living.getTile(7, 3).getTileType().toString();

        Tile tile = living.pickTile(7, 3);

        assertSame(tile.getTileType().toString(), prova);
        assertEquals(TileType.NULL, living.getTile(7, 3).getTileType());

    }

    @Test
    public void EmptyLivingRoomCheck(){
        LivingRoom living = new LivingRoom();

        assertTrue(living.checkEmptyLivingRoom());
    }
    @Test
    public void NotEmptyLivingRoom(){
        LivingRoom living = new LivingRoom();
        ArrayList<Tile> chosen = new ArrayList<>();
        Tile t = new Tile(TileType.BOOK);
        Tile t2= new Tile(TileType.CAT);
        living.setValid(2,3,true);
        living.setValid(2,4,true);
        chosen.add(t);
        chosen.add(t2);
        living.insertTiles(chosen);

        assertFalse(living.checkEmptyLivingRoom());
    }

}