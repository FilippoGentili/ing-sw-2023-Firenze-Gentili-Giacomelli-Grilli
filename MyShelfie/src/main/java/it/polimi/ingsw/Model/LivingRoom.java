package it.polimi.ingsw.Model;

import it.polimi.ingsw.Observer.Observable;

import java.io.Serializable;
import java.util.ArrayList;

public class LivingRoom extends Observable implements Serializable {

    private static final long serialVersionUID = 5403724841040315028L;
    private static LivingRoom single_instance = null;
    private static int numberOfTiles=0;
    private static Tile[][] board;
    private static boolean[][] valid;
    private final int rows = 9;
    private final int columns = 9;

    private static Bag bag;


    /**
     * private constructor because of the singleton pattern
     */
    private LivingRoom(){
        board = new Tile[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                setTile(new Tile(TileType.NULL), i, j);
            }
        }
        valid = new boolean[rows][columns];
        bag = new Bag();
    }

    public Bag getBag(){
        return bag;
    }


    /**
     * Method to get the instance of the singleton
     * @return the instance of the livingroom
     */
    public static LivingRoom getInstance(){
        if(single_instance == null)
            single_instance = new LivingRoom();

        return  single_instance;
    }

    /**
     * Set a cell either true or false, to keep track of the cell to consider on the board
     * @param i row
     * @param j column
     * @param x value to be set
     */
    public void setValid(int i, int j, boolean x){
        valid[i][j]=x;
    }

    /**
     * check if a cell is either valid or not
     * @param i row
     * @param j column
     * @return true if it is valid, false if it is not valid
     */
    public boolean validCell(int i, int j){
        return valid[i][j];
    }

    public void setTile(Tile t, int i, int j){
        Tile tile = new Tile(t.getTileType());
        tile.setRow(i);
        tile.setCol(j);
        board[i][j] = tile;
    }

    public void setNull(int i, int j){
        setTile(new Tile(TileType.NULL), i, j);
    }

    public int getNumberOfTiles(){
        return numberOfTiles;
    }

    public Tile getTile(int i, int j){
        return board[i][j];
    }

    /**
     * Remove the tile of the specified position from the board, and return it
     * @param i row
     * @param j column
     * @return tile picked
     */
    public Tile pickTile(int i, int j){
        /*int count = 0;
        boolean stop = false;
        String input;
        int i, j;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tile> chosen = new ArrayList<Tile>();

        System.out.println("Scegli gli indici delle tessere che vuoi prendere (scrivi 'stop' se hai concluso la scelta):");

        //try catch per gestire l'immissione sbagliata degli indici

        System.out.println(count+1 + " tessera:");
        i = Integer.parseInt(scanner.nextLine());
        j = Integer.parseInt(scanner.nextLine());
        chosen.add(getTile(i ,j));
        count++;

        while(count<3 && !stop){

            System.out.println(count+1 + " tessera:");

            input = scanner.nextLine();

            if(input.equals("stop"))
                stop=true;
            else{
                i = Integer.parseInt(input);
                j = Integer.parseInt(scanner.nextLine());
                chosen.add(getTile(i ,j));
                count++;
            }

        }
        return chosen;*/    //ignora (interazione utente)

        Tile app;  //nuova istanza da creare?

        if(valid[i][j] && getTile(i,j).getTileType()!= TileType.NULL){
            app = getTile(i, j);
            setTile(new Tile(TileType.NULL), i, j);
            numberOfTiles--;

            return app;
        }else throw new IllegalArgumentException("Coordinate errate");
    }

    /**
     * inserts the tiles to fulfill the board
     * @param chosen arraylist of the tikes to insert
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
     * @param t1 first tile
     * @param t2 second tile
     * @return true if t1 and t2 are adjacents
     */
    public boolean isAdjacent(Tile t1, Tile t2){
        if((t1.getCol()==t2.getCol() && (t1.getRow()==t2.getRow()+1 || t1.getRow()==t2.getRow()-1)) ||
                (t1.getRow() == t2.getRow() && (t1.getCol()==t2.getCol()+1 || t1.getCol()==t2.getCol()-1)))
            return true;
        else return false;
    }

    /**
     * @param chosen tiles that I want to pick from the board
     * @return true if the selected tiles can be picked up, false if not
     */
    public boolean checkValid(ArrayList<Tile> chosen){

        int num;
        int x, y;

        for(Tile curr : chosen){
            num=0;
            x= curr.getRow();
            y= curr.getCol();

            /*if(!curr.getLocation().equals(Location.LIVING_ROOM))
                return false;
            */

            //se non ha almeno uno spazio adiacente libero return false
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
                        (isAdjacent(chosen.get(0), chosen.get(1)) && isAdjacent(chosen.get(0), chosen.get(2))))
                    return true;
                break;
            default:
                throw new IllegalArgumentException("il numero di tessere selezionato è sbagliato");
        }

        return false;
    }


}
