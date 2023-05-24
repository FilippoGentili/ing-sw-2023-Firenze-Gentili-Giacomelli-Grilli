package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 * Fourth scene of the game.
 * This class is the controller for the waiting room scene.
 */
public class WaitingRoomSceneController extends ViewObservable implements GenericSceneController{

    private int connectedPlayers=1;
    private int maxPlayers = PlayerSelectionSceneController.getMaxPlayers();
    @FXML
    private Text playersConnectedText;
    @FXML
    public void initialize(){

        while(connectedPlayers < maxPlayers){
            setVisualPlayersConnected();
        }

        checkStartGame();
    }


    public void setVisualPlayersConnected() {
        playersConnectedText.setText("Players connected: " + connectedPlayers + " of " + maxPlayers);
    }


    /**
     * Checks if the number of players connected is equal to the maximum number of players of the game
     */
    public void checkStartGame() {
        if(connectedPlayers == maxPlayers)
            GuiController.changeScene("gameScene.fxml", (Scene) null,observers);
    }
}
