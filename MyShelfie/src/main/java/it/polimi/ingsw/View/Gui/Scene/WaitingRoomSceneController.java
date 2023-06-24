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

    /**
     * Sets up the waiting room
     */
    public void setUp(){
        playersConnectedText.setVisible(false);
        welcomeText.setVisible(false);
    }

    /**
     * Sets the text about how many players are connected out of the number of players of the game
     */
    public void setVisualPlayersConnected() {
        playersConnectedText.setText("Players connected: " + numOfPlayersConnected + " of " + maxPlayers);
    }

    /**
     * Sets the number of players of the game
     * @param maxPlayers chosen by the first client
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Sets how many players are connected out of the number of players of the game
     * @param numOfPlayersConnected when the client connects
     */
    public void setNumOfPlayersConnected(int numOfPlayersConnected) {
        this.numOfPlayersConnected = numOfPlayersConnected;
    }

    /**
     * @param string to be set as welcome text
     */
    public void setWelcomeText(String string){
        welcomeText.setVisible(true);
        welcomeText.setText(string);
    }

    /**
     * Starts animation timer
     */
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
