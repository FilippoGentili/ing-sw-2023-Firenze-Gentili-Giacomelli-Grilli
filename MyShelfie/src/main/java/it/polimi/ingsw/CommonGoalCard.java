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


    public int HorizontalCheck(Tile tile,Bookshelf bookshelf,boolean[][] checkTile){
        int count=0;

        if(!checkTile[tile.getRow()][tile.getCol()]){

            checkTile[tile.getRow()][tile.getCol()] = true;

            if(!isNull(tile)) {

                if (tile.getCol() == 0) {
                    if (tile.getTileType() == bookshelf.getTile(tile.getRow(),tile.getCol()+1).getTileType()) {
                        count = 1 + HorizontalCheck(bookshelf.getTile(tile.getRow(), tile.getCol()+1),bookshelf,checkTile);
                    } else {
                        count = 1;
                    }
                } else if (tile.getCol() == 4) {
                    if (tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())) {
                        count = 1 + HorizontalCheck(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
                    } else {
                        count = 1;
                    }

                } else {
                    if (tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow(), tile.getCol() + 1).getTileType())) {
                        count = 1 + HorizontalCheck(bookshelf.getTile(tile.getRow(), tile.getCol() + 1), bookshelf, checkTile);
                    } else {
                        count = 1;
                    }
                    if (tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow(), tile.getCol() - 1).getTileType())) {
                        count = 1 + HorizontalCheck(bookshelf.getTile(tile.getRow(), tile.getCol() - 1), bookshelf, checkTile);
                    } else {
                        count = 1;
                    }
                }
            }

        }
        return count;
    }


    public int VerticalCheck(Tile tile, Bookshelf bookshelf, boolean[][] checkTile){
        int count=0;

        if(!checkTile[tile.getRow()][tile.getCol()]){

            checkTile[tile.getRow()][tile.getCol()] = true;

            if(!isNull(tile)){
                if(tile.getRow()==0){
                    if(tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())){
                        count = 1 + VerticalCheck(bookshelf.getTile(tile.getRow()+1,tile.getCol()), bookshelf, checkTile);
                    }else{
                        count = 1;
                    }
                } else if(tile.getRow()==5){
                    if(tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType())){
                        count = 1 + VerticalCheck(bookshelf.getTile(tile.getRow()-1,tile.getCol()), bookshelf, checkTile);
                    }else{
                        count = 1;
                    }
                }else{
                    if(tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow()+1,tile.getCol()).getTileType())){
                        count = 1 + VerticalCheck(bookshelf.getTile(tile.getRow()+1,tile.getCol()), bookshelf, checkTile);
                    }else{
                        count = 1;
                    }
                    if(tile.getTileType().equals(
                            bookshelf.getTile(tile.getRow()-1,tile.getCol()).getTileType())){
                        count = 1 + VerticalCheck(bookshelf.getTile(tile.getRow()-1,tile.getCol()), bookshelf, checkTile);
                    }else{
                        count = 1;
                    }
                }
            }
        }
        return count;
    }
}