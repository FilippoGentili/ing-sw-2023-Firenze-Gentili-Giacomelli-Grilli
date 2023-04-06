package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void printChosen(){

        Bag bag = new Bag();
        ArrayList<Tile> chosen = new ArrayList<Tile>();

        chosen = bag.extract(132);

        for(Tile tile:chosen)
            System.out.println(tile.getTileType());

        assertEquals(chosen.size(), 132);
    }
}