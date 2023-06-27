package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

/**
 * This class is the controller for the chat banner of the common goal card information.
 */
public class CommonGoalCardInfoSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private BorderPane pane;
    @FXML
    private Text textInfoNumber;
    @FXML
    private Text textInfo;
    private double xAxis;
    private double yAxis;

    /**
     * Constructor of CommonGoalCard info controller
     */
    public CommonGoalCardInfoSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
    }

    /**
     * Initializes panes and button of the scene
     */
    @FXML
    public void initialize() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::closeButtonClicked);
    }

    /**
     * Closes the stage when close button is clicked
     * @param event of type mouse clicked
     */
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
    }

    /**
     * Shows info for each common goal card
     */
    public void showCommonGoalCardInfo() {
        stage.showAndWait();
    }

    /**
     * Sets title of each goal card using the id
     * @param id of the goal card
     */
    public void setTitle(int id) {
        switch (id) {
            case 1 -> textInfoNumber.setText("Common Goal Card 1");
            case 2 -> textInfoNumber.setText("Common Goal Card 2");
            case 3 -> textInfoNumber.setText("Common Goal Card 3");
            case 4 -> textInfoNumber.setText("Common Goal Card 4");
            case 5 -> textInfoNumber.setText("Common Goal Card 5");
            case 6 -> textInfoNumber.setText("Common Goal Card 6");
            case 7 -> textInfoNumber.setText("Common Goal Card 7");
            case 8 -> textInfoNumber.setText("Common Goal Card 8");
            case 9 -> textInfoNumber.setText("Common Goal Card 9");
            case 10 -> textInfoNumber.setText("Common Goal Card 10");
            case 11 -> textInfoNumber.setText("Common Goal Card 11");
            case 12 -> textInfoNumber.setText("Common Goal Card 12");
            default -> {
            }
        }
    }

    /**
     * Displays information about a goal card depending on the id
     * @param id of the selected card
     */
    public void setInformations(int id) {
        switch (id) {
            case 1 -> textInfo.setText("Six groups each containing at least 2 tiles of the same type (not necessarily in the depicted shape).\n" + "The tiles of one group can be different from those of another group.");
            case 2 -> textInfo.setText("Five tiles of the same type forming a diagonal.");
            case 3 -> textInfo.setText("Four tiles of the same type in the four corners of the bookshelf.");
            case 4 -> textInfo.setText("Four lines each formed by 5 tiles of maximum three different types.\n" + "One line can show the same or a different combination of another line.");
            case 5 -> textInfo.setText("Four groups each containing at least 4 tiles of the same type (not necessarily in the depicted shape).\n" + "The tiles of one group can be different from those of another group");
            case 6 -> textInfo.setText("Two columns each formed by 6 different types of tiles. ");
            case 7 -> textInfo.setText("Two groups each containing 4 tiles of the same type in a 2x2 square.\n" + "The tiles of one square can be different from those of the other square.");
            case 8 -> textInfo.setText("Two lines each formed by 5 different types of tiles.\n" + "One line can show the same or a different combination of the other line.");
            case 9 -> textInfo.setText("Three columns each formed by 6 tiles of maximum three different types.\n" + "One column can show the same or a different combination of another column.");
            case 10 -> textInfo.setText("Five tiles of the same type forming an X.");
            case 11 -> textInfo.setText("Eight tiles of the same type. There’s no restriction about the position of these tiles.");
            case 12 -> textInfo.setText("Five columns of increasing or decreasing height. Starting from the first column on the left or on the right,\n" + " each next column must be made of exactly one more tile. Tiles can be of any type.");
            default -> {
            }
        }
    }

    /**
     * Sets scene to stage
     * @param scene to be set
     */
    public void setScene(Scene scene) {
        stage.setScene(scene);
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
