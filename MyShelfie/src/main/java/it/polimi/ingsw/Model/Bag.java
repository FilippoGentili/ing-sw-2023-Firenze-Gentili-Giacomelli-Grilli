package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.*;


/**
 * Bag class that contains the 132 tiles
 * @author pheelaw
 */
public class Bag implements Serializable {

    private static final long serialVersionUID = 4089040294542656250L;
    private static int numOfTiles=132;
    private static ArrayList<Tile> remainingTiles;

    /**
     * Bag constructor
     * creates 132 tiles, 22 for each type
     */
    public Bag(){

        remainingTiles = new ArrayList<Tile>();

        for(TileType type: TileType.values() ){
            for(int i=0; i<22; i++)
                remainingTiles.add(new Tile(type));
        }
    }


    /**
     *
     * @param numStartTile number of tiles to fulfill the board, based on the number of players
     * @return an array list of the tiles chosen from the bag
     */

    public ArrayList<Tile> extract(int numStartTile) throws RemoteException {

        ArrayList<Tile> chosen = new ArrayList<Tile>();
        LivingRoom living = LivingRoom.getInstance();

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
