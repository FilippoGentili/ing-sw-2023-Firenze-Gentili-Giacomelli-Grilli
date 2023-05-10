package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MenuScene extends ViewObservable {
    @FXML
    private Button playButton;
    @FXML
    private Button exitButton;

    private void playButtonClicked(Event event){
        GuiController.changeScene("connectScene.fxml",event,observers);
    }
    @FXML
    public void setUp(){
        playButton.setText("Play!");
        exitButton.setText("Quit");

        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::playButtonClicked);
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.exit(0));
    }
}
