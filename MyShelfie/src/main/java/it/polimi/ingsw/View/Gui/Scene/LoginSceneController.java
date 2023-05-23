package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import javafx.scene.image.ImageView;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private Parent anchorPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView imageView;
    @FXML
    private Pane pane;
    @FXML
    private VBox vBox;
    @FXML
    private Text text;
    @FXML
    private TextField usernameField;
    @FXML
    private Button loginButton;

    private static int numOfPlayers=0;

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
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            })).start();
            setNumberOfConnectedPlayers();
            if(getNumberOfConnectedPlayers()==1){
                GuiController.changeScene("PlayerSelectionScene.fxml", event, observers);
            }else{
                GuiController.changeScene("waitingRoomScene.fxml", event, observers);
            }
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

    public void setNumberOfConnectedPlayers(){
        numOfPlayers++;
    }

    public static int getNumberOfConnectedPlayers(){
        return numOfPlayers;
    }

}
