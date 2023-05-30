package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.Scene.*;
import it.polimi.ingsw.View.View;
import javafx.application.Platform;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class Gui extends ViewObservable implements View {
    private static final String ERROR = "Login Error";
    private static final String END = "GAME OVER";
    @Override
    public void showMessage(String message){

    }

    /**
     * This method is used to get the login result after the player has chosen the nickname
     * @param validNickname
     * @param connection
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname){
        if (!validNickname || !connection) {
            if (!validNickname && connection) {
                Platform.runLater(() -> GuiController.showBanner(ERROR, "Nickname already taken"));
            } else {
                Platform.runLater(() -> {
                    GuiController.showBanner(ERROR, "Error connecting to server");
                    GuiController.changeScene("startScene.fxml", observers);
                });
            }
        }
    }

    /**
     * This method is used to ask the nickname to the player
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void nicknameRequest(){
        Platform.runLater(() -> GuiController.changeScene( "loginScene.fxml",observers));
    }

    /**
     * This method is used to ask the max number of players in the game
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void askNumberOfPlayers() {
        Platform.runLater(() -> GuiController.changeScene( "playerSelectionScene.fxml",observers));
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) {

    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) {

    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) {

    }

    /**
     * This method is used to show the list of players in the game
     * @param listOfPlayers is the list of players in the game
     * @param player is the player that is playing
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void showScoreboard(ArrayList<Player> scoreboard) {

    }

    /**
     * This method is used to show the message that a player has disconnected
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void someoneDisconnected(String nickname) {
        Platform.runLater(() -> {
            GuiController.showBanner(END, "The player" + nickname + " disconnected");
            GuiController.changeScene("startScene.fxml", observers);
        });
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) {
        GameSceneController gameSceneController = getGameSceneController();
        Platform.runLater(() -> gameSceneController.updateLivingRoom(livingRoom));

    }

    @Override
    public void showBookshelf(Player player) {
        GameSceneController gameSceneController = getGameSceneController();
        Platform.runLater(() -> gameSceneController.updateBookShelf(player));
    }

    @Override
    public void showCommonGoalCards(Game game) {
        GameSceneController gameSceneController = getGameSceneController();
        Platform.runLater(() -> gameSceneController.setCommonGoalCards(game));
    }

    @Override
    public void showPersonalGoalCard(Player player) {
        GameSceneController gameSceneController = getGameSceneController();
        Platform.runLater(() -> gameSceneController.setPersonalGoalCard(player));
    }

    @Override
    public void updateGameState(Player player, Game game) {

    }

    @Override
    public void showGameStarted(Game game) {
        GameSceneController gameSceneController;

        try {
            gameSceneController = (GameSceneController) GuiController.getCurrentController();
            gameSceneController.setUpGame(game);
        } catch (ClassCastException e) {
            gameSceneController = new GameSceneController();
            gameSceneController.addAllObserver(observers);
            GameSceneController gameSceneController1 = gameSceneController;
            gameSceneController.setUpGame(game);
            Platform.runLater(() -> GuiController.changeScene("gameScene.fxml",gameSceneController1));
        }
    }

    public  GameSceneController getGameSceneController(){
        GameSceneController gameSceneController;
        try {
            gameSceneController = (GameSceneController) GuiController.getCurrentController();
        } catch (ClassCastException e) {
            gameSceneController = new GameSceneController();
            gameSceneController.addAllObserver(observers);
            GameSceneController gameSceneController1 = gameSceneController;
            Platform.runLater(() -> GuiController.changeScene( "gameScene.fxml", gameSceneController1));
        }
        return gameSceneController;
    }

    /**
     * This method is used to show the waiting room
     * @param maxPlayers is the max number of players in the game
     * @param numOfPlayersConnected is the number of players connected
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) {

        WaitingRoomSceneController waitingRoomSceneController;

        try {
            waitingRoomSceneController = (WaitingRoomSceneController) GuiController.getCurrentController();
            waitingRoomSceneController.setMaxPlayers(maxPlayers);
            waitingRoomSceneController.setNumOfPlayersConnected(numOfPlayersConnected);
            Platform.runLater(waitingRoomSceneController::startAnimationTimer);
        } catch (ClassCastException e) {
            waitingRoomSceneController = new WaitingRoomSceneController();
            waitingRoomSceneController.addAllObserver(observers);
            waitingRoomSceneController.setMaxPlayers(maxPlayers);
            waitingRoomSceneController.setNumOfPlayersConnected(numOfPlayersConnected);
            WaitingRoomSceneController waitingRoomSceneController1 = waitingRoomSceneController;
            Platform.runLater(waitingRoomSceneController::startAnimationTimer);
            Platform.runLater(() -> GuiController.changeScene("waitingRoomScene.fxml",waitingRoomSceneController1));
        }
    }

    /**
     * This method is used to show the end scene of the game
     * @param winner is the player that won the game
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void showWinner(String winner) {
        Platform.runLater(() -> {
            GuiController.showEnd(winner);
            GuiController.showBanner(END, "The winner is " + winner);
            GuiController.changeScene("endScene.fxml", observers);
        });
    }
}
