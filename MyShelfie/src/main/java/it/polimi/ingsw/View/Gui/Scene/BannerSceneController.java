package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

/**
 * This class is the controller for the banner scene.
 */
public class BannerSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Label titleLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Button okButton;
    @FXML
    private BorderPane pane;
    private double xAxis;
    private double yAxis;

    /**
     * Constructor of banner scene controller
     */
    public BannerSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
    }

    /**
     * Initializes the panes and ok button
     */
    @FXML
    public void initialize() {
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::okButtonClicked);
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
    }

    /**
     * Handles ok button clicked
     * @param event of type mouse clicked
     */
    private void okButtonClicked(MouseEvent event) {
        stage.close();
    }

    /**
     * Sets the title of the banner
     * @param str text to set as the title of the banner
     */
    public void setBannerTitle(String str) {
        titleLabel.setText(str);
    }
    /**
     * Sets the text of the banner
     * @param string text to set in the banner
     */
    public void setBannerMessage(String string) {
        messageLabel.setText(string);
    }

    /**
     * Shows the banner in the scene
     */
    public void showBanner() {
        stage.showAndWait();
    }

    /**
     * @param scene to set
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
