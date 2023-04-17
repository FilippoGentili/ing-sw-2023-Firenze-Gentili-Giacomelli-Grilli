package it.polimi.ingsw;
import static java.util.Objects.isNull;

abstract class CommonGoalCard {

    private int value = 8;
    private int delta;

    public abstract boolean check(Bookshelf bookshelf);

    public int getValue() {
        return this.value;
    }

    public void updateValue(){
        this.value = this.value - this.delta;
    }

    public void setDelta(int NumPlayers){
        if(NumPlayers == 2){
            this.delta = 4;
        }else{
            this.delta = 2;
        }
    }

    public int FindAdjacentTiles(Tile tile,Bookshelf bookshelf,boolean[][] checkTile,int limit,int counter){
        int count=0;

        if(counter<limit){

            if(!checkTile[tile.getRow()][tile.getCol()]){

                checkTile[tile.getRow()][tile.getCol()] = true;
                count++;

                if(tile.getCol()==0){
                    if (!isNull(bookshelf.getTile(tile.getRow(),tile.getCol() + 1)))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(),tile.getCol() + 1).getTileType())
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(),tile.getCol() + 1),bookshelf,checkTile,limit, counter+1);

                }else if(tile.getCol()==4){
                    if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() - 1)))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile, limit, counter+1);

                }else{
                    if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() + 1)))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType()) {
                            count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile, limit, counter + 1);
                            counter+=count;
                        }

                    if(counter<limit){
                        if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() - 1)))
                            if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile, limit, counter);

                    }
                }


                if(counter<limit){
                    if(tile.getRow()==0){
                        if(!isNull(bookshelf.getTile(tile.getRow()+1,tile.getCol())))
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile, limit, counter+1);

                    }else if(tile.getRow()==5){
                        if(!isNull(bookshelf.getTile(tile.getRow()-1,tile.getCol())))
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType())
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile, limit, counter+1);

                    }else{
                        if(!isNull(bookshelf.getTile(tile.getRow()-1,tile.getCol())))
                            if(tile.getTileType() == bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType()) {
                                count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile, limit, counter + 1);
                                counter += count;
                            }

                        if(counter<limit){
                            if(!isNull(bookshelf.getTile(tile.getRow()+1,tile.getCol())))
                                if(tile.getTileType() == bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())
                                    count += FindAdjacentTiles(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile, limit, counter);

                        }
                    }
                }
            }
        }

        return count;
    }

    public void ResetCheckTile(Tile tile,Bookshelf bookshelf,boolean[][] checkTile) {

        if (checkTile[tile.getRow()][tile.getCol()]) {
            checkTile[tile.getRow()][tile.getCol()] = false;

            if (tile.getCol() == 0) {
                if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() + 1)))
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile);

            } else if (tile.getCol() == 4) {
                if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() - 1)))
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
            } else {
                if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() + 1)))
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile);

                if (!isNull(bookshelf.getTile(tile.getRow(), tile.getCol() - 1)))
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
            }


            if (tile.getRow() == 0) {
                if (!isNull(bookshelf.getTile(tile.getRow() + 1, tile.getCol()))) {
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType())
                        ResetCheckTile(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile);

                } else if (tile.getRow() == 5) {
                    if (!isNull(bookshelf.getTile(tile.getRow() - 1, tile.getCol())))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile);

                } else {
                    if (!isNull(bookshelf.getTile(tile.getRow() - 1, tile.getCol())))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() - 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() - 1, tile.getCol()), bookshelf, checkTile);

                    if (!isNull(bookshelf.getTile(tile.getRow() + 1, tile.getCol())))
                        if (tile.getTileType() == bookshelf.getTile(tile.getRow() + 1, tile.getCol()).getTileType())
                            ResetCheckTile(bookshelf.getTile(tile.getRow() + 1, tile.getCol()), bookshelf, checkTile);

                }
            }
        }
    }

}