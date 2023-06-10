package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.ChatMessage;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.Scene.*;
import it.polimi.ingsw.View.View;
import javafx.application.Platform;

import java.util.ArrayList;

public class Gui extends ViewObservable implements View {
    private static final String ERROR = "Login Error";
    private static final String END = "GAME OVER";
    private static final String INFO = "Info";

    /**
     * This method is used to show a message
     * @param message is the message to show
     */
    @Override
    public void showMessage(String message){
       // Platform.runLater(() -> GuiController.showBanner(INFO, message));
        //per ora lo lasciamo commentato, perchè ogni messsaggio che manda il server è un banner nella gui
    }

    /**
     * This method is used to get the login result after the player has chosen the nickname
     * @param validNickname is true if the nickname is valid, false otherwise
     * @param connection is true if the connection is valid, false otherwise
     * @param nickname is the nickname chosen by the player
     */
    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname){
        if (!validNickname || !connection) {
            if (!validNickname && connection) {
                Platform.runLater(() -> {
                    GuiController.showBanner(ERROR, "Nickname already taken");
                    GuiController.changeScene("loginScene.fxml", observers);
                });
            } else {
                Platform.runLater(() -> {
                    GuiController.showBanner(ERROR, "Server Error");
                    GuiController.changeScene("startScene.fxml", observers);
                });
            }
        }    }

    /**
     * This method is used to change scene where the player can choose the nickname
     */
    @Override
    public void nicknameRequest(){
        Platform.runLater(() -> GuiController.changeScene( "loginScene.fxml",observers));
    }


    /**
     * This method is used to change scene where the player can choose the max number of players in the game
     */
    @Override
    public void askNumberOfPlayers() {
        PlayerSelectionSceneController playerSelectionSceneController = new PlayerSelectionSceneController();
        playerSelectionSceneController.addAllObserver(observers);
        Platform.runLater(() -> GuiController.changeScene( "playerSelectionScene.fxml",playerSelectionSceneController));
    }

    @Override
    public void startChat() {

    }

    @Override
    public void showChatMessage(ChatMessage message) {

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
     * This method is used to change scene and display the scoreboard
     */
    @Override
    public void showScoreboard(ArrayList<Player> scoreboard) {
        //Platform.runLater(() -> GuiController.changeScene( "endScene.fxml",observers));
    }

    /**
     * This method is used to show the message that a player has disconnected
     * @param nickname is the nickname of the player that has disconnected
     */
    @Override
    public void someoneDisconnected(String nickname) {
        Platform.runLater(() -> {
            GuiController.showBanner(END, "The player " + nickname + " disconnected");
            GuiController.changeScene("startScene.fxml", observers);
        });
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) {
       // GameSceneController gameSceneController = getGameSceneController();
       // Platform.runLater(() -> gameSceneController.updateLivingRoom(livingRoom));

    }

    @Override
    public void showBookshelf(Player player) {
       // GameSceneController gameSceneController = getGameSceneController();
       // Platform.runLater(() -> gameSceneController.updateBookShelf(player));
    }

    @Override
    public void showCommonGoalCards(Game game) {
       // GameSceneController gameSceneController = getGameSceneController();
       // Platform.runLater(() -> gameSceneController.setCommonGoalCards(game));
    }

    @Override
    public void showPersonalGoalCard(Player player) {
      // GameSceneController gameSceneController = getGameSceneController();
      // Platform.runLater(() -> gameSceneController.setPersonalGoalCard(player));
    }

    @Override
    public void updateGameState(Player player, Game game) {
      /*  showCommonGoalCards(game);
        showPersonalGoalCard(player);
        showLivingRoom(game.getLivingRoom());
        for(Player p : game.getPlayers()) {
            showBookshelf(p);
        }*/
    }

    @Override
    public void showGameStarted(Game game) {
        GameSceneController gameSceneController;

        try {
            gameSceneController = (GameSceneController) GuiController.getCurrentController();
        } catch (ClassCastException e) {
            gameSceneController = new GameSceneController();
            gameSceneController.addAllObserver(observers);
            GameSceneController gameSceneController1 = gameSceneController;
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
     */
    @Override
    public void showWinner(String winner) {
        EndSceneController endSceneController;

        try {
            endSceneController = (EndSceneController) GuiController.getCurrentController();
            endSceneController.setWinner(winner);
        } catch (ClassCastException e) {
            endSceneController = new EndSceneController();
            endSceneController.addAllObserver(observers);
            endSceneController.setWinner(winner);
            EndSceneController endSceneController1 = endSceneController;
            Platform.runLater(() -> GuiController.changeScene("endScene.fxml",endSceneController1));
        }
    }

    @Override
    public void handleDisconnection(String nickname) {

    }
}
