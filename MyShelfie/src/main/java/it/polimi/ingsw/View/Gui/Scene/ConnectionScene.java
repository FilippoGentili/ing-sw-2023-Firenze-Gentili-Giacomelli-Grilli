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
    private Button connectButton;
    private Button goBackButton;

    public void setUp(){
        connectButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                connectButtonClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        goBackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> goBackButtonClicked());
    }

    private void connectButtonClicked() throws IOException {
        String address = serverAddress.getText();
        String port = serverPort.getText();

        Map<String,String> serverInfo = new HashMap<>();
        serverInfo.put(address,port);

        ClientController.updateServerInfoSocket(serverInfo); //metto tutti i metodi e attributi relativi come statici?
    }

    private void goBackButtonClicked(){

    }

}