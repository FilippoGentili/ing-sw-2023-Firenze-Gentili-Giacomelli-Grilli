package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

/**
 * This class is the controller for the banner scene.
 */
public class BannerSceneController implements GenericSceneController{
    private final Stage stage;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Label titleLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Button okButton;

    public BannerSceneController() {
        stage = new Stage();
        stage.initOwner(GuiController.getCurrentScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
    }

    @FXML
    public void initialize() {
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::okButtonClicked);
    }

    private void okButtonClicked(MouseEvent event) {
        stage.close();
    }

    public void setBannerTitle(String str) {
        titleLabel.setText(str);
    }

    public void setBannerMessage(String string) {
        messageLabel.setText(string);
    }

    public void showBanner() {
        stage.showAndWait();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

}
