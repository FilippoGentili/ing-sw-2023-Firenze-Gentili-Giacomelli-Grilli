package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTile implements State{
    private Player player;
    private ArrayList<Tile> chosenTiles;



    public void stateAction (){
        chosenTiles = player.getGame().getLivingRoom().pickTiles(i, j);
        player.getGame().getLivingRoom().checkValid(chosenTiles);

    }

    public ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }
}
