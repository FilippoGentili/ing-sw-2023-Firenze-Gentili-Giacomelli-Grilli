package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Chat;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.application.Platform;
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
    private Chat chat;
    private double xAxis;
    private double yAxis;
    private volatile ArrayList<String> chatMessages;
    private boolean chatMode = false;

    /**
     * Constructor of chat scene controller
     */
    public ChatSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        xAxis = 0;
        yAxis = 0;
        stage.setAlwaysOnTop(true);
        this.chatMessages = new ArrayList<>();
    }


    /**
     * Initializes all the components of the chat
     */
    @FXML
    public void initialize() {
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::paneClicked);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::paneDragged);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::closeButtonClicked);
        sendButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::sendButtonClicked);
        chatText.setOnKeyPressed(this::enterButtonClicked);
    }

    /**
     * Sets up item for the chat, selecting players available to receive messages
     * @param game current game
     * @param chat of the player
     */
    public void setUp(Game game, Chat chat){
        this.chat = chat;
        playerList.getItems().clear();
        playerList.setPromptText("Select Player");
        playerList.getItems().add("All players");
        for (Player player : game.getPlayers()) {
            if(!player.getNickname().equals(GuiController.getChat().getOwner()))
                playerList.getItems().add(player.getNickname());
        }
        playerList.getSelectionModel().select(0);
    }

    /**
     * Handles sending messages
     * @param event of type mouse clicked
     */
    public void sendButtonClicked(Event event){
        if (event instanceof MouseEvent || (event instanceof KeyEvent && ((KeyEvent) event).getCode() == KeyCode.ENTER)) {
            String message = chatText.getText();
            String receiver = (String) playerList.getSelectionModel().getSelectedItem();
            if(!message.equals("") && !receiver.equals(GuiController.getChat().getOwner())){
                notifyObserver(obs -> {
                    obs.sendChatMessage(receiver, message);
                });
                chatList.getItems().add("from you to " + receiver + ": " + message);
            }
            chatText.clear();
        }
    }

    /**
     * Updates chat with new messages
     * @param chat of the player
     */
    public void updateChat(Chat chat){
        ArrayList<String> messages = chat.getMessages();
        for (String message : messages) {
            chatList.getItems().add(message);
            //GuiController.getChat().addOldMessage(message);
        }
    }

    /**
     * Adds old messages to be displayed
     * @param messages received by the player
     */
    public void addOldMessages(ArrayList<String> messages){
        for(String message : messages){
            chatList.getItems().add(message);
        }
    }

    /**
     * Handles closing the chat
     * @param event of type mouse clicked
     */
    private void closeButtonClicked(MouseEvent event) {
        stage.close();
        chatMode = false;
    }

    /**
     * Shows chat for the current player
     */
    public void showChat() {
        chatMode = true;
        stage.show();
        Thread chatThread = new Thread(() -> {
            Platform.runLater(() -> addOldMessages(GuiController.getChat().getOldMessages()));
            while (chatMode) {
                Platform.runLater(() -> updateChat(this.chat));
                try {
                    Thread.sleep(1000); // Aggiungi una breve pausa tra gli aggiornamenti della chat
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        chatThread.start();
    }

    /**
     * Sets scene to stage
     * @param scene to be set
     */
    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    /**
     * Handles pane clicked
     * @param event of type mouse clicked
     */
    private void paneClicked(MouseEvent event) {
        xAxis = stage.getX() - event.getScreenX();
        yAxis = stage.getY() - event.getScreenY();
    }

    /**
     * Handles pane dragged
     * @param event of type mouse clicked
     */
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
