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

import java.rmi.RemoteException;

public class PlayerSelectionSceneController extends ViewObservable {

    @FXML
    private Button enterButton;

    @FXML
    private ComboBox comboBox;

    private int max =4;
    private int min =2;
    private static int maxPlayers;


    @FXML
    public void initialize(){
        enterButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::enterButtonClicked);
    }

    private void enterButtonClicked(MouseEvent event) {
        maxPlayers = comboBox.getVisibleRowCount();
        notifyObserver(obs -> {
            try {
                obs.updateNumOfPlayers(maxPlayers);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
        GuiController.changeScene("waitingRoomScene.fxml", event, observers);
    }
    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    public static int getMaxPlayers(){
       return maxPlayers;
    }

}
