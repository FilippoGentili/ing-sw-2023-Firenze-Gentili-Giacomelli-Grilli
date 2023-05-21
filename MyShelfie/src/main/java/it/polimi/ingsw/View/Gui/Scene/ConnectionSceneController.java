package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.event.Event;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import javax.swing.text.html.ImageView;
import java.awt.*;


public class ConnectionSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private Parent anchorPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView imageView;
    @FXML
    private Pane pane;
    @FXML
    private VBox vBox;
    @FXML
    private HBox hBox;
    @FXML
    private Button socketButton;
    @FXML
    private Button rmiButton;

    @FXML
    public void initialize(){
        socketButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::socketButtonClicked);
        rmiButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::rmiButtonClicked);
    }

    /**
     * This method is called when the socket button is clicked. It starts a new game with socket connection.
     * @param event
     */
    private void socketButtonClicked(MouseEvent event){
        GuiController.changeScene("loginScene.fxml",event,observers);
    }

    /**
     * This method is called when the rmi button is clicked. It starts a new game with rmi connection.
     * @param event
     */
    private void rmiButtonClicked(MouseEvent event){
        GuiController.changeScene("loginScene.fxml",event,observers);
    }
}