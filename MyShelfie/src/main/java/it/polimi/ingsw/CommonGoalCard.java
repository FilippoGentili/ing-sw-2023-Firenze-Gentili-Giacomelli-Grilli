package it.polimi.ingsw;

abstract class CommonGoalCard {
    private int id;
    private int value = 8;
    private int delta;

    public abstract boolean check(Player player);

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

    public int FindSubmatrix(Tile tile, Player player, boolean[][] checkTile){
        int count=0;
        checkTile[tile.getRow()][tile.getCol()]=true;

        if(tile.getRow()==0){
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow()+1, tile.getCol()).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()), player, checkTile);
            }
        }else if(tile.getRow()==6){
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow()-1, tile.getCol()).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()-1, tile.getCol()), player, checkTile);
            }
        }else{
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()), player, checkTile);
            }
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()), player, checkTile);
            }

        }

        if(tile.getCol()==0){
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1), player, checkTile);
            }
        } else if(tile.getCol()==5){
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1), player, checkTile);
            }
        }else{
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1), player, checkTile);
            }
            if(tile.getTileType().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1).getTileType())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1), player, checkTile);
            }
        }


        return count;
    }
}