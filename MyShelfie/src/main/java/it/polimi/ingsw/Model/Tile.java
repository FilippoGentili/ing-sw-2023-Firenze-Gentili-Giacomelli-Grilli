package it.polimi.ingsw.Model;

import java.io.Serializable;

public class Tile implements Serializable {

    private static final long serialVersionUID = -4648973443050270233L;


    private final TileType type;

    public Tile(TileType tile){
        this.type = tile;
    }

    public TileType getTileType(){
        return type;
    }

}
