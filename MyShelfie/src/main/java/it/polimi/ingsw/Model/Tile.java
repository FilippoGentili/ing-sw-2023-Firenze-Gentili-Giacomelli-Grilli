package it.polimi.ingsw.Model;

import java.io.Serializable;

public class Tile implements Serializable {

    private static final long serialVersionUID = -4648973443050270233L;
    private int col;
    private int row;
    private Location location;
    private final TileType type;

    public Tile(TileType tile){
        this.type = tile;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    /*public Location getLocation(){
        return location;
    }*/

    public TileType getTileType(){
        return type;
    }

    public void setCol(int c){ this.col = c; }

    public void setRow(int r){
        this.row = r;
    }

    /*public void setLocation(Location loc){
        this.location = loc;
    }*/

}
