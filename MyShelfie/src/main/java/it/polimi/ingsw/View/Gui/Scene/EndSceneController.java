package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class EndSceneController extends ViewObservable implements GenericSceneController{
    private final Stage stage;
    private double xAxis;
    private double yAxis;
    @FXML
    private Text winnerText;
    @FXML
    private ListView scoreBoard;
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
        winnerText.setText(nickname + " won!");
    }

    public void setScoreBoard(Game game){
        ArrayList<Player> list = new ArrayList<>();
        list = game.getScoreBoard(game.getPlayers());
        ArrayList<String> scoreboardItems = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);
            String scoreboardItem = (i + 1) + ". " + player.getNickname() + player.getScore();
            scoreboardItems.add(scoreboardItem);
        }

        scoreBoard.getItems().addAll(scoreboardItems);

    }

    public void displayEndScene(){
        stage.showAndWait();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }
}
