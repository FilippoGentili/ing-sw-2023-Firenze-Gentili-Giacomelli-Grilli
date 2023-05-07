package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class ConnectionScene extends ViewObservable {

    private TextField serverAddress;
    private TextField serverPort;
    private Button connectButton;
    private Button goBackButton;

    public void setUp(){
        connectButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> connectButtonClicked());
        goBackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> goBackButtonClicked());
    }

    private void connectButtonClicked(){
        String address = serverAddress.getText();
        String port = serverPort.getText();

        Map<String,String> serverInfo = new HashMap<>();
        serverInfo.put(address,port);

        ClientController.updateServerInfo(serverInfo); //metto tutti i metodi e attributi relativi come statici?
    }

    private void goBackButtonClicked(){

    }

}
