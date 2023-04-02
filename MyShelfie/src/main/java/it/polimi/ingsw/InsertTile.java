package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertTile implements State{
    private Player player;

    @Override
    public void stateAction (){
        ArrayList<TileType> order;
        ArrayList<TileType> chosenTiles;

        //The player has to choose the column he wants to put the tiles in
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        int column = Integer.parseInt(scanner.nextLine());

        order = new ArrayList<TileType>();
        chosenTiles = new ArrayList<TileType>();
        //An arraylist order is used to
        for (TileType tileType : chosenTiles=DrawingTile.stateAction()) {
            System.out.println("Choose the tile order");
            order.add(TileType.valueOf(scanner.nextLine()));
        }

        if(!player.getBookshelf().fullBookshelf()){

        }

    }
}
