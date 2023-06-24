package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.ChatMessage;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.Scene.*;
import it.polimi.ingsw.View.View;
import javafx.application.Platform;

import java.util.ArrayList;

public class Gui extends ViewObservable implements View {
    private static final String ERROR = "Login Error";
    private static final String END = "GAME OVER";
    private GameSceneController gameSceneController;
    private EndSceneController endSceneController;
    private WaitingRoomSceneController waitingRoomSceneController;

    @Override
    public Chat getChat() {
        return GuiController.getChat();
    }

    @Override
    public void showMessage(String message){
        //if(gameSceneController != null)
          //  gameSceneController.showMessage(message);
        //per ora lo lasciamo commentato, perchè ogni messsaggio che manda il server è un banner nella gui
    }

    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname){
        if (!validNickname || !connection) {
            if (!validNickname && connection) {
                if(nickname.equals("") || nickname == null || nickname.isEmpty()){
                    Platform.runLater(() -> {
                        GuiController.showBanner(ERROR, "Please insert a valid nickname");
                        GuiController.changeScene("loginScene.fxml", observers);
                    });
                }else {
                    Platform.runLater(() -> {
                        GuiController.showBanner(ERROR, "Nickname already taken");
                        GuiController.changeScene("loginScene.fxml", observers);
                    });
                }
            } else {
                Platform.runLater(() -> {
                    GuiController.showBanner(ERROR, "Server Error");
                    GuiController.changeScene("startScene.fxml", observers);
                });
            }
        }    }

    @Override
    public void nicknameRequest(){
        Platform.runLater(() -> GuiController.changeScene( "loginScene.fxml",observers));
    }

    @Override
    public void askNumberOfPlayers() {
        PlayerSelectionSceneController playerSelectionSceneController = new PlayerSelectionSceneController();
        playerSelectionSceneController.addAllObserver(observers);
        Platform.runLater(() -> GuiController.changeScene( "playerSelectionScene.fxml",playerSelectionSceneController));
    }

    @Override
    public void turnDisplay(Player player) {
        Platform.runLater(() -> gameSceneController.setVisualNames(player));
    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) {
        Platform.runLater(() -> gameSceneController.selectTiles());
    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) {
        Platform.runLater(() -> gameSceneController.tileOrder(chosenTiles));
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns, Player player) {
        Platform.runLater(() -> gameSceneController.selectColumn(AvailableColumns, player));
    }

    @Override
    public void showScoreboard(ArrayList<Player> scoreboard) {
        //Platform.runLater(() -> GuiController.changeScene( "endScene.fxml",observers));
    }

    @Override
    public void someoneDisconnected(String nickname) {
        Platform.runLater(() -> {
            GuiController.showBanner(END, "The player " + nickname + " disconnected");
            GuiController.changeScene("startScene.fxml", observers);
        });
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) {
        Platform.runLater(() -> gameSceneController.updateLivingRoom(livingRoom));
    }

    @Override
    public void showBookshelf(Player player) {
        Platform.runLater(() -> gameSceneController.updateBookShelf(player));
    }

    @Override
    public synchronized void showCommonGoalCards(Game game) {
        Platform.runLater(() -> gameSceneController.setCommonGoalCards(game));
    }

    @Override
    public synchronized void showPersonalGoalCard(Player player) {
        Platform.runLater(() -> gameSceneController.setPersonalGoalCard(player));
    }

    @Override
    public void updateGameState(Player player, Game game) {
        if(gameSceneController == null){
            showGameStarted(game);
        }
        showCommonGoalCards(game);
        showPersonalGoalCard(player);
        showLivingRoom(game.getLivingRoom());
        Platform.runLater(() ->gameSceneController.updateVisualEndGameToken(game));
        for(Player p : game.getPlayers()) {
            showBookshelf(p);
        }
    }

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


    @Override
    public void showWaitingRoom(int maxPlayers, int numOfPlayersConnected) {
        WaitingRoomSceneController waitingRoomSceneController = new WaitingRoomSceneController();
        waitingRoomSceneController.addAllObserver(observers);
        waitingRoomSceneController.setMaxPlayers(maxPlayers);
        waitingRoomSceneController.setNumOfPlayersConnected(numOfPlayersConnected);
        Platform.runLater(waitingRoomSceneController::startAnimationTimer);
        Platform.runLater(() -> GuiController.changeScene("waitingRoomScene.fxml",waitingRoomSceneController));
    }

    @Override
    public void welcomeBack(String nickname){
        waitingRoomSceneController = new WaitingRoomSceneController();
        waitingRoomSceneController.addAllObserver(observers);
        Platform.runLater(waitingRoomSceneController::startAnimationTimer);
        Platform.runLater(() -> GuiController.changeScene("waitingRoomScene.fxml",waitingRoomSceneController));
        Platform.runLater(() -> waitingRoomSceneController.setUp());
        Platform.runLater(() -> waitingRoomSceneController.setWelcomeText("Welcome back " + nickname + "!"));
        Platform.runLater(() -> waitingRoomSceneController.setVisualPlayersConnected());
        //waitingRoomSceneController.playersConnectedText.setText("Waiting for other players to connect...");
        //waitingRoomSceneController.setWelcomeText("Welcome back " + nickname + "!");
    }

    @Override
    public void showWinner(String winner, Game game) {
    }

    @Override
    public void showChatMessages(Chat chat) {

    }

    @Override
    public void updateGuiCommonGoalCardPoints(Game game, int previousPoints1, int previousPoints2){
        Platform.runLater(() ->gameSceneController.updateVisualCommonGoalCardPoints(game, previousPoints1, previousPoints2));
    }

    @Override
    public void endGame(ArrayList<Player> scoreboard, String winner) {
        endSceneController = new EndSceneController();
        endSceneController.addAllObserver(observers);
        Platform.runLater(() -> GuiController.changeScene("endScene.fxml", endSceneController));
        Platform.runLater(() -> endSceneController.setUp());
        Platform.runLater(() -> endSceneController.setWinner(winner));
        Platform.runLater(() -> endSceneController.setScoreBoard(scoreboard));
    }

    @Override
    public void handleDisconnection(String nickname) {
        Platform.runLater(() -> {
            GuiController.showBanner(END, "You will be disconnected. Game finished :(");
        });

        System.exit(1);
    }
}