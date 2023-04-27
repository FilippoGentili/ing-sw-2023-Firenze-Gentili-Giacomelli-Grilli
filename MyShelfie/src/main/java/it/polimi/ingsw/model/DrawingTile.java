package it.polimi.ingsw.model;

import java.util.ArrayList;

public class DrawingTile implements State {
    private Player player;
    private static ArrayList<Tile> chosenTiles;
    int i, j, column;

    /**
     * This method gets an arraylist of chosen tiles from the player and asks for a column. Then sets them
     * in the bookshelf
     */
    public void stateAction (){

        chosenTiles.add(player.getGame().getLivingRoom().pickTile(i, j));
        player.getGame().getLivingRoom().checkValid(chosenTiles);

        //The player has to choose the column he wants to put the tiles in
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        int column = Integer.parseInt(scanner.nextLine());
        */
        if(!player.getBookshelf().spaceAvailable(chosenTiles, column)){
            player.getBookshelf().insertTiles(chosenTiles, column);
        }


    }
}
