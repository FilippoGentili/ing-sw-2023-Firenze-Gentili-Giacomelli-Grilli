package it.polimi.ingsw;


import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Bag {

    private static int numOfTiles;
    private ArrayList<Tile> remainingTiles;

    public Bag(){
        numOfTiles=132;
        for(int i=0; i<numOfTiles;i++){
            if(i<22){
                remainingTiles.add(new Tile(TileType.CAT, Location.BAG));
            }else if(i>=22 && i<44){
                remainingTiles.add(new Tile(TileType.BOOK, Location.BAG));
            }else if(i>=44 && i<66){
                remainingTiles.add(new Tile(TileType.GAME, Location.BAG));
            }else if(i>=66 && i<88){
                remainingTiles.add(new Tile(TileType.FRAME, Location.BAG));
            }else if(i>=88 && i<110){
                remainingTiles.add(new Tile(TileType.TROPHIE, Location.BAG));
            }else if(i>=110 && i<132){
                remainingTiles.add(new Tile(TileType.BOOK, Location.BAG));
            }
        }
    }

    public ArrayList<Tile> extract(int numStartTile){

        ArrayList<Tile> chosen = new ArrayList<Tile>();

        Collections.shuffle(remainingTiles);

        for(int i=0; i<numStartTile-LivingRoom.getNumberOfTiles(); i++){
            chosen.add(remainingTiles.get(i));
        }

        return chosen;
    }

}
