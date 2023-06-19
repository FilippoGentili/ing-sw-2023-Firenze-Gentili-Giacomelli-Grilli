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
    @FXML
    private Text winnerText;
    @FXML
    private ListView scoreBoard;
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
}
