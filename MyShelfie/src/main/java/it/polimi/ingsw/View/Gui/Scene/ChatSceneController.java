package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Chat;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is the controller for the chat scene.
 */
public class ChatSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    @FXML
    private Button closeButton;
    @FXML
    private Button sendButton;
    @FXML
    private TextField chatText;
    @FXML
    private ListView chatList;
    @FXML
    private ComboBox playerList;
    @FXML
    private BorderPane pane;
    private double xAxis;
    private double yAxis;
    public ChatSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
    }

    @FXML
    public void initialize() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::closeButtonClicked);
        sendButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::sendButtonClicked);
        chatText.setOnKeyPressed(this::enterButtonClicked);
    }

    public void setUp(Game game){
        int numberOfPlayers = game.getPlayers().size();
        playerList.getItems().clear();
        playerList.setPromptText("Select Player");
        playerList.getItems().add("All players");
        for (Player player : game.getPlayers()) {
            playerList.getItems().add(player.getNickname());
        }
        playerList.getSelectionModel().select(0);

    }
    public void sendButtonClicked(Event event){
        if (event instanceof MouseEvent || (event instanceof KeyEvent && ((KeyEvent) event).getCode() == KeyCode.ENTER)) {
            String message = chatText.getText();
            if(!message.equals("")){
                chatText.clear();
                notifyObserver(obs -> {
                    obs.sendChatMessage(playerList.getSelectionModel().toString(), message);
                });
            }
        }
    }
    public void updateChat(Chat chat){
        ArrayList<String> messages = chat.getMessages();
        chatList.getItems().clear();
        for (String message : messages) {
            chatList.getItems().add(message);
        }
    }
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
    }
    public void showChat() {
        stage.showAndWait();
    }
    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    private void paneClicked(MouseEvent event) {
        xAxis = stage.getX() - event.getScreenX();
        yAxis = stage.getY() - event.getScreenY();
    }

    private void paneDragged(MouseEvent event) {
        stage.setX(event.getScreenX() + xAxis);
        stage.setY(event.getScreenY() + yAxis);
    }

    /**
     * This method is called when the enter key is pressed. It calls the sendButtonClicked method.
     * @param event enter button pressed.
     */
    @FXML
    private void enterButtonClicked(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendButtonClicked(event);
        }
    }
}
