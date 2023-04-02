package it.polimi.ingsw;

import java.util.ArrayList;

public class Bookshelf {
    private Tile[][] shelf;

    private final int rows=6;
    private final int columns=5;

    boolean[][] alreadyChecked = new boolean[rows][columns];

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

    public ArrayList<Tile> getSameAdjacentTiles(Tile curr){
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
    }

    /*public boolean hasSameAdjacentTiles(Tile curr){
        if(curr.getRow()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()-1][curr.getCol()].getTileType()))
            return true;
        if(curr.getCol()-1 >= 0 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()-1].getTileType()))
            return true;
        if(curr.getCol()+1 <= columns-1 && curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()+1].getTileType()))
            return true;
        if(curr.getRow()+1 <= rows-1 && curr.getTileType().equals(shelf[curr.getRow()+1][curr.getCol()].getTileType()))
            return true;

        return false;
    }*/

    public int MatrixWalk(ArrayList<Tile> tiles, int numAd){

        if(tiles.size()>0){
            for(Tile curr:tiles){
                if(!alreadyChecked[curr.getRow()][curr.getCol()]){
                    numAd++;
                    alreadyChecked[curr.getRow()][curr.getCol()]=true;
                    MatrixWalk(getSameAdjacentTiles(curr), numAd);
                }
            }
        }

        return numAd;
    }

    public int countPoints(){

        int numAd = 0;
        boolean more=true;
        ArrayList<Tile> adj;
        int points=0;


        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                alreadyChecked[i][j]=false;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(!alreadyChecked[i][j]){
                    numAd=1;
                    alreadyChecked[i][j] = true;
                    adj = getSameAdjacentTiles(shelf[i][j]);
                    numAd = MatrixWalk(adj, numAd);
                }

                if(numAd==3)
                    points+=2;
                else if(numAd==4)
                    points+=3;
                else if(numAd==5)
                    points+=5;
                else if(numAd>=6)
                    points+=8;

            }
        }

        return points;
    }

    public boolean fullBookshelf(){
        for(int j=0; j<columns; j++){
            if(shelf[0][j] == null)
                return false;
        }

        return true;
    }

}
