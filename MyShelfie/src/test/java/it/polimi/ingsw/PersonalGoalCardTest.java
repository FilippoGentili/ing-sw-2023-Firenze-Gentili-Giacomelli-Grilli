package it.polimi.ingsw;

import it.polimi.ingsw.Model.*;
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
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.PLANT);
        player.getBookshelf().setTile(0,2, TileType.FRAME);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void checkPGoal1FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.FRAME);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }


    @Test
    public void checkPGoal1FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal1ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal1TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal1OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.PLANT);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal1ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.TROPHIE);
        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(1,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(3,1, TileType.PLANT);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal2SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal2FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void checkPGoal2FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void checkPGoal2ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal2TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal2OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal2ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,4, TileType.PLANT);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void checkPGoal3OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal3ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.GAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void checkPGoal4ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal4ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.GAME);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,1, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal5ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(3,1, TileType.BOOK);
        player.getBookshelf().setTile(3,2, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.TROPHIE);
        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal6ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(0,4, TileType.BOOK);
        player.getBookshelf().setTile(2,3, TileType.GAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(4,3, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.TROPHIE);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.CAT);
        player.getBookshelf().setTile(1,3, TileType.FRAME);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.FRAME);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.BOOK);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal7ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.PLANT);
        player.getBookshelf().setTile(2,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.BOOK);
        player.getBookshelf().setTile(5,2, TileType.CAT);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.FRAME);
        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal8ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.FRAME);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal9ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.BOOK);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(4,4, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.GAME);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,1, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.CAT);
        player.getBookshelf().setTile(4,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12SixMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12FiveMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12FourMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12ThreeMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12TwoMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12OneMatch(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal12ZeroMatches(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.FRAME);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,3, TileType.GAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void assignPointsPGoal1(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(1);

        player.getBookshelf().setTile(0,0, TileType.PLANT);
        player.getBookshelf().setTile(0,2, TileType.FRAME);
        player.getBookshelf().setTile(1,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(3,1, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.TROPHIE);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void assignPointsPGoal2(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(2);

        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.GAME);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player.getBookshelf().setTile(5,4, TileType.FRAME);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void assignPointsPGoal3(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(3);

        player.getBookshelf().setTile(1,0, TileType.FRAME);
        player.getBookshelf().setTile(1,3, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.PLANT);
        player.getBookshelf().setTile(3,1, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.TROPHIE);
        player.getBookshelf().setTile(5,0, TileType.BOOK);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void assignPointsPGoal4(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(4);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.TROPHIE);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.PLANT);
        player.getBookshelf().setTile(4,1, TileType.BOOK);
        player.getBookshelf().setTile(4,2, TileType.CAT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal5(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(5);

        player.getBookshelf().setTile(1,1, TileType.TROPHIE);
        player.getBookshelf().setTile(3,1, TileType.FRAME);
        player.getBookshelf().setTile(3,2, TileType.BOOK);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.GAME);
        player.getBookshelf().setTile(5,3, TileType.CAT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal6(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(6);

        player.getBookshelf().setTile(0,2, TileType.TROPHIE);
        player.getBookshelf().setTile(0,4, TileType.CAT);
        player.getBookshelf().setTile(2,3, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.GAME);
        player.getBookshelf().setTile(4,3, TileType.FRAME);
        player.getBookshelf().setTile(5,0, TileType.PLANT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal7(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(7);

        player.getBookshelf().setTile(0,0, TileType.CAT);
        player.getBookshelf().setTile(1,3, TileType.FRAME);
        player.getBookshelf().setTile(2,1, TileType.PLANT);
        player.getBookshelf().setTile(3,0, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,2, TileType.BOOK);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal8(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(8);

        player.getBookshelf().setTile(0,4, TileType.FRAME);
        player.getBookshelf().setTile(1,1, TileType.CAT);
        player.getBookshelf().setTile(2,2, TileType.TROPHIE);
        player.getBookshelf().setTile(3,0, TileType.PLANT);
        player.getBookshelf().setTile(4,3, TileType.BOOK);
        player.getBookshelf().setTile(5,3, TileType.GAME);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal9(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(9);

        player.getBookshelf().setTile(0,2, TileType.GAME);
        player.getBookshelf().setTile(2,2, TileType.CAT);
        player.getBookshelf().setTile(3,4, TileType.BOOK);
        player.getBookshelf().setTile(4,1, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.PLANT);
        player.getBookshelf().setTile(5,0, TileType.FRAME);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal10(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,1, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal11(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(11);

        player.getBookshelf().setTile(0,2, TileType.PLANT);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.GAME);
        player.getBookshelf().setTile(3,2, TileType.FRAME);
        player.getBookshelf().setTile(4,4, TileType.CAT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal12(){
        Game game=new Game();
        Player player = new Player(game);
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void buildPersonalGoalCard1Test() throws Exception {
        PersonalGoalCard pGoal1 = new PersonalGoalCard();
        pGoal1.setID(1);
        Tile[][] pGoal = pGoal1.buildPersonalGoalCard();
        assertEquals(TileType.PLANT, pGoal[0][0].getTileType());
        assertEquals(TileType.FRAME, pGoal[0][2].getTileType());
        assertEquals(TileType.CAT, pGoal[1][4].getTileType());
        assertEquals(TileType.BOOK, pGoal[2][3].getTileType());
        assertEquals(TileType.GAME, pGoal[3][1].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[5][2].getTileType());
    }

    @Test
    public void buildPersonalGoalCard2Test() throws Exception {
        PersonalGoalCard pGoal2 = new PersonalGoalCard();
        pGoal2.setID(2);
        Tile[][] pGoal = pGoal2.buildPersonalGoalCard();
        assertEquals(TileType.PLANT, pGoal[1][1].getTileType());
        assertEquals(TileType.CAT, pGoal[2][0].getTileType());
        assertEquals(TileType.GAME, pGoal[2][2].getTileType());
        assertEquals(TileType.BOOK, pGoal[3][4].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[4][3].getTileType());
        assertEquals(TileType.FRAME, pGoal[5][4].getTileType());
    }

    @Test
    public void buildPersonalGoalCard3Test() throws Exception {
        PersonalGoalCard pGoal3 = new PersonalGoalCard();
        pGoal3.setID(3);
        Tile[][] pGoal = pGoal3.buildPersonalGoalCard();
        assertEquals(TileType.FRAME, pGoal[1][0].getTileType());
        assertEquals(TileType.GAME, pGoal[1][3].getTileType());
        assertEquals(TileType.PLANT, pGoal[2][2].getTileType());
        assertEquals(TileType.CAT, pGoal[3][1].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[3][4].getTileType());
        assertEquals(TileType.BOOK, pGoal[5][0].getTileType());
    }

    @Test
    public void buildPersonalGoalCard4Test() throws Exception {
        PersonalGoalCard pGoal4 = new PersonalGoalCard();
        pGoal4.setID(4);
        Tile[][] pGoal = pGoal4.buildPersonalGoalCard();
        assertEquals(TileType.GAME, pGoal[0][4].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[2][0].getTileType());
        assertEquals(TileType.FRAME, pGoal[2][2].getTileType());
        assertEquals(TileType.PLANT, pGoal[3][3].getTileType());
        assertEquals(TileType.BOOK, pGoal[4][1].getTileType());
        assertEquals(TileType.CAT, pGoal[4][2].getTileType());
    }

    @Test
    public void buildPersonalGoalCard5Test() throws Exception {
        PersonalGoalCard pGoal5 = new PersonalGoalCard();
        pGoal5.setID(5);
        Tile[][] pGoal = pGoal5.buildPersonalGoalCard();
        assertEquals(TileType.TROPHIE, pGoal[1][1].getTileType());
        assertEquals(TileType.FRAME, pGoal[3][1].getTileType());
        assertEquals(TileType.BOOK, pGoal[3][2].getTileType());
        assertEquals(TileType.PLANT, pGoal[4][4].getTileType());
        assertEquals(TileType.GAME, pGoal[5][0].getTileType());
        assertEquals(TileType.CAT, pGoal[5][3].getTileType());
    }

    @Test
    public void buildPersonalGoalCard6Test() throws Exception {
        PersonalGoalCard pGoal6 = new PersonalGoalCard();
        pGoal6.setID(6);
        Tile[][] pGoal = pGoal6.buildPersonalGoalCard();
        assertEquals(TileType.TROPHIE, pGoal[0][2].getTileType());
        assertEquals(TileType.CAT, pGoal[0][4].getTileType());
        assertEquals(TileType.BOOK, pGoal[2][3].getTileType());
        assertEquals(TileType.GAME, pGoal[4][1].getTileType());
        assertEquals(TileType.FRAME, pGoal[4][3].getTileType());
        assertEquals(TileType.PLANT, pGoal[5][0].getTileType());
    }

    @Test
    public void buildPersonalGoalCard7Test() throws Exception {
        PersonalGoalCard pGoal7 = new PersonalGoalCard();
        pGoal7.setID(7);
        Tile[][] pGoal = pGoal7.buildPersonalGoalCard();
        assertEquals(TileType.CAT, pGoal[0][0].getTileType());
        assertEquals(TileType.FRAME, pGoal[1][3].getTileType());
        assertEquals(TileType.PLANT, pGoal[2][1].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[3][0].getTileType());
        assertEquals(TileType.GAME, pGoal[4][4].getTileType());
        assertEquals(TileType.BOOK, pGoal[5][2].getTileType());
    }

    @Test
    public void buildPersonalGoalCard8Test() throws Exception {
        PersonalGoalCard pGoal8 = new PersonalGoalCard();
        pGoal8.setID(8);
        Tile[][] pGoal = pGoal8.buildPersonalGoalCard();
        assertEquals(TileType.FRAME, pGoal[0][4].getTileType());
        assertEquals(TileType.CAT, pGoal[1][1].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[2][2].getTileType());
        assertEquals(TileType.PLANT, pGoal[3][0].getTileType());
        assertEquals(TileType.BOOK, pGoal[4][3].getTileType());
        assertEquals(TileType.GAME, pGoal[5][3].getTileType());
    }

    @Test
    public void buildPersonalGoalCard9Test() throws Exception {
        PersonalGoalCard pGoal9 = new PersonalGoalCard();
        pGoal9.setID(9);
        Tile[][] pGoal = pGoal9.buildPersonalGoalCard();
        assertEquals(TileType.GAME, pGoal[0][2].getTileType());
        assertEquals(TileType.CAT, pGoal[2][2].getTileType());
        assertEquals(TileType.BOOK, pGoal[3][4].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[4][1].getTileType());
        assertEquals(TileType.PLANT, pGoal[4][4].getTileType());
        assertEquals(TileType.FRAME, pGoal[5][0].getTileType());
    }

    @Test
    public void buildPersonalGoalCard10Test() throws Exception {
        PersonalGoalCard pGoal10 = new PersonalGoalCard();
        pGoal10.setID(10);
        Tile[][] pGoal = pGoal10.buildPersonalGoalCard();
        assertEquals(TileType.TROPHIE, pGoal[0][4].getTileType());
        assertEquals(TileType.GAME, pGoal[1][1].getTileType());
        assertEquals(TileType.BOOK, pGoal[2][0].getTileType());
        assertEquals(TileType.CAT, pGoal[3][3].getTileType());
        assertEquals(TileType.FRAME, pGoal[4][2].getTileType());
        assertEquals(TileType.PLANT, pGoal[5][3].getTileType());
    }

    @Test
    public void buildPersonalGoalCard11Test() throws Exception {
        PersonalGoalCard pGoal11 = new PersonalGoalCard();
        pGoal11.setID(11);
        Tile[][] pGoal = pGoal11.buildPersonalGoalCard();
        assertEquals(TileType.PLANT, pGoal[0][2].getTileType());
        assertEquals(TileType.BOOK, pGoal[1][1].getTileType());
        assertEquals(TileType.GAME, pGoal[2][0].getTileType());
        assertEquals(TileType.FRAME, pGoal[3][2].getTileType());
        assertEquals(TileType.CAT, pGoal[4][4].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[5][3].getTileType());
    }

    @Test
    public void buildPersonalGoalCard12Test() throws Exception {
        PersonalGoalCard pGoal12 = new PersonalGoalCard();
        pGoal12.setID(12);
        Tile[][] pGoal = pGoal12.buildPersonalGoalCard();
        assertEquals(TileType.BOOK, pGoal[0][2].getTileType());
        assertEquals(TileType.PLANT, pGoal[1][1].getTileType());
        assertEquals(TileType.FRAME, pGoal[2][2].getTileType());
        assertEquals(TileType.TROPHIE, pGoal[3][3].getTileType());
        assertEquals(TileType.GAME, pGoal[4][4].getTileType());
        assertEquals(TileType.CAT, pGoal[5][0].getTileType());
    }

    @Test
    public void NullPlayerException(){
        Player player = null;
        assertThrows(Exception.class, () -> {
            player.setPersonalGoalCard(1);
            player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID());
        });

    }

}