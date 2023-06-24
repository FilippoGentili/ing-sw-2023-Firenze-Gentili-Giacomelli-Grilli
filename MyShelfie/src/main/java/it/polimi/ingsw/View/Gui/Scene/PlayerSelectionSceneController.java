package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Third-A scene of the game.
 * This class is the controller for the player selection scene.
 */
public class PlayerSelectionSceneController extends ViewObservable implements GenericSceneController {

    @FXML
    private Button enterButton;
    @FXML
    private ComboBox numberOfPlayersMenu;

    @FXML
    public void initialize(){
        enterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::enterButtonClicked);
    }

    /**
     * This method is only accessible by the first player that enters the game sets the number of players and puts the
     * player in the waiting room
     * @param event
     */
    private void enterButtonClicked(MouseEvent event) {
        Object selectedValue = numberOfPlayersMenu.getSelectionModel().getSelectedItem();
        if (selectedValue != null) {
            String selectedValueString = selectedValue.toString();
            enterButton.setDisable(true);
            int maxPlayers = Integer.parseInt(selectedValueString.split(" ")[0]);
            notifyObserver(obs -> {
                try {
                    obs.updateNumOfPlayers(maxPlayers);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
