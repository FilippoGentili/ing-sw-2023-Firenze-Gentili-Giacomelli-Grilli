package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class RulebookSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane pane;
    private double xAxis;
    private double yAxis;

    /**
     * Constructor of rulebook scene controller
     */
    public RulebookSceneController() {
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
     * Handles click on close button
     * @param event of type mouse clicked
     */
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
    }

    /**
     * Shows rulebook
     */
    public void showRulebook() {
        stage.showAndWait();
    }

    /**
     * Sets scene to stage
     * @param scene that has to be set
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
