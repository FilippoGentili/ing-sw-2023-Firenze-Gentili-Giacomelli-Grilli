package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.Gui.Scene.*;
import it.polimi.ingsw.View.View;
import javafx.application.Platform;
import it.polimi.ingsw.Network.Message.MessageType;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Gui extends ViewObservable implements View {
    private static final String ERROR = "Login Error";
    @Override
    public void showMessage(String message) throws RemoteException {

    }

    /**
     * This method is used to get the login result after the player has chosen the nickname
     * @param validNickname
     * @param connection
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException {
        if (!validNickname || !connection) {
            if (!validNickname && connection) {
                Platform.runLater(() -> {
                    Platform.runLater(() -> GuiController.showBanner(ERROR, "Nickname already taken"));
                });
            } else {
                Platform.runLater(() -> {
                    Platform.runLater(() -> GuiController.showBanner(ERROR, "Error connecting to server"));
                    new Thread(() -> notifyObserver(obs -> {
                        try {
                            obs.handleDisconnection();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })).start();
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
    public void nicknameRequest() throws RemoteException {
        Platform.runLater(() -> GuiController.changeScene( "loginScene.fxml",observers));
    }

    /**
     * This method is used to ask the max number of players in the game
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void askNumberOfPlayers() throws RemoteException {
        /* PlayerSelectionSceneController playerSelectionSceneController = new PlayerSelectionSceneController();
        playerSelectionSceneController.addAllObserver(observers);
        Platform.runLater(() -> GuiController.changeScene( "playerSelectionScene.fxml",playerSelectionSceneController));*/
        Platform.runLater(() -> GuiController.changeScene( "playerSelectionScene.fxml",observers));
    }

    @Override
    public void columnRequest(ArrayList<Integer> AvailableColumns) throws RemoteException {

    }

    @Override
    public void TilesRequest(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void OrderTiles(ArrayList<Tile> chosenTiles) throws RemoteException {

    }

    /**
     * This method is used to show the list of players in the game
     * @param listOfPlayers is the list of players in the game
     * @param player is the player that is playing
     * @throws RemoteException if there are connection problems
     */
    @Override
    public void showListOfPlayers(ArrayList<Player> listOfPlayers, Player player) throws RemoteException {

    }

    /**
     * This method is used to show the message that a player has disconnected
     * @param nickname
     * @throws RemoteException
     */
    @Override
    public void someoneDisconnected(String nickname) throws RemoteException {
        Platform.runLater(() -> {
            GuiController.showBanner("GAME OVER", "The player disconnected.");
            GuiController.changeScene("startScene.fxml", observers);
        });
    }

    @Override
    public void showLivingRoom(LivingRoom livingRoom) throws RemoteException {

    }

    @Override
    public void showBookshelf(Player player) throws RemoteException {

    }

    @Override
    public void showCommonGoalCards(Game game) {

    }

    @Override
    public void showPersonalGoalCard(Player player) throws Exception {

    }

    @Override
    public void updateGameState(Player player, Game game) throws Exception {

    }

    @Override
    public void showWinner(String winner) {
        Platform.runLater(() -> {
            GuiController.showEnd(winner);
            GuiController.changeScene("endScene.fxml", observers);
        });
    }
}
