package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class LivingRoom{

    private static LivingRoom single_instance = null;
    private static int numberOfTiles=0;
    private static Tile[][] board;
    private static boolean[][] valid;
    private final int rows = 9;
    private final int columns = 9;

    private LivingRoom(){
        board = new Tile[rows][columns];
        valid = new boolean[rows][columns];
    }

    public static LivingRoom getInstance(){
        if(single_instance == null)
            single_instance = new LivingRoom();

        return  single_instance;
    }

    public void setValid(int i, int j, boolean x){
        valid[i][j]=x;
    }

    public boolean validCell(int i, int j){
        return valid[i][j];
    }

    void setTile(Tile t, int i, int j){
        Tile tile = new Tile(t.getTileType());
        tile.setRow(i);
        tile.setCol(j);
        board[i][j] = tile;
    }

    void setNull(int i, int j){
        board[i][j]=null;
    }

    public int getNumberOfTiles(){
        return numberOfTiles;
    }

    public Tile getTile(int i, int j){
        return board[i][j];
    }

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
        return chosen;*/    //interazione utente

        Tile app;  //nuova istanza da creare?

        if(valid[i][j] && getTile(i,j)!=null){
            app = getTile(i, j);
            board[i][j]=null;
            numberOfTiles--;

            return app;
        }else throw new IllegalArgumentException("Coordinate errate");

    }

    public void insertTiles(ArrayList<Tile> chosen){

        int x=0;

        while (x< chosen.size()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (valid[i][j] && getTile(i, j) == null) {
                        setTile(chosen.get(0), i, j);
                        chosen.remove(0);
                        numberOfTiles++;
                    }
                }
            }
        }
    }


    public boolean isAdjacent(Tile t1, Tile t2){
        if((t1.getCol()==t2.getCol() && (t1.getRow()==t2.getRow()+1 || t1.getRow()==t2.getRow()-1)) ||
                (t1.getRow() == t2.getRow() && (t1.getCol()==t2.getCol()+1 || t1.getCol()==t2.getCol()-1)))
            return true;
        else return false;
    }

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
                if(getTile(x-1, y) != null)
                    num++;
            if(x <= 7)
                if(getTile(x+1, y) != null)
                    num++;
            if(y >= 1)
                if(getTile(x, y-1) != null)
                    num++;
            if(y <= 7)
                if(getTile(x, y+1) != null)
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
