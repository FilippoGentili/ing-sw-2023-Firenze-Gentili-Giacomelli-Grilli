package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ConnectionScene extends ViewObservable {

    private TextField serverAddress;
    private TextField serverPort;
    private Button connectRMIButton;
    private Button connectSocketButton;
    private Hyperlink goBackLink;

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

        goBackLink.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> goBackLinkClicked());
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

    private void goBackLinkClicked(){

    }

}