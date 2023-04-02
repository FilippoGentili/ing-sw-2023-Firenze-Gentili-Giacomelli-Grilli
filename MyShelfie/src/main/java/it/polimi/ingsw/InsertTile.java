package it.polimi.ingsw;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertTile implements State{
    private Player player;
    private int column;
    private ArrayList<TileType> order;
    @Override
    public void stateAction (){
        int j=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        column = Integer.parseInt(scanner.nextLine());

        ArrayList<Tile> order = new ArrayList<Tile>();
        System.out.println("Choose the first tile");
        order.add(scanner.nextLine());

        if(!player.getBookshelf().fullBookshelf()){

        }

    }
}
