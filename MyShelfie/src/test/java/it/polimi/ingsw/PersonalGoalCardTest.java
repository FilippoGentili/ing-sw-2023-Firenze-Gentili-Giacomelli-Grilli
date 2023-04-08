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




}