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


public class GuiController {
    private static Scene currentScene;
    private static GenericScene genericScene;


    public static void changeScene(String fxml, Scene scene, List<ViewObserver> observers){

        currentScene = scene;

        FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/fxml/"+fxml)); //loader contiene la pag fxml passata come parametro
        Parent layout = loader.getRoot(); // layout è la struttura di base della pag fxml
        currentScene.setRoot(layout); // viene settata la struttura della pagina corrente
        Object controller = loader.getController(); // controller contiene il file java che si occupa di gestire la pag fxml

        for(ViewObserver observer : observers){
            ((ViewObservable) controller).addObserver(observer); // si aggiunge il controller agli observer
        }

        genericScene = (GenericScene) controller; // il controller è la rappresentazione della pagina fxml

    }

    public static void changeScene(String fxml,Event event,List<ViewObserver> observers){
        Scene scene = ((Node)event.getSource()).getScene();
        changeScene(fxml,scene,observers);
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public GenericScene getGenericScene() {
        return genericScene;
    }
}
