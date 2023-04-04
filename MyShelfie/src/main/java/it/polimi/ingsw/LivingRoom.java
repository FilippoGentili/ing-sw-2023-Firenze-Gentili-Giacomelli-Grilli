package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class LivingRoom{

    private static LivingRoom single_instance = null;
    private static int numberOfTiles=0;
    private Tile[][] board;
    private boolean[][] valid;
    private final int rows = 9;
    private final int columns = 9;

    private LivingRoom(Game game){

        switch(game.numberOfTiles()){
            case 29:
                for(int i=0; i<rows; i++){
                    for(int j=0; j<columns; j++){
                        if((i==1 && (j==3 || j==4)) ||
                                (i==2 && (j==3 || j==4 || j==5)) ||
                                (i==3 && j!=0 && j!=1 && j!=8) ||
                                (i==4 && j!=0 && j!=8) ||
                                (i==5 && j!=0 && j!=7 && j!=8) ||
                                (i==6 && (j==3 || j==4 || j==5)) ||
                                (i==7 && (j==4 || j==5)))
                            valid[i][j]=true;
                        else valid[i][j]=false;
                    }
                }
                break;
            case 37:
                for(int i=0; i<rows; i++){
                    for(int j=0; j<columns; j++){
                        if((i==0 && j==3) ||
                                (i==1 && (j==3 || j==4)) ||
                                (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==3 && j!=0 && j!=1) ||
                                (i==4 && j!=0 && j!=8) ||
                                (i==5 && j!=7 && j!=8) ||
                                (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==7 && (j==4 || j==5)) ||
                                (i==8 && j==5))
                            valid[i][j]=true;
                        else valid[i][j]=false;
                    }
                }
                break;
            case 45:
                for(int i=0; i<rows; i++){
                    for(int j=0; j<columns; j++){
                        if((i==0 && (j==3 || j==4)) ||
                                (i==1 && (j==3 || j==4 || j==5)) ||
                                (i==2 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==3 && j!=0) ||
                                (i==4) ||
                                (i==5 && j!=8) ||
                                (i==6 && (j==2 || j==3 || j==4 || j==5 || j==6)) ||
                                (i==7 && (j==3 || j==4 || j==5)) ||
                                (i==8 && (j==4 || j==5)))
                            valid[i][j]=true;
                        else valid[i][j]=false;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal number of tiles");
        }

    }

    public static synchronized LivingRoom getInstance(Game game){
        if(single_instance == null)
            single_instance = new LivingRoom(game);

        return  single_instance;
    }

    public static int getNumberOfTiles(){
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

        Tile app;

        app = getTile(i, j);
        board[i][j]=null;
        numberOfTiles--;

        return app;
    }

    public void insertTiles(ArrayList<Tile> chosen){
        for(Tile tile:chosen){
            for(int i=0; i<rows; i++){
                for(int j=0; j<columns; j++){
                    if(valid[i][j] && board[i][j]==null){
                        board[i][j]=tile;
                        tile.setLocation(Location.LIVING_ROOM);
                        tile.setRow(i);
                        tile.setCol(j);
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

        for(Tile curr:chosen){
            if(curr.getLocation() != Location.LIVING_ROOM)
                return false;
            if(board[curr.getRow()-1][curr.getCol()] != null && board[curr.getRow()+1][curr.getCol()] != null
            && board[curr.getRow()][curr.getCol()-1] != null && board[curr.getRow()][curr.getCol()+1] != null)
                return false;
        }

        switch (chosen.size()){
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
