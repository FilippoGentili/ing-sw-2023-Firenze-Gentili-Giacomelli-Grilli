package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * First scene of the game.
 * This class is the controller for the start scene.
 */
public class StartSceneController extends ViewObservable implements GenericSceneController{

    @FXML
    private Button playButton;
    @FXML
    public void initialize(){
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::playButtonClicked);
    }

    /**
     * This method is called when the play button is clicked. It starts a new game.
     * @param event
     */
    private void playButtonClicked(MouseEvent event){
        GuiController.changeScene("connectionScene.fxml",event,observers);
    }

}
