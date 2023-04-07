package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivingRoomTest {

    @Test
    void getNumTiles0(){
        LivingRoom living = LivingRoom.getInstance();

        assertEquals(0, living.getNumberOfTiles());
    }

}