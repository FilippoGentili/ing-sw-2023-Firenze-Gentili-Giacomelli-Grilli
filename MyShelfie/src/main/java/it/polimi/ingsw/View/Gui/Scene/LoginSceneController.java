package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.Gui;
import it.polimi.ingsw.View.Gui.GuiController;
import it.polimi.ingsw.View.VirtualView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Third scene of the game.
 * This class is the controller for the login scene.
 */
public class LoginSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private TextField usernameField;
    @FXML
    private Button loginButton;


    @FXML
    public void initialize() {
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::loginButtonClicked);
        usernameField.setOnKeyPressed(this::enterButtonClicked);
    }

    /**
     * This method is called when the login button is clicked. It starts a new game with the username inserted.
     * @param event
     */
    private void loginButtonClicked(Event event) {
        if (event instanceof MouseEvent || (event instanceof KeyEvent && ((KeyEvent) event).getCode() == KeyCode.ENTER)) {
            String username = usernameField.getText();

            new Thread(() -> notifyObserver(obs -> {
                try {
                    obs.updateNickname(username);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })).start();

        }

    }

    /**
     * This method is called when the enter key is pressed. It calls the loginButtonClicked method.
     * @param event
     */
    @FXML
    private void enterButtonClicked(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            loginButtonClicked(event);
        }
    }

}
