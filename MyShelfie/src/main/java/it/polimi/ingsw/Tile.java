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
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public Location getLocation(){
        return this.location;
    }

    public TileType getTileType(){
        return this.type;
    }

}
