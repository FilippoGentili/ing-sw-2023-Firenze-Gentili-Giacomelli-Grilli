package it.polimi.ingsw;

import java.util.ArrayList;

public class LivingRoom {

    private static LivingRoom single_instance = null;
    private static int numberOfTiles=0;
    private Tile[][] board;
    private boolean[][] valid;
    private final int rows = 9;
    private final int columns = 9;

    private LivingRoom(){

    }

    public static synchronized LivingRoom getInstance(){
        if(single_instance == null)
            single_instance = new LivingRoom();

        return  single_instance;
    }

    public static int getNumberOfTiles(){
        return numberOfTiles;
    }

    public void insertTiles(ArrayList<Tile> chosen){
        for(Tile tile:chosen){
            for(int i=0; i<rows; i++){
                for(int j=0; j<columns; j++){
                    if(valid[i][j]){
                        board[i][j]=tile;
                        numberOfTiles++;
                    }
                }
            }
        }
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
