package it.polimi.ingsw;

import java.util.ArrayList;

public class Bookshelf {
    private Tile[][] shelf;

    private final int rows=6;
    private final int columns=5;

    public boolean isEmpty(int i, int j){
        if(shelf[i][j] != null)
            return false;
        else
            return true;
    }

    public Tile getTile(int i, int j){
        return shelf[i][j];
    }

    public Tile[][] getShelf(){
        return shelf;
    }

    /*public ArrayList<Tile> getSameAdjacentTiles(Tile curr){
        ArrayList<Tile> adjacents = new ArrayList<Tile>();
        if(curr.getRow()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()-1][curr.getCol()].getTileType()))
            adjacents.add(shelf[curr.getRow()-1][curr.getCol()]);
        if(curr.getCol()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()-1].getTileType()))
            adjacents.add(shelf[curr.getRow()][curr.getCol()-1]);
        if(curr.getCol()+1 <= columns-1 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()+1].getTileType()))
            adjacents.add(shelf[curr.getRow()][curr.getCol()+1]);
        if(curr.getRow()+1 <= rows-1 && curr.getTileType().equals(shelf[curr.getRow()+1][curr.getCol()].getTileType()))
            adjacents.add(shelf[curr.getRow()+1][curr.getCol()]);

        return adjacents;
    }*/

    public boolean hasSameAdjacentTiles(Tile curr){
        if(curr.getRow()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()-1][curr.getCol()].getTileType()))
            return true;
        if(curr.getCol()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()-1].getTileType()))
            return true;
        if(curr.getCol()+1 <= columns-1 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()+1].getTileType()))
            return true;
        if(curr.getRow()+1 <= rows-1 && curr.getTileType().equals(shelf[curr.getRow()+1][curr.getCol()].getTileType()))
            return true;

        return false;
    }

    public int MatrixWalk(ArrayList<Tile> tiles){
        if(tiles.size()>0){
            for(Tile curr:tiles){
                MatrixWalk(curr.)
            }
        }
    }

    public int countPoints(){

        boolean[][] alreadyChecked = new boolean[rows][columns];
        int numAd;
        boolean more=true;
        ArrayList<Tile> adj;


        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                alreadyChecked[i][j]=false;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                numAd=1;
                alreadyChecked[i][j] = true;
                adj = getSameAdjacentTiles(shelf[i][j]);
                if(adj.size() > 0){
                    for(Tile curr:adj){
                        if(!alreadyChecked[curr.getRow()][curr.getCol()]){
                            numAd++;
                            getSameAdjacentTiles(shelf[curr.getRow()][curr.getCol()])
                        }
                    }
                    adj = getSameAdjacentTiles(shelf[i][j]);
                }
            }
        }

    }

    public boolean fullBookshelf(){
        for(int j=0; j<columns; j++){
            if(shelf[0][j] == null)
                return false;
        }

        return true;
    }
}
