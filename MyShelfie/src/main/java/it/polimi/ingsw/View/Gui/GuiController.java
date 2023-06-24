package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Model.Chat;
import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.Gui.Scene.*;
import it.polimi.ingsw.View.View;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GuiController extends ViewObservable{
    private static Scene currentScene;
    private static GenericSceneController currentController;

    private static final Chat chat = new Chat();

    public static Chat getChat(){
        return chat;
    }

    /**
     * Changes scene setting the controller, the scene and through the list of observers
     * @param fxml
     * @param scene
     * @param observers
     * @return
     * @param <T>
     */
    public synchronized static <T> T changeScene(String fxml, Scene scene, List<ViewObserver> observers) {
        T controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/fxml/" + fxml));
            Parent root = loader.load();
            controller = loader.getController();
            ((ViewObservable) controller).addAllObserver(observers);

            currentController = (GenericSceneController) controller;
            currentScene = scene;
            currentScene.setRoot(root);
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
        }
        return controller;
    }

    /**
     * Casts a scene to a node and changes the scene through an event, and fxml file and the list of observers
     * @param fxml
     * @param event
     * @param observers
     * @return the changed scene
     * @param <T>
     */
    public synchronized static <T> T changeScene(String fxml, Event event,List<ViewObserver> observers) {
        Scene scene = ((Node) event.getSource()).getScene();
        return changeScene(fxml, scene, observers);
    }

    /**
     * Changes scene through fxml and list of observers
     * @param fxml
     * @param observers
     * @return the changed scene
     * @param <T>
     */
    public synchronized static <T> T changeScene(String fxml,  List<ViewObserver> observers){
        return changeScene(fxml, currentScene, observers);
    }

    /**
     * Changes scene through fxml file, scene to go to and controller
     * @param fxml
     * @param scene
     * @param controller
     */
    public synchronized static void changeScene(String fxml, Scene scene,GenericSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/fxml/" + fxml));
            loader.setController(controller);
            currentController = controller;
            Parent root = loader.load();
            currentScene = scene;
            currentScene.setRoot(root);
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
        }
    }

    public synchronized static void changeScene(String fxml, Event event,GenericSceneController controller) {
        Scene scene = ((Node) event.getSource()).getScene();
        changeScene(fxml, scene, controller);
    }

    /**
     * Changes scene through the fxml file and a generic scene controller
     * @param fxml
     * @param controller
     */
    public synchronized static void changeScene(String fxml, GenericSceneController controller) {
        changeScene(fxml, currentScene, controller);
    }

    /**
     * This method is used to display the banner
     */
    public synchronized static void showBanner(String title, String message) {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiController.class.getResource("/fxml/bannerScene.fxml"));
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
            return;
        }
        BannerSceneController bannerSceneController = fxmlLoader.getController();
        Scene bannerScene = new Scene(parent);
        bannerSceneController.setScene(bannerScene);
        bannerSceneController.setBannerTitle(title);
        bannerSceneController.setBannerMessage(message);
        bannerSceneController.showBanner();
    }

    /**
     * @return current scene
     */
    public static Scene getCurrentScene() {
        return currentScene;
    }

    /**
     * @return generic scene controller
     */
    public static GenericSceneController getCurrentController() {
        return currentController;
    }

    /**
     * Displays the chat of the player
     */
    public static void showChat(Game game) {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiController.class.getResource("/fxml/chatScene.fxml"));
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
            return;
        }
        ChatSceneController chatSceneController = fxmlLoader.getController();
        Scene chatScene = new Scene(parent);
        chatSceneController.setUp(game);
        chatSceneController.updateChat(getChat());
        chatSceneController.setScene(chatScene);
        chatSceneController.showChat();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                chatSceneController.updateChat(getChat());
            }
        }, 0, 1000);
    }

    /**
     * Shows the leaderBoard
     */
    public static void showLeaderboard(Game game) {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiController.class.getResource("/fxml/leaderboardScene.fxml"));
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
            return;
        }
        LeaderboardSceneController leaderboardSceneController = fxmlLoader.getController();
        Scene leaderboardScene = new Scene(parent);
        leaderboardSceneController.setListScore(game);
        leaderboardSceneController.setScene(leaderboardScene);
        leaderboardSceneController.showLeaderboard();
    }

    /**
     * Shows the ruleBook during the game
     */
    public static void showRulebook(){
        FXMLLoader fxmlLoader = new FXMLLoader(GuiController.class.getResource("/fxml/rulebookScene.fxml"));
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
            return;
        }
        RulebookSceneController rulebookSceneController = fxmlLoader.getController();
        Scene rulebookScene = new Scene(parent);
        rulebookSceneController.setScene(rulebookScene);
        rulebookSceneController.showRulebook();

    }

    /**
     * Shows the commonGoalCard information
     */
    public static void showCommonGoalCardInfo(int id){
        FXMLLoader fxmlLoader = new FXMLLoader(GuiController.class.getResource("/fxml/commonGoalCardInfoScene.fxml"));
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
            return;
        }
        CommonGoalCardInfoSceneController commonGoalCardInfoSceneController = fxmlLoader.getController();
        Scene commonGoalCardInfoScene = new Scene(parent);
        commonGoalCardInfoSceneController.setScene(commonGoalCardInfoScene);
        commonGoalCardInfoSceneController.setTitle(id);
        commonGoalCardInfoSceneController.setInformations(id);
        commonGoalCardInfoSceneController.showCommonGoalCardInfo();

    }

}