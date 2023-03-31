package it.polimi.ingsw;

import java.util.ArrayList;

public class LivingRoom {

    private static int numberOfTiles;
    private Tile[][] board;
    private boolean[][] valid;

    public static int getNumberOfTiles(){
        return numberOfTiles;
    }

    public void insertTiles(ArrayList<Tile> chosen){


    }

    public Tile getTile(int i, int j){
        return board[i][j];
    }

    public boolean isAdjacent(Tile t1, Tile t2){
        if(t1.getLocation().equals(t2.getLocation()) && (t1.getCol()==t2.getCol() && (t1.getRow()==t2.getRow()+1 || t1.getRow()==t2.getRow()-1)) || (t1.getRow() == t2.getRow() && (t1.getCol()==t2.getCol()+1 || t1.getCol()==t2.getCol()-1)))
            return true;
        else return false;
    }
}
