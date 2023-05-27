package it.polimi.ingsw.Model;

import java.io.Serializable;

public class Tile implements Serializable {

    private static final long serialVersionUID = -4648973443050270233L;
    private int row;
    private int col;
    private final TileType type;

    public Tile(TileType tile){
        this.type = tile;
    }

    public TileType getTileType(){
        return type;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
