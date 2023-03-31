package it.polimi.ingsw;

public class Tile {

    private int col;
    private int row;
    private Location location;
    private TileType type;

    public Tile(TileType tile, Location loc){
        this.type = tile;
        this.location = loc;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public Location getLocation(){
        return location;
    }

    public TileType getTileType(){
        return type;
    }

}
