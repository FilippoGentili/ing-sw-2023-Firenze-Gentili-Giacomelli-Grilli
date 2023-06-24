package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * This class is the controller for the leaderBoard scene.
 */
public class LeaderboardSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private BorderPane pane;

    @FXML
    private Text score1;
    @FXML
    private Text score2;
    @FXML
    private Text score3;
    @FXML
    private Text score4;
    private double xAxis;
    private double yAxis;

    /**
     * Constructor of leaderboard scene controller
     */
    public LeaderboardSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
    }
    /**
     * Initializes the panes and close button
     */
    @FXML
    public void initialize() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::closeButtonClicked);
    }

    /**
     * Closes the stage when exit button is clicked
     * @param event of type mouse clicked
     */
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
    }

    /**
     * Shows leaderboard
     */
    public void showLeaderboard() {
        stage.showAndWait();
    }

    /**
     * @param scene that has to be set
     */
    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    /**
     * Sets list score for the game
     * @param game current game
     */
    public void setListScore(Game game) {
        int numberOfPlayers = game.getPlayers().size();
        ArrayList<Player> list = game.getScoreBoard(game.getPlayers());
        ArrayList<Integer> scoreList = new ArrayList<>();
        for(Player player : list)
            scoreList.add(player.getScore());
        switch (numberOfPlayers) {
            case 2 -> {
                score3.setVisible(false);
                score4.setVisible(false);
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
            }
            case 3 -> {
                score4.setVisible(false);
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + list.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
            }
            case 4 -> {
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + list.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
                score4.setText("4. " + list.get(3).getNickname() + ":      " + scoreList.get(3) + " points");
            }
            default -> {
            }
        }

    }

    /**
     * Handles pane clicked event
     * @param event of type mouse clicked
     */
    private void paneClicked(MouseEvent event) {
        xAxis = stage.getX() - event.getScreenX();
        yAxis = stage.getY() - event.getScreenY();
    }

    /**
     * Handles pane dragged event
     * @param event of type mouse clicked
     */
    private void paneDragged(MouseEvent event) {
        stage.setX(event.getScreenX() + xAxis);
        stage.setY(event.getScreenY() + yAxis);
    }


}
