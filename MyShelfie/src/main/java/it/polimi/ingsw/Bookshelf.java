package it.polimi.ingsw;

import java.util.ArrayList;

public class Bookshelf {
    private Tile[][] shelf;
    private final int rows=6;
    private final int columns=5;

    public boolean isEmpty(int i, int j){
        if(shelf[i][j] != null)
            return false;
        else
            return true;
    }

    public Tile[] selectOrder(ArrayList<Tile> chosen){
        int app;

        for(Tile tile:chosen){
            System.out.println(tile.getTileType());
        }

    }

    public Tile getTile(int i, int j){
        return shelf[i][j];
    }

    public int countPoints(){
        int curr=0;
        int numAd;


    }

    public boolean fullBookshelf(){
        for(int j=0; j<columns; j++){
            if(shelf[0][j] == null)
                return false;
        }

        return true;    // -> chiama endgame trigger
    }
}
