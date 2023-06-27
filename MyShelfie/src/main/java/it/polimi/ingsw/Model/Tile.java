package it.polimi.ingsw.Model;

import java.io.Serializable;

public class Tile implements Serializable {

    private static final long serialVersionUID = -4648973443050270233L;
    private int row;
    private int col;
    private final TileType type;

    /**
     * Constructor of Tile
     * @param tile type of the tile
     */
    public Tile(TileType tile){
        this.type = tile;
    }

    /**
     * Gets type of tile
     * @return type of chosen tile
     */
    public TileType getTileType(){
        return type;
    }

    /**
     * Gets row of the tile
     * @return row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets column of the tile
     * @return column index
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets column of the tile
     * @param col column index
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Sets row of the tile
     * @param row row index
     */
    public void setRow(int row) {
        this.row = row;
    }
}
