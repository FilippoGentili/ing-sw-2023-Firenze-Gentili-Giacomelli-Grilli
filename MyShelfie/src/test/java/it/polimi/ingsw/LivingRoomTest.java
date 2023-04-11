package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LivingRoomTest {

    @Test
    void getNumTiles0(){
        LivingRoom living = LivingRoom.getInstance();

        assertEquals(0, living.getNumberOfTiles());
    }

    @Test
    void getNumTiles45(){
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
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

        assertEquals(45, living.getNumberOfTiles());
    }

    @Test
    void getNumTiles37(){
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
        ArrayList<Tile> chosen = bag.extract(37);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==0 && j==3) ||
                        (i==1 && (j==3 || j==4)) ||
                        (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==3 && j!=0 && j!=1) ||
                        (i==4 && j!=0 && j!=8) ||
                        (i==5 && j!=7 && j!=8) ||
                        (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                        (i==7 && (j==4 || j==5)) ||
                        (i==8 && j==5))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }
        living.insertTiles(chosen);

        assertEquals(37, living.getNumberOfTiles());
    }

    @Test
    void getNumTiles29(){
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
        ArrayList<Tile> chosen = bag.extract(29);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((i==1 && (j==3 || j==4)) ||
                        (i==2 && (j==3 || j==4 || j==5)) ||
                        (i==3 && j!=0 && j!=1 && j!=8) ||
                        (i==4 && j!=0 && j!=8) ||
                        (i==5 && j!=0 && j!=7 && j!=8) ||
                        (i==6 && (j==3 || j==4 || j==5)) ||
                        (i==7 && (j==4 || j==5)))
                    living.setValid(i, j, true);
                else living.setValid(i, j, false);
            }
        }
        living.insertTiles(chosen);

        assertEquals(29, living.getNumberOfTiles());
    }

    @Test
    void getTileTest(){
        LivingRoom living = LivingRoom.getInstance();
        Tile t1 = new Tile(TileType.CAT, Location.LIVING_ROOM);
        living.setTile(t1, 4, 0);

        assertSame(living.getTile(4, 0), t1);
        assertEquals(living.getTile(4, 0).getLocation(), Location.LIVING_ROOM);
    }

    @Test
    void checkAdjacentVertical(){
        LivingRoom living = LivingRoom.getInstance();
        Tile t1 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);
        Tile t2 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);

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
        LivingRoom living = LivingRoom.getInstance();
        Tile t1 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);
        Tile t2 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);

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
        LivingRoom living = LivingRoom.getInstance();
        Tile t1 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);
        Tile t2 = new Tile(TileType.TROPHIE, Location.LIVING_ROOM);

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
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
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
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
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
        System.out.println(living.getTile(4, 4).getTileType());
        System.out.println(living.getTile(4, 5).getTileType());
        System.out.println(living.getTile(3, 4).getTileType());
        System.out.println(living.getTile(3, 5).getTileType());

        check.add(living.getTile(4,4));

        assertFalse(living.checkValid(check));
    }

    @Test
    void checkValidTest2(){
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
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
    void insertTileTest(){
        LivingRoom living = LivingRoom.getInstance();
        Bag bag = new Bag();
        ArrayList<Tile> chosen = bag.extract(45);

        living.insertTiles(chosen);

        int curr=0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(living.getTile(i,j) != null)
                    assertSame(living.getTile(i,j), chosen.get(curr));
                curr++;
            }
        }
    }


}