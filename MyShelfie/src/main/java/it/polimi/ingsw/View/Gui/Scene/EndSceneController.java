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


import java.io.IOException;
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

    public void setUp(){
        winnerText.setVisible(false);
        score1.setVisible(false);
        score2.setVisible(false);
        score3.setVisible(false);
        score4.setVisible(false);
    }

    public void setWinner(String nickname){
        winnerText.setVisible(true);
        winnerText.setText(nickname + " won!");
    }

    public void setScoreBoard(ArrayList<Player> scoreBoard){
        int numberOfPlayers = scoreBoard.size();
        ArrayList<Integer> scoreList = new ArrayList<>();
        for(Player player : scoreBoard)
            scoreList.add(player.getScore());
        switch (numberOfPlayers) {
            case 2 -> {
                score3.setVisible(false);
                score4.setVisible(false);
                score1.setVisible(true);
                score2.setVisible(true);
                score1.setText("1. " + scoreBoard.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + scoreBoard.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
            }
            case 3 -> {
                score4.setVisible(false);
                score1.setVisible(true);
                score2.setVisible(true);
                score3.setVisible(true);
                score1.setText("1. " + scoreBoard.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + scoreBoard.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + scoreBoard.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
            }
            case 4 -> {
                score1.setVisible(true);
                score2.setVisible(true);
                score3.setVisible(true);
                score4.setVisible(true);
                score1.setText("1. " + scoreBoard.get(0).getNickname() + ":      " + scoreList.get(0) + " points");
                score2.setText("2. " + scoreBoard.get(1).getNickname() + ":      " + scoreList.get(1) + " points");
                score3.setText("3. " + scoreBoard.get(2).getNickname() + ":      " + scoreList.get(2) + " points");
                score4.setText("4. " + scoreBoard.get(3).getNickname() + ":      " + scoreList.get(3) + " points");
            }
            default -> {
            }
        }
    }

    public void easterClicked(MouseEvent event){
    }
    public void exitButtonClicked(MouseEvent event){
        notifyObserver(obs -> {
            try {
                obs.handleDisconnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        System.exit(1);
    }
}