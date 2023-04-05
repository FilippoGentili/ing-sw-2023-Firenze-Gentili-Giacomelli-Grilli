package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertTile implements State{
    private Player player;

    @Override
    public void stateAction (){
        ArrayList<Tile> order;
        ArrayList<Tile> chosenTiles;

        //The player has to choose the column he wants to put the tiles in
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        int column = Integer.parseInt(scanner.nextLine());

        //An arraylist of tiles is created to set the order
        order = new ArrayList<Tile>();
        //An arraylist order is used to
        for (Tile Tile : chosenTiles=DrawingTile.getChosenTiles()) {
            System.out.println("Select the order of ");
            int j = Integer.parseInt(scanner.nextLine());
            order.add(chosenTiles.get(j));
        }

        if(!player.getBookshelf().fullBookshelf()){
            player.getBookshelf().insertTiles(order, column);
        }

    }
}
