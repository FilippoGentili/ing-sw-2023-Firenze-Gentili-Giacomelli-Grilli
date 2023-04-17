package it.polimi.ingsw;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static it.polimi.ingsw.Game.*;
import static org.junit.Assert.*;

public class GameTest {
    private List<Player> listOfPlayers;

    @Test
    public void gameLoopTest2Players(){
        Game game = new Game();
        Start Start = new Start();
        End End = new End();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        setCurrentPlayer(player1);
        player1.setState(Start);
        player2.setState(End);
        gameLoop();
        assertEquals(player2, getCurrentPlayer());
        assertEquals(player2.getState(),Start);
    }

    @Test
    public void gameLoopTest3Players(){
        Game game = new Game();
        Start Start = new Start();
        End End = new End();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        setCurrentPlayer(player1);
        player1.setState(Start);
        player2.setState(End);
        player3.setState(End);
        gameLoop();
        assertEquals(player2, getCurrentPlayer());
        assertEquals(player2.getState(),Start);
        assertEquals(player3.getState(),End);


    }

    @Test
    public void gameLoopTest4Players(){
        Game game = new Game();
        Start Start = new Start();
        End End = new End();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        setCurrentPlayer(player1);
        player1.setState(Start);
        player2.setState(End);
        player3.setState(End);
        player4.setState(End);
        gameLoop();
        assertEquals(player2, getCurrentPlayer());
        assertEquals(player2.getState(),Start);
        assertEquals(player3.getState(),End);
        assertEquals(player4.getState(),End);

    }

