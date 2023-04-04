package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTile implements State{
    private Player player;
    private ArrayList<Tile> chosenTiles;



    public void stateAction (){
        int i, j;

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tiles do you want to pick?");
        int nrTiles = Integer.parseInt(scanner.nextLine());

        chosenTiles = player.getGame().getLivingRoom().pickTiles();
        player.getGame().getLivingRoom().checkValid(chosenTiles);

    }

    public ArrayList<Tile> getChosenTiles(){
        return chosenTiles;
    }
}
