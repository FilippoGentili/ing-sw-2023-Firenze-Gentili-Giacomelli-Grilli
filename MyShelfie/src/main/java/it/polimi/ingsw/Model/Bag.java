package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class Bag implements Serializable {

    private static final long serialVersionUID = 4089040294542656250L;
    private int numOfTiles=132;
    private Game game;
    private ArrayList<Tile> remainingTiles;

    /**
     * Bag constructor
     * creates 132 tiles, 22 for each type
     */
    public Bag(Game game){

        this.game = game;

        remainingTiles = new ArrayList<Tile>();

        for(TileType type: TileType.values() ){
            if(type != TileType.NULL){
                for(int i=0; i<22; i++)
                    remainingTiles.add(new Tile(type));
            }
        }
    }


    /**
     * Extracts the tiles from the bag and puts them in an arraylist, so they can be added to the living room
     * @param numStartTile number of tiles to fulfill the board, based on the number of players
     * @return an array list of the tiles chosen from the bag
     */

    public ArrayList<Tile> extract(int numStartTile) {

        ArrayList<Tile> chosen = new ArrayList<Tile>();
        LivingRoom living = game.getLivingRoom();

        Collections.shuffle(remainingTiles);

        int i=0;
        while(i< numStartTile-living.getNumberOfTiles() && numOfTiles>0){
            chosen.add(remainingTiles.get(0));
            remainingTiles.remove(0);
            numOfTiles--;
            i++;
        }

        return chosen;
    }

}
