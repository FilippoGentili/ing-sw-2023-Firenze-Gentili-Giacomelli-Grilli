package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MenuSceneController extends ViewObservable {

    @FXML
    private Pane menuPane;
    @FXML
    private Button playButton;
    @FXML
    private Button exitButton;
}
