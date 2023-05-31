package it.polimi.ingsw;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Tile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void printChosen(){

        Game game = new Game();
        Bag bag = new Bag(game);
        ArrayList<Tile> chosen = new ArrayList<Tile>();

        chosen = bag.extract(132);

        for(Tile tile:chosen)
            System.out.println(tile.getTileType());

        assertEquals(chosen.size(), 132);
    }
}