package it.polimi.ingsw;


import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Bag {

    private static final int numOfTiles=132;
    private static ArrayList<Tile> remainingTiles;

    public Bag(){

        remainingTiles = new ArrayList<Tile>();

        for(int i=0; i<numOfTiles; i++){
            if(i<22){
                remainingTiles.add(new Tile(TileType.CAT, Location.BAG));
            }
            if(i>=22 && i<44){
                remainingTiles.add(new Tile(TileType.BOOK, Location.BAG));
            }
            if(i>=44 && i<66){
                remainingTiles.add(new Tile(TileType.GAME, Location.BAG));
            }
            if(i>=66 && i<88){
                remainingTiles.add(new Tile(TileType.FRAME, Location.BAG));
            }
            if(i>=88 && i<110){
                remainingTiles.add(new Tile(TileType.TROPHIE, Location.BAG));
            }
            if(i>=110){
                remainingTiles.add(new Tile(TileType.BOOK, Location.BAG));
            }
        }
    }

    public ArrayList<Tile> extract(int numStartTile){

        ArrayList<Tile> chosen = new ArrayList<Tile>();
        LivingRoom living = LivingRoom.getInstance();

        Collections.shuffle(remainingTiles);

        for(int i=0; i<numStartTile- living.getNumberOfTiles(); i++){
            chosen.add(remainingTiles.get(i));
        }

        int i=0;
        for(Tile tile:chosen){
            System.out.println(chosen.get(i).getTileType());
            i++;
        }

        return chosen;
    }

}
