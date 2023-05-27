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

    private final PseudoClass ERROR = PseudoClass.getPseudoClass("error");
    private static final String ERROR_MESSAGE = "Network Error";

    @FXML
    public void initialize(){
        socketButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::socketButtonClicked);
        rmiButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::rmiButtonClicked);
    }

    /**
     * This method is called when the socket button is clicked. It starts a new game with socket connection.
     * @param event
     */
    private void socketButtonClicked(MouseEvent event){
        String port = portBox.getText();
        String address = addressBox.getText();
        socketButton.setDisable(true);
        rmiButton.setDisable(true);
        boolean validPort = ClientController.validPort(port);
        boolean validAddress = ClientController.validAddress(address);

        addressBox.pseudoClassStateChanged(ERROR, !validAddress);
        portBox.pseudoClassStateChanged(ERROR, !validPort);

        if(validPort && validAddress){
            new Thread(() -> notifyObserver(obs -> {
                try {
                    obs.updateServerInfoSocket(this,address,port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })).start();
        }else if(validPort){
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid address");
            });
        }else{
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid port");
            });
        }
    }

    /**
     * This method is called when the rmi button is clicked. It starts a new game with rmi connection.
     * @param event
     */
    private void rmiButtonClicked(MouseEvent event){
        String port = portBox.getText();
        String address = addressBox.getText();
        rmiButton.setDisable(true);
        socketButton.setDisable(true);

        boolean validPort = ClientController.validPort(port);
        boolean validAddress = ClientController.validAddress(address);

        addressBox.pseudoClassStateChanged(ERROR, !validAddress);
        portBox.pseudoClassStateChanged(ERROR, !validPort);
        if(validPort && validAddress) {
            new Thread(() -> notifyObserver(obs -> {
                try {
                    obs.updateServerInfoRmi(this, address, port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })).start();
        }else if(validPort){
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid address");
            });
        }else{
            Platform.runLater(() -> {
                GuiController.showBanner(ERROR_MESSAGE, "Invalid port");
            });
        }
    }

    @Override
    public void handleDisconnection() {

    }
}