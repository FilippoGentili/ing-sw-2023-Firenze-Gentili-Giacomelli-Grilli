package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTile implements State{
    private Player player;
    private static ArrayList<Tile> chosenTiles;

    int i, j;

    public void stateAction (){
        chosenTiles.add(player.getGame().getLivingRoom().pickTile(i, j));
        player.getGame().getLivingRoom().checkValid(chosenTiles);

        //The player has to choose the column he wants to put the tiles in
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        int column = Integer.parseInt(scanner.nextLine());
        */
        if(!player.getBookshelf().fullBookshelf()){
            player.getBookshelf().insertTiles(chosenTiles, column);
        }


    }
}
