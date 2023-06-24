package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import java.io.IOException;


/**
 * Second scene of the game.
 * This class is the controller for the connection scene.
 */
public class ConnectionSceneController extends ViewObservable implements GenericSceneController, DisconnectionHandler{
    @FXML
    private Button socketButton;
    @FXML
    private Button rmiButton;
    @FXML
    private TextField portBox;
    @FXML
    private TextField addressBox;
    final String SocketPort = "1098";
    final String RMIPort = "1099";
    private final PseudoClass ERROR = PseudoClass.getPseudoClass("error");
    private static final String ERROR_MESSAGE = "Network Error";

    /**
     * Initializes the buttons for the two types of connection
     */
    @FXML
    public void initialize(){
        socketButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::socketButtonClicked);
        rmiButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::rmiButtonClicked);
    }

    /**
     * This method is called when the socket button is clicked. It starts a new game with socket connection.
     * @param event of type mouse clicked
     */
    private void socketButtonClicked(MouseEvent event) {
        String address = addressBox.getText();
        String port = SocketPort;

        boolean validAddress = ClientController.validAddress(address, "socket");
        addressBox.pseudoClassStateChanged(ERROR, !validAddress);

        if (validAddress) {
            socketButton.setDisable(true);
            rmiButton.setDisable(true);
            notifyObserver(obs -> {
                try {
                    obs.updateServerInfoSocket(this, address, port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid address");
            });
        }
    }

    /**
     * This method is called when the rmi button is clicked. It starts a new game with rmi connection.
     * @param event of type mouse clicked
     */
    private void rmiButtonClicked(MouseEvent event){
        String address = addressBox.getText();
        String port = RMIPort;

        boolean validAddress = ClientController.validAddress(address, "rmi");

        addressBox.pseudoClassStateChanged(ERROR, !validAddress);

        if(validAddress) {
            socketButton.setDisable(true);
            rmiButton.setDisable(true);
            notifyObserver(obs -> {
                try {
                    obs.updateServerInfoRmi(this,address,port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }else{
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid address");
            });
        }
    }

    @Override
    public void handleDisconnection() {

    }
}