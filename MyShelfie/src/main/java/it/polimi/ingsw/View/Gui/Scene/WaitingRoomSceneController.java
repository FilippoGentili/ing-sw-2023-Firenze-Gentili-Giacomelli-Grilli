package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import it.polimi.ingsw.View.View;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 * Fourth scene of the game.
 * This class is the controller for the waiting room scene.
 */
public class WaitingRoomSceneController extends ViewObservable implements GenericSceneController{

    private AnimationTimer timer;
    private int maxPlayers;

    @FXML
    private Text playersConnectedText;
    @FXML
    public void initialize(){

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                setVisualPlayersConnected();
            }
        };

        timer.start();
    }


    public void setVisualPlayersConnected() {
        playersConnectedText.setText("Players connected: "   + " of " + maxPlayers);
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

}
