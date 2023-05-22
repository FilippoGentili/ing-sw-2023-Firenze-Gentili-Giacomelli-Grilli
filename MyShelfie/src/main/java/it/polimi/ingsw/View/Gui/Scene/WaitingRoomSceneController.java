package it.polimi.ingsw.View.Gui.Scene;

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
        setConnectedPlayers(2);
        setMaxPlayers(4);
        setPlayersConnected(connectedPlayers,maxPlayers);
        checkNumPlayers();

    }

    /**
     * Sets the number of players connected to the game
     * @param connectedPlayers number of players connected
     * @param maxPlayers maximum number of players
     */
    public void setPlayersConnected(int connectedPlayers, int maxPlayers) {
        playersConnectedText.setText("Players connected: " + connectedPlayers + " of " + maxPlayers);
    }

    /**
     * Sets the number of players connected to the game
     * @param connectedPlayers
     */
    public void setConnectedPlayers(int connectedPlayers) {
        this.connectedPlayers = connectedPlayers;
    }

    /**
     * Sets the maximum number of players
     * @param maxPlayers
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Checks if the number of players connected is equal to the maximum number of players
     */
    public void checkNumPlayers() {
        if(connectedPlayers == maxPlayers)
            GuiController.changeScene("gameScene.fxml", (Scene) null,observers);
    }
}
