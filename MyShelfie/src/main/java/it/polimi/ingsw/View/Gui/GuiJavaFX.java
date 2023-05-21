package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.View.Gui.Scene.StartSceneController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiJavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Gui guiView = new Gui();
        ClientController clientController = new ClientController(guiView);

        guiView.addObserver(clientController);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/startScene.fxml"));
        Parent layout = null;

        try{
            layout = fxmlLoader.load();
        }catch (IOException e){
            Client.LOGGER.severe(e.getMessage());
            System.exit(0);
        }

        StartSceneController startSceneController = fxmlLoader.getController();
        startSceneController.addObserver(clientController);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setWidth(1366d);
        stage.setHeight(768d);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setTitle("MyShelfie");
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        Platform.exit();
        System.exit(0);
    }
}
