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

    }

    public static ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }
}
