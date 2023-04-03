package it.polimi.ingsw;


import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Bag {

    private int numOfTiles;
    private ArrayList<Tile> remainingTiles;

    public ArrayList<Tile> extract(int numStartTile){

        ArrayList<Tile> chosen = new ArrayList<Tile>();

        Collections.shuffle(remainingTiles);

        for(int i=0; i<numStartTile-LivingRoom.getNumberOfTiles(); i++){
            chosen.set(i, remainingTiles.get(i));
        }

        return chosen;
    }

}
