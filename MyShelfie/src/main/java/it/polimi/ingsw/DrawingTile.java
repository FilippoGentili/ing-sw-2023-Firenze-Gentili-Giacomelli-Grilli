package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class DrawingTile implements State{
    private Player player;
    private ArrayList<Tile> chosenTiles;

    @Override
    public void stateAction (){
        int i, j;

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tiles do you want to pick?");
        int nrTiles = Integer.parseInt(scanner.nextLine());

    }
}
