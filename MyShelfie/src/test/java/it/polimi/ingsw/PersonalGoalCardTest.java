package it.polimi.ingsw;

/*import it.polimi.ingsw.Model.PersonalGoalCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.TileType;
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(6, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10FiveMatches(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(5, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10FourMatches(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(4, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10ThreeMatches(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(3, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10TwoMatches(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(2, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10OneMatch(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(1, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal10ZeroMatches(){
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.GAME);
        player.getBookshelf().setTile(1,1, TileType.BOOK);
        player.getBookshelf().setTile(2,0, TileType.CAT);
        player.getBookshelf().setTile(3,3, TileType.FRAME);
        player.getBookshelf().setTile(4,2, TileType.PLANT);
        player.getBookshelf().setTile(5,3, TileType.TROPHIE);

        assertEquals(0, player.getPersonalGoalCard().check(player.getPersonalGoalCard().getID()));
    }

    @Test
    public void checkPGoal11SixMatches(){
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
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
        Player player = new Player();
        player.setPersonalGoalCard(10);

        player.getBookshelf().setTile(0,4, TileType.TROPHIE);
        player.getBookshelf().setTile(1,1, TileType.GAME);
        player.getBookshelf().setTile(2,0, TileType.BOOK);
        player.getBookshelf().setTile(3,3, TileType.CAT);
        player.getBookshelf().setTile(4,2, TileType.FRAME);
        player.getBookshelf().setTile(5,3, TileType.PLANT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
    @Test
    public void assignPointsPGoal11(){
        Player player = new Player();
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
        Player player = new Player();
        player.setPersonalGoalCard(12);

        player.getBookshelf().setTile(0,2, TileType.BOOK);
        player.getBookshelf().setTile(1,1, TileType.PLANT);
        player.getBookshelf().setTile(2,2, TileType.FRAME);
        player.getBookshelf().setTile(3,3, TileType.TROPHIE);
        player.getBookshelf().setTile(4,4, TileType.GAME);
        player.getBookshelf().setTile(5,0, TileType.CAT);

        assertEquals(12, player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID()));
    }
}*/