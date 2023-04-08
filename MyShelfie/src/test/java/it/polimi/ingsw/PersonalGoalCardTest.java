package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalGoalCardTest {


    @Test
    public void zeroMatchesGiveZeroPoints() {
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(0, pGoal.countPoints(0));
    }
    @Test
    public void OneMatchGivesOnePoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(1, pGoal.countPoints(1));

    }
    @Test
    public void TwoMatchesGiveTwoPoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(2, pGoal.countPoints(2));

    }
    @Test
    public void ThreeMatchesGiveFourPoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(4, pGoal.countPoints(3));
    }
    @Test
    public void FourMatchesGiveSixPoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(6, pGoal.countPoints(4));

    }
    @Test
    public void FiveMatchesGiveNinePoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(9, pGoal.countPoints(5));

    }

    @Test
    public void SixMatchesGiveTwelvePoints(){
        PersonalGoalCard pGoal = new PersonalGoalCard();
        assertEquals(12, pGoal.countPoints(6));
    }


    @Test
    public void checkPGoal1SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.PLANT);
        player.getBookshelf().setTile(0,2, TileType.FRAME);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(6, pGoal1.check(pGoal1.getID()));
    }
    @Test
    public void checkPGoal1FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.FRAME);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(5, pGoal1.check(pGoal1.getID()));
    }


    @Test
    public void checkPGoal1FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(4, pGoal1.check(pGoal1.getID()));
    }

    @Test
    public void checkPGoal1ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(3, pGoal1.check(pGoal1.getID()));
    }

    @Test
    public void checkPGoal1TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(2, pGoal1.check(pGoal1.getID()));
    }

    @Test
    public void checkPGoal1OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.PLANT);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(1, pGoal1.check(pGoal1.getID()));
    }

    @Test
    public void checkPGoal1ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        pGoal1.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.PLANT);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(0, pGoal1.check(pGoal1.getID()));
    }

    @Test
    public void checkPGoal2SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(6, pGoal2.check(pGoal2.getID()));
    }

    @Test
    public void checkPGoal2FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(5, pGoal2.check(pGoal2.getID()));
    }
    @Test
    public void checkPGoal2FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(4, pGoal2.check(pGoal2.getID()));
    }
    @Test
    public void checkPGoal2ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(3, pGoal2.check(pGoal2.getID()));
    }

    @Test
    public void checkPGoal2TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(2, pGoal2.check(pGoal2.getID()));
    }

    @Test
    public void checkPGoal2OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(1, pGoal2.check(pGoal2.getID()));
    }

    @Test
    public void checkPGoal2ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        pGoal2.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,4, TileType.PLANT);

        assertEquals(0, pGoal2.check(pGoal2.getID()));
    }

    @Test
    public void checkPGoal3SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(6, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal3FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(5, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal3FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(4, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal3ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(3, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal3TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(2, pGoal3.check(pGoal3.getID()));
    }
    @Test
    public void checkPGoal3OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(1, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal3ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        pGoal3.setPlayer(player);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(0, pGoal3.check(pGoal3.getID()));
    }

    @Test
    public void checkPGoal4SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(6, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal4FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(5, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal4FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(4, pGoal4.check(pGoal4.getID()));
    }
    @Test
    public void checkPGoal4ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(3, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal4TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(2, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal4OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(1, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal4ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        pGoal4.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.GAME);

        assertEquals(0, pGoal4.check(pGoal4.getID()));
    }

    @Test
    public void checkPGoal5SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,1, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(6, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(5, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(4, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(3, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(2, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(1, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal5ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        pGoal5.setPlayer(player);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(0, pGoal5.check(pGoal5.getID()));
    }

    @Test
    public void checkPGoal6SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.TROPHIE);
        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(6, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(5, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(4, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(3, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(2, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(1, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal6ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        pGoal6.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.TROPHIE);

        assertEquals(0, pGoal6.check(pGoal6.getID()));
    }

    @Test
    public void checkPGoal7SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.CAT);
        player.getBookshelf().setTile(1,3, TileType.FRAME);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(6, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.FRAME);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(5, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(4, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(3, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(2, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.BOOK);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(1, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal7ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        pGoal7.setPlayer(player);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.BOOK);
        player.getBookshelf().setTile(5,2, TileType.CAT);

        assertEquals(0, pGoal7.check(pGoal7.getID()));
    }

    @Test
    public void checkPGoal8SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.FRAME);
        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(6, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(5, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(4, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(3, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(2, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(1, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal8ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        pGoal8.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.FRAME);

        assertEquals(0, pGoal8.check(pGoal8.getID()));
    }

    @Test
    public void checkPGoal9SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(6, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(5, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(4, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(3, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(2, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(1, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal9ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        pGoal9.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.GAME);

        assertEquals(0, pGoal9.check(pGoal9.getID()));
    }

    @Test
    public void checkPGoal10SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(6, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(5, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(4, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(3, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(2, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(1, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal10ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        pGoal10.setPlayer(player);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(0, pGoal10.check(pGoal10.getID()));
    }

    @Test
    public void checkPGoal11SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(6, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(5, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(4, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(3, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(2, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(1, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal11ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        pGoal11.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(0, pGoal11.check(pGoal11.getID()));
    }

    @Test
    public void checkPGoal12SixMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(6, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12FiveMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(5, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12FourMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(4, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12ThreeMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(3, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12TwoMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(2, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12OneMatch(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(1, pGoal12.check(pGoal12.getID()));
    }

    @Test
    public void checkPGoal12ZeroMatches(){
        Player player = new Player();
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        pGoal12.setPlayer(player);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(0, pGoal12.check(pGoal12.getID()));
    }


}