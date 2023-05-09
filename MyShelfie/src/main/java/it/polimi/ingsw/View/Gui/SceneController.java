package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.Observer.ViewObserver;
import it.polimi.ingsw.View.Gui.Scene.GenericScene;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.List;


public class SceneController {
    private static Scene currentScene;
    private static GenericScene genericScene;


    public static void changePane(String fxml, Scene scene, List<ViewObserver> observers){

        currentScene = scene;

        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/"+fxml));
        Parent root = loader.getRoot();
        currentScene.setRoot(root);
        Object controller = loader.getController();

        for(ViewObserver observer : observers){
            ((ViewObservable) controller).addObserver(observer);
        }

        genericScene = (GenericScene) controller;

    }

    public static void changePane(String fxml,Event event,List<ViewObserver> observers){
        Scene scene = ((Node)event.getSource()).getScene();
        changePane(fxml,scene,observers);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public GenericScene getGenericScene() {
        return genericScene;
    }
}
