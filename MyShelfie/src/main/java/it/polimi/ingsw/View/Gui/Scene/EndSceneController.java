package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


import java.util.ArrayList;


public class EndSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private Text winnerText;
    @FXML
    private ListView scoreBoard;
    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane easter;

    @FXML
    public void initialize(){
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::exitButtonClicked);
        easter.addEventHandler(MouseEvent.MOUSE_CLICKED, this::easterClicked);
        winnerText = new Text();
        scoreBoard = new ListView<>();
    }

    public void setWinner(String nickname){
        winnerText.setText(nickname + " won!");
    }

    public void setScoreBoard(Game game){
        ArrayList<Player> list = game.getScoreBoard(game.getPlayers());
        ArrayList<String> scoreboardItems = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);
            String scoreboardItem = (i + 1) + ". " + player.getNickname() + " " + player.getScore();
            scoreboardItems.add(scoreboardItem);
        }

        scoreBoard.getItems().addAll(scoreboardItems);
    }

    public void easterClicked(MouseEvent event){
    }
    public void exitButtonClicked(MouseEvent event){
        System.exit(1);
    }
}