    @Test
    public void pickFirstPlayerTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        pickFirstPlayer();
        assertTrue(pickFirstPlayer() == player1 || pickFirstPlayer() == player2);

    }

    @Test
    public void pickFirstPlayerTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        pickFirstPlayer();
        assertTrue(pickFirstPlayer() == player1 || pickFirstPlayer() == player2 || pickFirstPlayer() == player3);
    }

    @Test
    public void pickFirstPlayerTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        pickFirstPlayer();
        assertTrue(pickFirstPlayer() == player1 || pickFirstPlayer() == player2 || pickFirstPlayer() == player3 || pickFirstPlayer() == player4);
    }

    @Test
    public void getCurrentPlayerTest2Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getCurrentPlayer();
        assertTrue(getCurrentPlayer() == player1);
    }

    @Test
    public void getCurrentPlayerTest3Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        Player currentPlayer = getCurrentPlayer();
        assertTrue(currentPlayer == player1 || currentPlayer == player2 || currentPlayer == player3);
    }

    @Test
    public void getCurrentPlayerTest4Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        Player currentPlayer = getCurrentPlayer();
        assertTrue(currentPlayer == player1 || currentPlayer == player2 || currentPlayer == player3 || currentPlayer == player4);
    }

    @Test
    public void getNextPlayerTest2Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        setNextPlayer(player2);
        assertEquals(getNextPlayer(), player2);
        setNextPlayer(player1);
        assertEquals(getNextPlayer(), player1);

    }

    @Test
    public void getNextPlayerTest3Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        setNextPlayer(player2);
        assertEquals(getNextPlayer(), player2);
        setNextPlayer(player3);
        assertEquals(getNextPlayer(), player3);
        setNextPlayer(player1);
        assertEquals(getNextPlayer(), player1);
    }

    @Test
    public void getNextPlayerTest4Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        setNextPlayer(player2);
        assertEquals(getNextPlayer(), player2);
        setNextPlayer(player3);
        assertEquals(getNextPlayer(), player3);
        setNextPlayer(player4);
        assertEquals(getNextPlayer(), player4);
        setNextPlayer(player1);
        assertEquals(getNextPlayer(), player1);
    }

    @Test
    public void getWinnerTest2Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        player1.setScore(30);
        player2.setScore(20);
        game.setWinner(player1);
        assertEquals(getWinner(), player1);
    }

    @Test
    public void getWinnerTest3Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        player1.setScore(30);
        player2.setScore(20);
        player3.setScore(15);
        game.setWinner(player1);
        assertEquals(getWinner(), player1);

    }

    @Test
    public void getWinnerTest4Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        player1.setScore(30);
        player2.setScore(20);
        player3.setScore(15);
        player4.setScore(25);
        game.setWinner(player1);
        assertEquals(getWinner(), player1);

    }

    @Test
    public void getPlayersTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
    }

    @Test
    public void getPlayersTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
    }

    @Test
    public void getPlayersTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
        assertTrue(getPlayers().contains(player4));
    }

    @Test
    public void addPlayerTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(getPlayers().size(), 2);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));

    }

    @Test
    public void addPlayerTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        assertEquals(getPlayers().size(), 3);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
    }

    @Test
    public void addPlayerTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        assertEquals(getPlayers().size(), 4);
        assertTrue(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
        assertTrue(getPlayers().contains(player4));
    }

    @Test
    public void removePlayerTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        game.removePlayer(player1);
        assertEquals(getPlayers().size(), 1);
        assertFalse(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
    }

    @Test
    public void removePlayerTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        game.removePlayer(player1);
        assertEquals(getPlayers().size(), 2);
        assertFalse(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
    }

    @Test
    public void removePlayerTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        game.removePlayer(player1);
        assertEquals(getPlayers().size(), 3);
        assertFalse(getPlayers().contains(player1));
        assertTrue(getPlayers().contains(player2));
        assertTrue(getPlayers().contains(player3));
        assertTrue(getPlayers().contains(player4));
    }

    @Test
    public void numberOfTilesTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        int num = game.numberOfTiles();
        assertEquals(29, num);
    }

    @Test
    public void numberOfTilesTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        int num = game.numberOfTiles();
        assertEquals(37, num);
    }

    @Test
    public void numberOfTilesTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        int num = game.numberOfTiles();
        assertEquals(45, num);
    }

    @Test
    public void initializeLivingRoomTest2Players(){
        Game game = new Game();
        LivingRoom livingRoom = LivingRoom.getInstance();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.validCell(i, j)){
                    validTilesCount++;
                }
            }
        }

        assertEquals(29, validTilesCount);

    }

    @Test
    public void initializeLivingRoomTest3Players(){
        Game game = new Game();
        LivingRoom livingRoom = LivingRoom.getInstance();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.validCell(i, j)){
                    validTilesCount++;
                }
            }
        }

        assertEquals(37, validTilesCount);

    }

    @Test
    public void initializeLivingRoomTest4Players(){
        Game game = new Game();
        LivingRoom livingRoom = LivingRoom.getInstance();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.validCell(i, j)){
                    validTilesCount++;
                }
            }
        }

        assertEquals(45, validTilesCount);

    }

    @Test
    public void pickCommonGoalCardsTest() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        game.pickCommonGoalCards();
        getCommonGoal1();
        getCommonGoal2();
        assertNotNull(getCommonGoal1());
        assertNotNull(getCommonGoal2());
        assertNotEquals(getCommonGoal1(), getCommonGoal2());
    }

    @Test
    public void  setPersonalGoalCardTest2Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        game.setPersonalGoalCard();
        for (Player player : getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void  setPersonalGoalCardTest3Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        game.setPersonalGoalCard();
        for (Player player : getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void setPersonalGoalCardTest4Players(){
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        game.setPersonalGoalCard();
        for (Player player : getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void endGameTriggerTest2Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());
    }

    @Test
    public void endGameTriggerTest3Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());
    }

    @Test
    public void endGameTriggerTest4Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());
    }

    @Test
    public void assignPointsTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        for (Player player : getPlayers()){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) getPlayers());
            assertEquals(player.getScore(), pre+tot);
        }
    }

    @Test
    public void assignPointsTest3Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        for (Player player : getPlayers()){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) getPlayers());
            assertEquals(player.getScore(), pre+tot);
        }

    }

    @Test
    public void assignPointsTest4Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        for (Player player : getPlayers()){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) getPlayers());
            assertEquals(player.getScore(), pre+tot);
        }
    }

    @Test
    public void getCommonGoal1Test(){
        Game game = new Game();
        CommonGoalCard commonGoalCard = new CommonGoalCard() {
            @Override
            public boolean check(Bookshelf bookshelf) {
                return false;
            }
        };
        getCommonGoal1();
        assertEquals(commonGoalCard,getCommonGoal1());
    }

    @Test
    public void getCommonGoal2Test(){
        Game game = new Game();
        assertNotNull(getCommonGoal2());
    }

    @Test
    public void getLivingRoomTest(){
        Game game = new Game();
        LivingRoom livingRoom = new LivingRoom();
        getLivingRoom();
        assertEquals(livingRoom, getLivingRoom());
    }

}