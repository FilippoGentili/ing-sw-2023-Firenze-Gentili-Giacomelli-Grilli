package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * Abstract class for CommonGoalCard
 * @author silvia
 */

public abstract class CommonGoalCard implements Serializable {

    private static final long serialVersionUID = -1396395765780504364L;
    private int value = 8;
    private int delta;

    /**
     * Gets ID of the card
     * @return id of each common goal card
     */
    public abstract int getId();


    /**
     * The method checks if the bookshelf respects the object required from the CommonGoalCard.
     * There is an override for each CommonGoalCard.
     * @param bookshelf
     * @return boolean
     */
    public abstract boolean check(Bookshelf bookshelf);

    /**
     * Gets value for points of the common goal card
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Updates the "points value" of the card. The decrease (Delta) depends on the number of players, When a player
     * reaches the Common Goal this method must be called.
     */
    public void updateValue(){
        this.value = this.value - this.delta;
    }

    /**
     * Sets the value of the decrease of the card value. It depends on the number of players.
     * @param NumPlayers of the current game
     */
    public void setDelta(int NumPlayers){
        if(NumPlayers == 2){
            this.delta = 4;
        }else{
            this.delta = 2;
        }
    }

    /**
     * Considering a particular bookshelf, the method finds how many tiles of the bookshelf are adjacent to
     * a particular "tile" with the same TileType. If this count reaches the value "limit", the count stops and a group
     * of a "limit" number of tiles is found. If this method is called more times, those tiles that were part of another
     * group are not considered thanks to the boolean matrix "checkTiles".
     * @param tile to be considered
     * @param bookshelf of the current player
     * @param checkTile matrix of boolean used to set tiles from other groups
     * @param limit number that sets the limit where to stop
     * @param counter a flag that counts how many tiles where counted through the recursive calls
     * @return int
     */
    public int FindAdjacentTiles(Tile tile, Bookshelf bookshelf, boolean[][] checkTile, int limit, int counter){
        int count=0;

        if(counter<limit && tile.getTileType() != TileType.NULL){

            if(!checkTile[tile.getRow()][tile.getCol()]){

                checkTile[tile.getRow()][tile.getCol()] = true;
                count++;

                if(tile.getCol()==0){
                    if (bookshelf.getTile(tile.getRow(),tile.getCol() + 1).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(),tile.getCol() + 1).getTileType())
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(),tile.getCol() + 1),bookshelf,checkTile,limit, counter+1);

                }else if(tile.getCol()==4){
                    if (bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile, limit, counter+1);

                }else{
                    if (bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType()) {
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile, limit, counter+1);
                        }

                    if(counter + count < limit){
                        if (bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType() != TileType.NULL)
                            if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile, limit, counter+count);

                    }
                }

                if(counter+count < limit){
                    if(tile.getRow()==0){
                        if(bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType() != TileType.NULL)
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile, limit, counter+count);

                    }else if(tile.getRow()==5){
                        if(bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType() != TileType.NULL)
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile, limit, counter+count);

                    }else{
                        if(bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType() != TileType.NULL)
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType()) {
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile, limit, counter+count);
                            }

                        if(counter+count<limit){
                            if(bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType() != TileType.NULL)
                                if(tile.getTileType() == bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())
                                    count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile, limit, counter+count);

                        }
                    }
                }
            }
        }

        return count;
    }


    /**
     * Takes the tiles adjacent to "tile" with the same TileType and reset the cells of the boolean
     * matrix "checkTiles" whose positions matches with the found tiles.
     * @param tile considered
     * @param bookshelf of the current player
     * @param checkTile matrix of boolean to check positions
     */
    public void ResetCheckTile(Tile tile,Bookshelf bookshelf,boolean[][] checkTile) {

        if (checkTile[tile.getRow()][tile.getCol()]) {
            checkTile[tile.getRow()][tile.getCol()] = false;

            if (tile.getCol() == 0) {
                if (bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType() != TileType.NULL)
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile);

            } else if (tile.getCol() == 4) {
                if (bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType() != TileType.NULL)
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
            } else {
                if (bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType() != TileType.NULL)
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile);

                if (bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType() != TileType.NULL)
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
            }


            if (tile.getRow() == 0) {
                if (bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType() != TileType.NULL) {
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile);

                } else if (tile.getRow() == 5) {
                    if (bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile);

                } else {
                    if (bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile);

                    if (bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType() != TileType.NULL)
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile);

                }
            }
        }
    }

}