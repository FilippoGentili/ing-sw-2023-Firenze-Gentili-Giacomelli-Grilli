package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

/**
 * This class is the controller for the chat scene.
 */
public class ChatSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private Button sendButton;
    @FXML
    private TextField chatText;
    @FXML
    private ListView chatList;
    @FXML
    private BorderPane pane;
    private double xAxis;
    private double yAxis;
    public ChatSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
    }

    @FXML
    public void initialize() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::closeButtonClicked);
    }
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
    }
    public void showChat() {
        stage.showAndWait();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    private void paneClicked(MouseEvent event) {
        xAxis = stage.getX() - event.getScreenX();
        yAxis = stage.getY() - event.getScreenY();
    }

    private void paneDragged(MouseEvent event) {
        stage.setX(event.getScreenX() + xAxis);
        stage.setY(event.getScreenY() + yAxis);
    }


}
