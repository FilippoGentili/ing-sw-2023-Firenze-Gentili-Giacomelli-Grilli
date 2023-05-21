package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.Gui.Scene.GenericSceneController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.List;


public class GuiController {
    private static Scene currentScene;
    private static GenericSceneController genericSceneController;


    public static <C> C changeScene(String fxml, Scene scene, List<ViewObserver> observers) {
        C controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/fxml/" + fxml));
            Parent root = loader.load();
            controller = loader.getController();
            ((ViewObservable) controller).addAllObserver(observers);

            for (ViewObserver observer : observers) {
                ((ViewObservable) controller).addObserver(observer);
            }

            genericSceneController = (GenericSceneController) controller;
            currentScene = scene;
            currentScene.setRoot(root);
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
        }
        return controller;
    }

    public static <C> C changeScene(String fxml, Event event,List<ViewObserver> observers) {
        Scene scene = ((Node) event.getSource()).getScene();
        return changeScene(fxml, scene, observers);
    }

    public static <C> C changeScene(String fxml,  List<ViewObserver> observers){
        return changeScene(fxml, currentScene, observers);
    }

    public static void changeScene(String fxml, Scene scene,GenericSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/fxml/" + fxml));

            // Setting the controller BEFORE the load() method.
            loader.setController(controller);
            genericSceneController = controller;
            Parent root = loader.load();

            currentScene = scene;
            currentScene.setRoot(root);
        } catch (IOException e) {
            Client.LOGGER.severe(e.getMessage());
        }
    }

    public static void changeScene(String fxml, Event event,GenericSceneController controller) {
        Scene scene = ((Node) event.getSource()).getScene();
        changeScene(fxml, scene, controller);
    }

    public static void changeScene(String fxml, GenericSceneController controller) {
        changeScene(fxml, currentScene, controller);
    }
    public Scene getCurrentScene() {
        return currentScene;
    }

    public GenericSceneController getGenericScene() {
        return genericSceneController;
    }
}
