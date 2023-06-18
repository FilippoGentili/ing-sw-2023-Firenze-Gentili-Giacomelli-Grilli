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

    private GameSceneController gameSceneController;

    /**
     * This method is used to show a message
     * @param message is the message to show
     */
    @Override
    public void showMessage(String message){
        if(gameSceneController != null)
            gameSceneController.showMessage(message);
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

    /**
     * This method is used to ask the player to choose the tiles from the board
     * @param livingRoom is the living room of the game
     */
    @Override
    public void TilesRequest(LivingRoom livingRoom) {
        Platform.runLater(gameSceneController::selectTiles);
    }

    /**
     * This method is used to ask the order of the tiles to put in the bookshelf
     * @param chosenTiles are the tiles chosen by the player
     */
    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) {
        Platform.runLater(() -> gameSceneController.tileOrder(chosenTiles));
    }

    /**
     * This method is used to ask the player to choose the column where to put the tile
     * @param AvailableColumns are the columns where the player can put the tile
     * @param player is the current player
     */
    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns, Player player) {
        Platform.runLater(() -> gameSceneController.selectColumn(AvailableColumns, player));
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

    /**
     * This method is used to show the living room of the game
     * @param livingRoom is the living room of the game
     */
    @Override
    public void showLivingRoom(LivingRoom livingRoom) {
        //GameSceneController gameSceneController = getGameSceneController();
        Platform.runLater(() -> gameSceneController.updateLivingRoom(livingRoom));
    }

    /**
     * This method is used to show the bookshelf of a player
     * @param player is the player whose bookshelf has to be shown
     */
    @Override
    public void showBookshelf(Player player) {
        Platform.runLater(() -> gameSceneController.updateBookShelf(player));
    }

    /**
     * This method is used to show the common goal cards of the game
     * @param game is the game
     */
    @Override
    public synchronized void showCommonGoalCards(Game game) {
        Platform.runLater(() -> gameSceneController.setCommonGoalCards(game));
    }

    /**
     * This method is used to show the personal goal card of a player
     * @param player is the player whose personal goal card has to be shown
     */
    @Override
    public synchronized void showPersonalGoalCard(Player player) {
        Platform.runLater(() -> gameSceneController.setPersonalGoalCard(player));
    }

    /**
     * This method is used update the state of the game
     * @param player is the current player
     * @param game is the current game
     */
    @Override
    public void updateGameState(Player player, Game game) {
        showCommonGoalCards(game);
        showPersonalGoalCard(player);
        showLivingRoom(game.getLivingRoom());
        for(Player p : game.getPlayers()) {
            showBookshelf(p);
        }
    }

    /**
     * This method is used to set up the initial game
     * @param game is the game started
     */
    @Override
    public synchronized void showGameStarted(Game game) {
        gameSceneController = new GameSceneController();
        gameSceneController.addAllObserver(observers);
        Platform.runLater(() -> GuiController.changeScene( "gameScene.fxml", gameSceneController));
        Platform.runLater(() -> gameSceneController.setUp(game));
        gameSceneController.setNumOfPlayers(game.getNumOfPlayers());
    }

    /**
     * This method is used get the game scene controller
     */
    public synchronized GameSceneController getGameSceneController(){
        GameSceneController gameSceneController;
        try {
            gameSceneController = (GameSceneController) GuiController.getCurrentController();
        } catch (ClassCastException e) {
            gameSceneController = new GameSceneController();
            gameSceneController.addAllObserver(observers);
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

        WaitingRoomSceneController waitingRoomSceneController = new WaitingRoomSceneController();
        waitingRoomSceneController.addAllObserver(observers);
        waitingRoomSceneController.setMaxPlayers(maxPlayers);
        waitingRoomSceneController.setNumOfPlayersConnected(numOfPlayersConnected);
        Platform.runLater(waitingRoomSceneController::startAnimationTimer);
        Platform.runLater(() -> GuiController.changeScene("waitingRoomScene.fxml",waitingRoomSceneController));
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
    public void startChat() {

    }

    @Override
    public void showChatMessage(ChatMessage message) {

    }

    /**
     * This method is used to handle the disconnections of the players
     * @param nickname is the nickname of the player that has disconnected
     */
    @Override
    public void handleDisconnection(String nickname) {
        Platform.runLater(() ->GuiController.changeScene("startScene.fxml", observers));
    }
}