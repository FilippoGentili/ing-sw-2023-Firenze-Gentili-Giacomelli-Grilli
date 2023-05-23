package it.polimi.ingsw.Model;

import it.polimi.ingsw.Observer.Observable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Bookshelf
 * @author pheelaw
 */
public class Bookshelf extends Observable implements Serializable {
    private static final long serialVersionUID = 8979967644213276996L;
    private Tile[][] shelf;

    private final int rows=6;
    private final int columns=5;

    private static boolean[][] alreadyChecked;

    public Bookshelf(){
        shelf = new Tile[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                shelf[i][j] = new Tile(TileType.NULL);
            }
        }
        alreadyChecked = new boolean[rows][columns];
    }

    /**
     * @param i row
     * @param j column
     * @return true if the cell is empty, false if there is a tile
     */
    public boolean isEmpty(int i, int j){
        if(shelf[i][j].getTileType() != TileType.NULL)
            return false;
        else
            return true;
    }

    public Tile getTile(int i, int j){
        return shelf[i][j];
    }

    /**
     * @param tiles arraylist of the Tiles I want to insert
     * @param col column of the bookshelf where I want to insert the tiles
     * @return true if there is enough space to put the selected tiles, false if there is no space
     */
    public boolean spaceAvailable(ArrayList<Tile> tiles, int col){
        for(int i=0; i<tiles.size(); i++){
            if(!isEmpty(i, col))
                return false;
        }
        return true;
    }

    /**
     * Stores the tiles in the bookshelf
     * @param tiles arraylist of tiles I want to insert
     * @param col column of the bookshelf where I want to insert the selected tiles
     */
    public void insertTiles(ArrayList<Tile> tiles, int col){

        int i=rows-1;

        for(Tile app : tiles){
            while(!isEmpty(i, col) && i>=0){
                i--;
            }
            Tile def = new Tile(app.getTileType());
            def.setRow(i);
            def.setCol(col);
            shelf[i][col]=def;
            //shelf[i][col].setLocation(Location.BOOKSHELF);
        }
    }

    /**
     * @param curr Tile I am considering
     * @return an arraylist of the tiles adjacent to curr and of the same tileType of curr
     */
    public ArrayList<Tile> getSameAdjacentTiles(Tile curr){
        ArrayList<Tile> adjacents = new ArrayList<Tile>();
        if(curr.getRow()-1 >= 0 && shelf[curr.getRow()-1][curr.getCol()].getTileType() != TileType.NULL)
            if(curr.getTileType().equals(shelf[curr.getRow()-1][curr.getCol()].getTileType()))
                adjacents.add(shelf[curr.getRow()-1][curr.getCol()]);
        if(curr.getCol()-1 >= 0 && shelf[curr.getRow()][curr.getCol()-1].getTileType() != TileType.NULL)
            if(curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()-1].getTileType()))
                adjacents.add(shelf[curr.getRow()][curr.getCol()-1]);
        if(curr.getCol()+1 <= columns-1 && shelf[curr.getRow()][curr.getCol()+1].getTileType() != TileType.NULL)
            if(curr.getTileType().equals(shelf[curr.getRow()][curr.getCol()+1].getTileType()))
                adjacents.add(shelf[curr.getRow()][curr.getCol()+1]);
        if(curr.getRow()+1 <= rows-1 && shelf[curr.getRow()+1][curr.getCol()].getTileType() != TileType.NULL)
            if(curr.getTileType().equals(shelf[curr.getRow()+1][curr.getCol()].getTileType()))
                adjacents.add(shelf[curr.getRow()+1][curr.getCol()]);

        return adjacents;
    }

    /**
     * recursive method that counts the number of tiles in a group
     * @param tiles arrayList of tiles of the same type
     * @param x number of the adjacent tiles of the same time so far
     * @return number of tiles of the same type adjacent to each other
     */
    public int MatrixWalk(ArrayList<Tile> tiles, int x){

        int y=x;

        if(tiles.size()>0){
            for(Tile curr:tiles){
                if(!alreadyChecked[curr.getRow()][curr.getCol()]){
                    x++;
                    alreadyChecked[curr.getRow()][curr.getCol()]=true;
                    y = MatrixWalk(getSameAdjacentTiles(curr), x);
                }
            }
        }

        return y;
    }

    /**
     * Counts the points given from the bookshelf at the end of the game
     * @return points to assign
     */
    public int countPoints(){

        int numAd = 0;
        ArrayList<Tile> adj;
        int points=0;


        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                alreadyChecked[i][j]=false;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(!alreadyChecked[i][j] && getTile(i, j).getTileType() != TileType.NULL){
                    numAd=1;
                    alreadyChecked[i][j] = true;
                    adj = getSameAdjacentTiles(this.getTile(i,j));
                    numAd = MatrixWalk(adj, numAd);

                    System.out.println(numAd);

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
        }

        return points;
    }

    /**
     * @return true if the bookshelf is full, false if there are some free cells
     */
    public boolean fullBookshelf(){
        for(int j=0; j<columns; j++){
            if(shelf[0][j].getTileType() == TileType.NULL)
                return false;
        }

        return true;
    }




    /**
     * Set a tile in a given position
     * Use only for testing!
     * @param i row
     * @param j column
     * @param type type to set to the tile
     */
    public void setTile(int i, int j, TileType type) {
        Tile tile = new Tile(type);
        tile.setRow(i);
        tile.setCol(j);
        shelf[i][j]=tile;
    }

    public int getMaxPossibleTiles(){
        int max=0;
        int curr=0;
        for(int i=0; i<columns; i++){
            for(int j=0; j<rows; j++){
                curr=0;
                if(isEmpty(j, i))
                    curr++;
            }
            if(curr>max)
                max=curr;
        }
        if(max>=3)
            return 3;
        else return max;
    }

    public ArrayList<Integer> getFreeColumns(int size){
        ArrayList<Integer> col = new ArrayList<>();
        int curr;

        for(int i=0; i<columns; i++){
            curr=0;
            for(int j=0; j<rows; j++){
                if(isEmpty(j, i))
                    curr++;
            }
            if(curr>=size)
                col.add(i);
        }

        return col;
    }
}
