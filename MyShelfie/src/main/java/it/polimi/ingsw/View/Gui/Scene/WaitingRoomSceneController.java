package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class WaitingRoomSceneController extends ViewObservable implements GenericSceneController{

    private int connectedPlayers;
    private int maxPlayers;
    @FXML
    private Text playersConnectedText;
    @FXML
    public void initialize(){
        while(LoginSceneController.getNumberOfConnectedPlayers() < PlayerSelectionSceneController.getMaxPlayers()){
            setVisualPlayersConnected(connectedPlayers,maxPlayers);
        }
        checkStartGame();
    }

    /**
     * Sets the visual number of players connected to the game in the gui
     * @param connectedPlayers number of players connected
     * @param maxPlayers maximum number of players
     */
    public void setVisualPlayersConnected(int connectedPlayers, int maxPlayers) {
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
