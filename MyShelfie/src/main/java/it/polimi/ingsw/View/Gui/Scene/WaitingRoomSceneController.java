package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Fourth scene of the game.
 * This class is the controller for the waiting room scene.
 */
public class WaitingRoomSceneController extends ViewObservable implements GenericSceneController{

    private AnimationTimer timer;
    private int maxPlayers;

    private int numOfPlayersConnected;

    @FXML
    public Text playersConnectedText;

    @FXML
    private Text welcomeText;


    public void setUp(){
        playersConnectedText.setVisible(false);
        welcomeText.setVisible(false);
    }

    public void setVisualPlayersConnected() {
        playersConnectedText.setText("Players connected: " + numOfPlayersConnected + " of " + maxPlayers);
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setNumOfPlayersConnected(int numOfPlayersConnected) {
        this.numOfPlayersConnected = numOfPlayersConnected;
    }

    public void setWelcomeText(String string){
        welcomeText.setVisible(true);
        welcomeText.setText(string);
    }

    public void startAnimationTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                setVisualPlayersConnected();
            }
        };
        timer.start();
    }
}
