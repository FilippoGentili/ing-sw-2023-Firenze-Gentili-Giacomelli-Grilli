package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionScene extends ViewObservable {

    private TextField serverAddress;
    private TextField serverPort;
    private Button connectRMIButton;
    private Button connectSocketButton;
    private Button goBackButton;

    public void setUp(){
        connectRMIButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                connectRMIButtonClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        connectSocketButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                connectSocketButtonClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        goBackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> goBackButtonClicked());
    }

    private void connectRMIButtonClicked() throws IOException {
        notifyObserver(obs -> {
            try {
                obs.updateServerInfoSocket();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void connectSocketButtonClicked() throws IOException{

    }

    private void goBackButtonClicked(){

    }

}