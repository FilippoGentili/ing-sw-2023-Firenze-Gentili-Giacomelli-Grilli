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
    private Text score1;
    @FXML
    private Text score2;
    @FXML
    private Text score3;
    @FXML
    private Text score4;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane easter;

    @FXML
    public void initialize(){
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::exitButtonClicked);
        easter.addEventHandler(MouseEvent.MOUSE_CLICKED, this::easterClicked);
    }

    public void setWinner(String nickname){
        winnerText.setText(nickname + " won!");
    }

    public void setScoreBoard(Game game){
        int numberOfPlayers = game.getPlayers().size();
        ArrayList<Player> list = game.getScoreBoard(game.getPlayers());
        ArrayList<Integer> scoreList = new ArrayList<>();
        for(Player player : list)
            scoreList.add(player.getScore());
        switch (numberOfPlayers) {
            case 2 -> {
                score3.setVisible(false);
                score4.setVisible(false);
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
            }
            case 3 -> {
                score4.setVisible(false);
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + list.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
            }
            case 4 -> {
                score1.setText("1. " + list.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + list.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + list.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
                score4.setText("4. " + list.get(3).getNickname() + ":      " + scoreList.get(3) + " points");
            }
            default -> {
            }
        }
    }

    public void easterClicked(MouseEvent event){
    }
    public void exitButtonClicked(MouseEvent event){
        System.exit(1);
    }
}