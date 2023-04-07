package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalGoalCardTest {

    /*
    @Test
    public void zeroMatchesGiveZeroPoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(0, pGoal1.countPoints(0));
        assertEquals(0, pGoal2.countPoints(0));
        assertEquals(0, pGoal3.countPoints(0));
        assertEquals(0, pGoal4.countPoints(0));
        assertEquals(0, pGoal5.countPoints(0));
        assertEquals(0, pGoal6.countPoints(0));
        assertEquals(0, pGoal7.countPoints(0));
        assertEquals(0, pGoal8.countPoints(0));
        assertEquals(0, pGoal9.countPoints(0));
        assertEquals(0, pGoal10.countPoints(0));
        assertEquals(0, pGoal11.countPoints(0));
        assertEquals(0, pGoal12.countPoints(0));

    }
    @Test
    public void OneMatchGivesOnePoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(1, pGoal1.countPoints(1));
        assertEquals(1, pGoal2.countPoints(1));
        assertEquals(1, pGoal3.countPoints(1));
        assertEquals(1, pGoal4.countPoints(1));
        assertEquals(1, pGoal5.countPoints(1));
        assertEquals(1, pGoal6.countPoints(1));
        assertEquals(1, pGoal7.countPoints(1));
        assertEquals(1, pGoal8.countPoints(1));
        assertEquals(1, pGoal9.countPoints(1));
        assertEquals(1, pGoal10.countPoints(1));
        assertEquals(1, pGoal11.countPoints(1));
        assertEquals(1, pGoal12.countPoints(1));
    }
    @Test
    public void TwoMatchesGiveTwoPoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(2, pGoal1.countPoints(2));
        assertEquals(2, pGoal2.countPoints(2));
        assertEquals(2, pGoal3.countPoints(2));
        assertEquals(2, pGoal4.countPoints(2));
        assertEquals(2, pGoal5.countPoints(2));
        assertEquals(2, pGoal6.countPoints(2));
        assertEquals(2, pGoal7.countPoints(2));
        assertEquals(2, pGoal8.countPoints(2));
        assertEquals(2, pGoal9.countPoints(2));
        assertEquals(2, pGoal10.countPoints(2));
        assertEquals(2, pGoal11.countPoints(2));
        assertEquals(2, pGoal12.countPoints(2));

    }
    @Test
    public void ThreeMatchesGiveFourPoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(4, pGoal1.countPoints(3));
        assertEquals(4, pGoal2.countPoints(3));
        assertEquals(4, pGoal3.countPoints(3));
        assertEquals(4, pGoal4.countPoints(3));
        assertEquals(4, pGoal5.countPoints(3));
        assertEquals(4, pGoal6.countPoints(3));
        assertEquals(4, pGoal7.countPoints(3));
        assertEquals(4, pGoal8.countPoints(3));
        assertEquals(4, pGoal9.countPoints(3));
        assertEquals(4, pGoal10.countPoints(3));
        assertEquals(4, pGoal11.countPoints(3));
        assertEquals(4, pGoal12.countPoints(3));

    }
    @Test
    public void FourMatchesGiveSixPoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(6, pGoal1.countPoints(4));
        assertEquals(6, pGoal2.countPoints(4));
        assertEquals(6, pGoal3.countPoints(4));
        assertEquals(6, pGoal4.countPoints(4));
        assertEquals(6, pGoal5.countPoints(4));
        assertEquals(6, pGoal6.countPoints(4));
        assertEquals(6, pGoal7.countPoints(4));
        assertEquals(6, pGoal8.countPoints(4));
        assertEquals(6, pGoal9.countPoints(4));
        assertEquals(6, pGoal10.countPoints(4));
        assertEquals(6, pGoal11.countPoints(4));
        assertEquals(6, pGoal12.countPoints(4));

    }
    @Test
    public void FiveMatchesGiveNinePoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(9, pGoal1.countPoints(5));
        assertEquals(9, pGoal2.countPoints(5));
        assertEquals(9, pGoal3.countPoints(5));
        assertEquals(9, pGoal4.countPoints(5));
        assertEquals(9, pGoal5.countPoints(5));
        assertEquals(9, pGoal6.countPoints(5));
        assertEquals(9, pGoal7.countPoints(5));
        assertEquals(9, pGoal8.countPoints(5));
        assertEquals(9, pGoal9.countPoints(5));
        assertEquals(9, pGoal10.countPoints(5));
        assertEquals(9, pGoal11.countPoints(5));
        assertEquals(9, pGoal12.countPoints(5));

    }

    @Test
    public void SixMatchesGiveTwelvePoints(){
        PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
        PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
        PersonalGoalCard pGoal3= new PersonalGoalCard(3);
        PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
        PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
        PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
        PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
        PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
        PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
        PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
        PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
        PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

        assertEquals(12, pGoal1.countPoints(6));
        assertEquals(12, pGoal2.countPoints(6));
        assertEquals(12, pGoal3.countPoints(6));
        assertEquals(12, pGoal4.countPoints(6));
        assertEquals(12, pGoal5.countPoints(6));
        assertEquals(12, pGoal6.countPoints(6));
        assertEquals(12, pGoal7.countPoints(6));
        assertEquals(12, pGoal8.countPoints(6));
        assertEquals(12, pGoal9.countPoints(6));
        assertEquals(12, pGoal10.countPoints(6));
        assertEquals(12, pGoal11.countPoints(6));
        assertEquals(12, pGoal12.countPoints(6));
    }
    */

    @Test
    public void assignPointsToPGoal1(){
        Bookshelf bookshelf= new Bookshelf();
        bookshelf.setTile(0,0, TileType.PLANT);
        bookshelf.setTile(0,2, TileType.FRAME);
        bookshelf.setTile(1,4, TileType.CAT);
        bookshelf.setTile(2,3, TileType.BOOK);
        bookshelf.setTile(3,1, TileType.GAME);
        bookshelf.setTile(5,2, TileType.TROPHIE);

        PersonalGoalCard pGoal1= new PersonalGoalCard(1);

        assertEquals(6, pGoal1.check1());
        assertEquals(12, pGoal1.countPoints(pGoal1.check1()));

    }

}