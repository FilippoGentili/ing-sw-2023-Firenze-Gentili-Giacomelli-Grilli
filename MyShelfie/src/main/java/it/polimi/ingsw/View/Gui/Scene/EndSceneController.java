package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EndSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    private double xAxis;
    private double yAxis;
    public EndSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        xAxis = 0;
        yAxis = 0;
    }
    @FXML
    public void initialize(){

    }

    public void setWinner(String nickname){
    }

    public void displayEndScene(){
        stage.showAndWait();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }
}
