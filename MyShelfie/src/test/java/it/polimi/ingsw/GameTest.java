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
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        Player currentPlayer = player1;
        player1.setState(Start);
        player2.setState(End);
        game.gameLoop();
        assertEquals(player2, currentPlayer);
        assertEquals(player2.getState(),Start);

    }

    @Test
    public void gameLoopTest3Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        Player currentPlayer = player1;
        player1.setState(Start);
        player2.setState(End);
        player3.setState(End);
        game.gameLoop();
        assertEquals(player2, currentPlayer);
        assertEquals(player2.getState(),Start);
        assertEquals(player3.getState(),End);


    }

    @Test
    public void gameLoopTest4Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        Player currentPlayer = player1;
        player1.setState(Start);
        player2.setState(End);
        player3.setState(End);
        player4.setState(End);
        game.gameLoop();
        assertEquals(player2, currentPlayer);
        assertEquals(player2.getState(),Start);
        assertEquals(player3.getState(),End);
        assertEquals(player4.getState(),End);

    }

    @Test
    public void pickFirstPlayerTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        Player firstPlayer = game.pickFirstPlayer();
        assertTrue(firstPlayer == player1 || firstPlayer == player2);

    }

    @Test
    public void pickFirstPlayerTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        Player firstPlayer = game.pickFirstPlayer();
        assertTrue(firstPlayer == player1 || firstPlayer == player2 || firstPlayer == player3);
    }

    @Test
    public void pickFirstPlayerTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        Player firstPlayer = game.pickFirstPlayer();
        assertTrue(firstPlayer == player1 || firstPlayer == player2 || firstPlayer == player3 || firstPlayer == player4);
    }

    @Test
    public void getCurrentPlayerTest2Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        Player currentPlayer = game.getCurrentPlayer();
        assertTrue(currentPlayer == player1 || currentPlayer == player2);
    }

    @Test
    public void getCurrentPlayerTest3Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        Player currentPlayer = game.getCurrentPlayer();
        assertTrue(currentPlayer == player1 || currentPlayer == player2 || currentPlayer == player3);
    }

    @Test
    public void getCurrentPlayerTest4Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        Player currentPlayer = game.getCurrentPlayer();
        assertTrue(currentPlayer == player1 || currentPlayer == player2 || currentPlayer == player3 || currentPlayer == player4);
    }

    @Test
    public void getNextPlayerTest2Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        Player nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player2);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player1);

    }

    @Test
    public void getNextPlayerTest3Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        Player nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player2);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player3);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player1);
    }

    @Test
    public void getNextPlayerTest4Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        Player nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player2);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player3);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player4);
        nextPlayer = game.getNextPlayer();
        assertEquals(nextPlayer, player1);
    }

    @Test
    public void getWinnerTest2Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        player1.setScore(30);
        player2.setScore(20);
        Player winner = game.getWinner();
        assertEquals(winner, player1);
    }

    @Test
    public void getWinnerTest3Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        player1.setScore(30);
        player2.setScore(20);
        player3.setScore(15);
        Player winner = game.getWinner();
        assertEquals(winner, player1);

    }

    @Test
    public void getWinnerTest4Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        player1.setScore(30);
        player2.setScore(20);
        player3.setScore(15);
        player4.setScore(25);
        Player winner = game.getWinner();
        assertEquals(winner, player1);

    }

    @Test
    public void getPlayersTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        ArrayList<Player> List = game.getPlayers();
        assertTrue(List.contains(player1));
        assertTrue(List.contains(player2));
    }

    @Test
    public void getPlayersTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        ArrayList<Player> List = game.getPlayers();
        assertTrue(List.contains(player1));
        assertTrue(List.contains(player2));
        assertTrue(List.contains(player3));
    }

    @Test
    public void getPlayersTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        ArrayList<Player> List = game.getPlayers();
        assertTrue(List.contains(player1));
        assertTrue(List.contains(player2));
        assertTrue(List.contains(player3));
        assertTrue(List.contains(player4));
    }

    @Test
    public void addPlayerTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(listOfPlayers.size(), 2);
        assertTrue(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));

    }

    @Test
    public void addPlayerTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        assertEquals(listOfPlayers.size(), 3);
        assertTrue(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));
        assertTrue(listOfPlayers.contains(player3));
    }

    @Test
    public void addPlayerTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        assertEquals(listOfPlayers.size(), 4);
        assertTrue(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));
        assertTrue(listOfPlayers.contains(player3));
        assertTrue(listOfPlayers.contains(player4));
    }

    @Test
    public void removePlayerTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        game.removePlayer(player1);
        assertEquals(listOfPlayers.size(), 1);
        assertFalse(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));
    }

    @Test
    public void removePlayerTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        game.removePlayer(player1);
        assertEquals(listOfPlayers.size(), 2);
        assertFalse(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));
        assertTrue(listOfPlayers.contains(player3));
    }

    @Test
    public void removePlayerTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        game.removePlayer(player1);
        assertEquals(listOfPlayers.size(), 3);
        assertFalse(listOfPlayers.contains(player1));
        assertTrue(listOfPlayers.contains(player2));
        assertTrue(listOfPlayers.contains(player3));
        assertTrue(listOfPlayers.contains(player4));
    }

    @Test
    public void numberOfTilesTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        int num = game.numberOfTiles();
        assertEquals(29, num);
    }

    @Test
    public void numberOfTilesTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        int num = game.numberOfTiles();
        assertEquals(37, num);
    }

    @Test
    public void numberOfTilesTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        int num = game.numberOfTiles();
        assertEquals(45, num);
    }

    @Test
    public void initializeLivingRoomTest2Players(){
        Game game = new Game();
        LivingRoom livingRoom = LivingRoom.getInstance();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.valid(i, j)){
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
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.valid(i, j)){
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
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        int validTilesCount = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(livingRoom.valid(i, j)){
                    validTilesCount++;
                }
            }
        }

        assertEquals(45, validTilesCount);

    }

    @Test
    public void pickCommonGoalCardsTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        game.pickCommonGoalCards();
        CommonGoalCard commonGoal1 = game.getCommonGoal1();
        CommonGoalCard commonGoal2 = game.getCommonGoal2();
        assertNotNull(commonGoal1);
        assertNotNull(commonGoal2);
        assertNotEquals(commonGoal1, commonGoal2);
    }

    @Test
    public void pickCommonGoalCardsTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        game.pickCommonGoalCards();
        CommonGoalCard commonGoal1 = game.getCommonGoal1();
        CommonGoalCard commonGoal2 = game.getCommonGoal2();
        assertNotNull(commonGoal1);
        assertNotNull(commonGoal2);
        assertNotEquals(commonGoal1, commonGoal2);
    }

    @Test
    public void pickCommonGoalCardsTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        game.pickCommonGoalCards();
        CommonGoalCard commonGoal1 = game.getCommonGoal1();
        CommonGoalCard commonGoal2 = game.getCommonGoal2();
        assertNotNull(commonGoal1);
        assertNotNull(commonGoal2);
        assertNotEquals(commonGoal1, commonGoal2);
    }

    @Test
    public void  setPersonalGoalCardTest2Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        game.setPersonalGoalCard();
        for (Player player : game.getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void  setPersonalGoalCardTest3Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        game.setPersonalGoalCard();
        for (Player player : game.getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void setPersonalGoalCardTest4Players(){
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        game.setPersonalGoalCard();
        for (Player player : game.getPlayers()) {
            int card = player.getPersonalGoalCard().getID();
            assertTrue(card > 0 && card <= 12);
        }
    }

    @Test
    public void endGameTriggerTest2Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());

)

    }

    @Test
    public void endGameTriggerTest3Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());
    }

    @Test
    public void endGameTriggerTest4Players() {
        Game game = new Game();
        Bookshelf bookshelf = new Bookshelf();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        int score = player1.getScore();
        Game.endGameTrigger(bookshelf, player1);
        assertEquals(score + 1, player1.getScore());
        assertEquals(Game.pickFirstPlayer(), Game.getCurrentPlayer());
    }

    @Test
    public void assignPointsTest2Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        for (Player player : listOfPlayers){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) listOfPlayers);
            assertEquals(player.getScore(), pre+tot);
        }
    }

    @Test
    public void assignPointsTest3Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        for (Player player : listOfPlayers){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) listOfPlayers);
            assertEquals(player.getScore(), pre+tot);
        }

    }

    @Test
    public void assignPointsTest4Players() {
        Game game = new Game();
        listOfPlayers = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);
        listOfPlayers.add(player3);
        listOfPlayers.add(player4);
        for (Player player : listOfPlayers){
            int pre = player.getScore();
            int tot = player.getPersonalGoalCard().assignPoints(player.getPersonalGoalCard().getID());
            game.assignPoints((ArrayList<Player>) listOfPlayers);
            assertEquals(player.getScore(), pre+tot);
        }
    }

    @Test
    public void getCommonGoal1Test(){
        Game game = new Game();
        CommonGoalCard common1 = game.getCommonGoal1();
        assertNotNull(common1);
    }

    @Test
    public void getCommonGoal2Test(){
        Game game = new Game();
        CommonGoalCard common2 = game.getCommonGoal2();
        assertNotNull(common2);
    }

    @Test
    public void getLivingRoomTest(){
        Game game = new Game();
        LivingRoom livingRoom = game.getLivingRoom();
        assertNotNull(livingRoom);
    }

}