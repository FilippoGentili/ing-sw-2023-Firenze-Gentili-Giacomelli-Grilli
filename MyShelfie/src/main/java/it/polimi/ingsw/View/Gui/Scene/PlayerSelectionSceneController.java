package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Third-A scene of the game.
 * This class is the controller for the player selection scene.
 */
public class PlayerSelectionSceneController extends ViewObservable {

    @FXML
    private Button enterButton;
    @FXML
    private ComboBox numberOfPlayersMenu;

    private static int maxPlayers;

    @FXML
    public void initialize(){
        enterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::enterButtonClicked);
    }

    /**
     * This method is only accessible by the first player that enters the game
     * sets the number of players and puts the player in the waiting room
     * @param event
     */
    private void enterButtonClicked(MouseEvent event) {
        setMaxPlayers(numberOfPlayersMenu.getVisibleRowCount());
        notifyObserver(obs -> {
            try {
                obs.updateNumOfPlayers(getMaxPlayers());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        GuiController.changeScene("waitingRoomScene.fxml", event, observers);
    }

    /**
     * sets the max number of players
     * @param maxPlayers
     */
    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    /**
     * gets the max number of players
     * @return
     */
    public static int getMaxPlayers(){
       return maxPlayers;
    }

}
