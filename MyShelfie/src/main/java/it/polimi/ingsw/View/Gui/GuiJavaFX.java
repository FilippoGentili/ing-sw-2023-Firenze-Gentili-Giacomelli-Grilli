package it.polimi.ingsw.View.Gui;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.View.Gui.Scene.MenuScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        MenuScene menuScene = fxmlLoader.getController();
        menuScene.addObserver(clientController);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setTitle("MyShelfie");
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
