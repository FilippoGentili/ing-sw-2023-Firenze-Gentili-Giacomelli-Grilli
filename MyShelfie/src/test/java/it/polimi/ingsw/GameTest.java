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
        assertTrue(player2.getState() instanceof Start);
        assertTrue(player1.getState() instanceof End);
        gameLoop();
        assertEquals(player1, getCurrentPlayer());
        assertTrue(player1.getState() instanceof Start);
        assertTrue(player2.getState() instanceof End);
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
        assertTrue(player2.getState() instanceof Start);
        assertTrue(player3.getState() instanceof End);
        assertTrue(player1.getState() instanceof End);
        gameLoop();
        assertEquals(player3, getCurrentPlayer());
        assertTrue(player3.getState() instanceof Start);
        assertTrue(player1.getState() instanceof End);
        assertTrue(player2.getState() instanceof End);
        gameLoop();
        assertEquals(player1, getCurrentPlayer());
        assertTrue(player1.getState() instanceof Start);
        assertTrue(player2.getState() instanceof End);
        assertTrue(player3.getState() instanceof End);
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
        assertTrue(player2.getState() instanceof Start);
        assertTrue(player3.getState() instanceof End);
        assertTrue(player4.getState() instanceof End);
        assertTrue(player1.getState() instanceof End);
        gameLoop();
        assertEquals(player3, getCurrentPlayer());
        assertTrue(player3.getState() instanceof Start);
        assertTrue(player4.getState() instanceof End);
        assertTrue(player1.getState() instanceof End);
        assertTrue(player2.getState() instanceof End);
        gameLoop();
        assertEquals(player4, getCurrentPlayer());
        assertTrue(player4.getState() instanceof Start);
        assertTrue(player1.getState() instanceof End);
        assertTrue(player2.getState() instanceof End);
        assertTrue(player3.getState() instanceof End);
        gameLoop();
        assertEquals(player1, getCurrentPlayer());
        assertTrue(player1.getState() instanceof Start);
        assertTrue(player2.getState() instanceof End);
        assertTrue(player3.getState() instanceof End);
        assertTrue(player4.getState() instanceof End);
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
        setCurrentPlayer(player1);
        getCurrentPlayer();
        assertTrue(getCurrentPlayer() == player1 );
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
        setCurrentPlayer(player1);
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
        setCurrentPlayer(player1);
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
        setCurrentPlayer(player1);
        assertEquals(getNextPlayer(), player2);
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
        setCurrentPlayer(player1);
        assertEquals(getNextPlayer(), player2);
        assertEquals(getNextPlayer(), player3);
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
        setCurrentPlayer(player1);
        assertEquals(getNextPlayer(), player2);
        assertEquals(getNextPlayer(), player3);
        assertEquals(getNextPlayer(), player4);
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
        game.initializeLivingRoom();
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
        game.initializeLivingRoom();
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
        game.initializeLivingRoom();
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
    }

    @Test
    public void assignPointsTest2Players() {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        PersonalGoalCard personalGoal1 = new PersonalGoalCard();
        PersonalGoalCard personalGoal2 = new PersonalGoalCard();
        personalGoal1.setID(1);
        personalGoal1.setPlayer(player1);
        personalGoal2.setID(2);
        personalGoal2.setPlayer(player2);
        player1.getBookshelf().setTile(0,0, TileType.PLANT);
        player1.getBookshelf().setTile(0,2, TileType.FRAME);
        player1.getBookshelf().setTile(1,4, TileType.CAT);
        player1.getBookshelf().setTile(2,3, TileType.BOOK);
        player1.getBookshelf().setTile(3,1, TileType.GAME);
        player1.getBookshelf().setTile(5,2, TileType.TROPHIE);

        player2.getBookshelf().setTile(1,1, TileType.PLANT);
        player2.getBookshelf().setTile(2,0, TileType.CAT);
        player2.getBookshelf().setTile(2,2, TileType.GAME);
        player2.getBookshelf().setTile(3,4, TileType.BOOK);
        player2.getBookshelf().setTile(4,3, TileType.TROPHIE);
        player2.getBookshelf().setTile(5,4, TileType.FRAME);
        player1.setScore(10);
        player2.setScore(20);
        game.assignPoints(getPlayers());
        assertEquals(player1.getScore(),  10 + player1.getPersonalGoalCard().assignPoints(player1.getPersonalGoalCard().getID()));
        assertEquals(player2.getScore(),  20 + player2.getPersonalGoalCard().assignPoints(player2.getPersonalGoalCard().getID()));
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
        game.setPersonalGoalCard();
        game.initializeLivingRoom();
        game.pickCommonGoalCards();
        player1.setScore(10);
        player2.setScore(20);
        player3.setScore(30);
        game.assignPoints(getPlayers());
        assertEquals(player1.getScore(), 10 + player1.getPersonalGoalCard().assignPoints(player1.getPersonalGoalCard().getID()));
        assertEquals(player2.getScore(), 20 + player2.getPersonalGoalCard().assignPoints(player2.getPersonalGoalCard().getID()));
        assertEquals(player3.getScore(), 30 + player2.getPersonalGoalCard().assignPoints(player3.getPersonalGoalCard().getID()));
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
        game.setPersonalGoalCard();
        game.initializeLivingRoom();
        game.pickCommonGoalCards();
        player1.setScore(10);
        player2.setScore(20);
        player1.setScore(30);
        player2.setScore(40);
        game.assignPoints(getPlayers());
        assertEquals(player1.getScore(), 10 + player1.getPersonalGoalCard().assignPoints(player1.getPersonalGoalCard().getID()));
        assertEquals(player2.getScore(), 20 + player2.getPersonalGoalCard().assignPoints(player2.getPersonalGoalCard().getID()));
        assertEquals(player3.getScore(), 30 + player3.getPersonalGoalCard().assignPoints(player3.getPersonalGoalCard().getID()));
        assertEquals(player4.getScore(), 40 + player4.getPersonalGoalCard().assignPoints(player4.getPersonalGoalCard().getID()));
    }

    @Test
    public void getCommonGoal1Test(){
        Game game = new Game();
        game.pickCommonGoalCards();
        CommonGoalCard commonGoal1 = getCommonGoal1();
        assertNotNull(commonGoal1);

    }

    @Test
    public void getCommonGoal2Test(){
        Game game = new Game();
        game.pickCommonGoalCards();
        CommonGoalCard commonGoal2 = getCommonGoal2();
        assertNotNull(commonGoal2);
    }

    @Test
    public void getLivingRoomTest2Players(){
        Game game = new Game();
        LivingRoom livingRoom = getLivingRoom();
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        game.initializeLivingRoom();
        assertNotNull(livingRoom);
        assertEquals(livingRoom, LivingRoom.getInstance());
    }

    @Test
    public void getLivingRoomTest3Players(){
        Game game = new Game();
        LivingRoom livingRoom = getLivingRoom();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        game.initializeLivingRoom();
        assertNotNull(livingRoom);
        assertEquals(livingRoom, LivingRoom.getInstance());
    }

    @Test
    public void getLivingRoomTest4Players(){
        Game game = new Game();
        LivingRoom livingRoom = game.getLivingRoom();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        getPlayers().add(player1);
        getPlayers().add(player2);
        getPlayers().add(player3);
        getPlayers().add(player4);
        game.initializeLivingRoom();
        assertNotNull(livingRoom);
        assertEquals(livingRoom, LivingRoom.getInstance());
    }

}