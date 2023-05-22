package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

/**
 * This class is the controller for the start scene.
 */
public class StartSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane pane;
    @FXML
    private ImageView imageView;
    @FXML
    private HBox hBox;
    @FXML
    private Button playButton;
    @FXML
    private Button resumeButton;

    @FXML
    public void initialize(){
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::playButtonClicked);
        resumeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::resumeButtonClicked);
    }

    /**
     * This method is called when the play button is clicked. It starts a new game.
     * @param event
     */
    private void playButtonClicked(MouseEvent event){
        GuiController.changeScene("connectionScene.fxml",event,observers);
    }

    /**
     * This method is called when the resume button is clicked. It resumes the game from the last saved state.
     * @param event
     */
    private void resumeButtonClicked(MouseEvent event){
        /*if(!GuiController.getGuiView().isGameStarted()){
            GuiController.showAlert("No game to resume");
        }else{
            GuiController.changeScene("gameScene.fxml",event,observers);
        }*/
    }
}
