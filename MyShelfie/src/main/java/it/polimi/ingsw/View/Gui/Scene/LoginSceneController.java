package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.text.html.ImageView;

public class LoginSceneController extends ViewObservable implements GenericSceneController{
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
    public void setUp(){
    }


}
