package it.polimi.ingsw.Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class LivingRoom implements Serializable {

    @Serial
    private static final long serialVersionUID = 5403724841040315028L;
    private int numberOfTiles=0;
    private Tile[][] board;
    private boolean[][] valid;
    private final int rows = 9;
    private final int columns = 9;


    /**
     * Constructor of class livingRoom
     */
    public LivingRoom() {
        board = new Tile[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                setTile(new Tile(TileType.NULL), i, j);
            }
        }
        valid = new boolean[rows][columns];
    }

    /**
     * Sets a cell either true or false, to keep track of the cell to consider on the board
     * @param i row
     * @param j column
     * @param x value to be set
     */
    public void setValid(int i, int j, boolean x){
        valid[i][j]=x;
    }

    /**
     * Checks if a cell is either valid or not
     * @param i row
     * @param j column
     * @return true if it is valid, false if it is not valid
     */
    public boolean validCell(int i, int j){
        return valid[i][j];
    }

    /**
     * Sets a tile in the board
     * @param t tile to be set
     * @param i row index
     * @param j column index
     */
    public void setTile(Tile t, int i, int j){
        Tile tile = new Tile(t.getTileType());
        tile.setRow(i);
        tile.setCol(j);
        board[i][j] = tile;
    }

    /**
     * Sets a tile to TileType null
     * @param i row index
     * @param j column index
     */
    public void setNull(int i, int j){
        setTile(new Tile(TileType.NULL), i, j);
    }

    /**
     * Returns number of tiles present on the board
     * @return number of tiles on the board
     */
    public int getNumberOfTiles(){
        return numberOfTiles;
    }

    /**
     * Decrements number of tiles on the board
     */
    public void decrementNumberOfTiles(){
        numberOfTiles--;
    }

    /**
     * Returns a tile in position i, j
     * @param i row index
     * @param j column index
     * @return tile in the position i, j on the board
     */
    public Tile getTile(int i, int j){
        return board[i][j];
    }

    /**
     * Removes the tile of the specified position from the board, and return it
     * @param i row
     * @param j column
     * @return tile picked
     */
    public Tile pickTile(int i, int j){
        Tile app;

        if(valid[i][j] && getTile(i,j).getTileType()!= TileType.NULL){
            app = getTile(i, j);
            setTile(new Tile(TileType.NULL), i, j);
            numberOfTiles--;

            return app;
        }else throw new IllegalArgumentException("Coordinate errate");
    }

    /**
     * Inserts the tiles to fulfill the board
     * @param chosen arraylist of the tiles to insert
     */
    public void insertTiles(ArrayList<Tile> chosen){

        int x=0;

        while (x< chosen.size()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (valid[i][j] && getTile(i, j).getTileType() == TileType.NULL) {
                        setTile(chosen.get(0), i, j);
                        chosen.remove(0);
                        numberOfTiles++;
                    }
                }
            }
        }
    }


    /**
     * Checks if two tiles are adjacent
     * @param t1 first tile
     * @param t2 second tile
     * @return true if t1 and t2 are adjacent
     */
    public boolean isAdjacent(Tile t1, Tile t2){
        if((t1.getCol()==t2.getCol() && (t1.getRow()==t2.getRow()+1 || t1.getRow()==t2.getRow()-1)) ||
                (t1.getRow() == t2.getRow() && (t1.getCol()==t2.getCol()+1 || t1.getCol()==t2.getCol()-1)))
            return true;
        else return false;
    }

    /**
     * Checks if the selected tiles are valid, having a free side
     * @param chosen tiles that I want to pick from the board
     * @return true if the selected tiles can be picked up, false otherwise
     */
    public boolean checkValid(ArrayList<Tile> chosen){

        int num;
        int x, y;

        for(Tile curr : chosen){
            num=0;
            x= curr.getRow();
            y= curr.getCol();


            if(x >= 1)
                if(getTile(x-1, y).getTileType() != TileType.NULL)
                    num++;
            if(x <= 7)
                if(getTile(x+1, y).getTileType() != TileType.NULL)
                    num++;
            if(y >= 1)
                if(getTile(x, y-1).getTileType() != TileType.NULL)
                    num++;
            if(y <= 7)
                if(getTile(x, y+1).getTileType() != TileType.NULL)
                    num++;

            if(num==4)
                return false;
        }


        switch (chosen.size()){
            case 1:
                return true;
            case 2:
                if(isAdjacent(chosen.get(0), chosen.get(1)))
                    return true;
                break;
            case 3:
                if((isAdjacent(chosen.get(0), chosen.get(1)) && isAdjacent(chosen.get(1), chosen.get(2))) ||
                        (isAdjacent(chosen.get(0), chosen.get(2)) && isAdjacent(chosen.get(1), chosen.get(2))) ||
                        (isAdjacent(chosen.get(0), chosen.get(1)) && isAdjacent(chosen.get(0), chosen.get(2)))){
                    if((chosen.get(0).getRow() == chosen.get(1).getRow() && chosen.get(1).getRow() == chosen.get(2).getRow()) ||
                            (chosen.get(0).getCol() == chosen.get(1).getCol() && chosen.get(1).getCol() == chosen.get(2).getCol())){
                        return true;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("il numero di tessere selezionato è sbagliato");
        }
        return false;
    }

    /**
     * Checks if the living room is empty or not
     * @return true if the livingRoom is empty, false otherwise
     */
    public boolean checkEmptyLivingRoom(){
        for(int i=1; i<rows-1; i++){
            for(int j=1; j<columns-1; j++){
                if(validCell(i,j) && getTile(i,j).getTileType() != TileType.NULL){
                    if(getTile(i-1,j).getTileType()!=TileType.NULL || getTile(i+1,j).getTileType()!=TileType.NULL
                            || getTile(i,j-1).getTileType()!=TileType.NULL || getTile(i,j+1).getTileType()!=TileType.NULL){
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
