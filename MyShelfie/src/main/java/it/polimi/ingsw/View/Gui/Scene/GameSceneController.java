package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class GameSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private AnchorPane bookshelfPlayer1;
    @FXML
    private AnchorPane bookshelfPlayer2;
    @FXML
    private AnchorPane bookshelfPlayer3;
    @FXML
    private AnchorPane bookshelfPlayerYou;
    @FXML
    private Text namePlayer1;
    @FXML
    private Text namePlayer2;
    @FXML
    private Text namePlayer3;
    @FXML
    private Text namePlayerYou;
    @FXML
    private AnchorPane personalGoalCard1;
    @FXML
    private AnchorPane personalGoalCard2;
    @FXML
    private AnchorPane personalGoalCard3;
    @FXML
    private AnchorPane personalGoalCardYou;
    @FXML
    private AnchorPane commonGoalCard1;
    @FXML
    private AnchorPane commonGoalCard2;
    @FXML
    private AnchorPane chairPlayer1;
    @FXML
    private AnchorPane chairPlayer2;
    @FXML
    private AnchorPane chairPlayer3;
    @FXML
    private AnchorPane chairPlayerYou;
    @FXML
    private GridPane boardGrid;
    @FXML
    private Button confirmSelectionButton;
    @FXML
    private Button confirmOrderButton;
    @FXML
    private TextField tileTypeField;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmSelectionButtonClicked);
        confirmOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmOrderButtonClicked);

    }

    public void setUp(Game game){
        bookshelfPlayer1.setVisible(false);
        bookshelfPlayer2.setVisible(false);
        bookshelfPlayer3.setVisible(false);
        namePlayer1.setVisible(false);
        namePlayer2.setVisible(false);
        namePlayer3.setVisible(false);

        if(game.getPlayers().size()==2){
            bookshelfPlayer2.setVisible(true);
            namePlayer1.setVisible(true);
        } else if (game.getPlayers().size()==3){
            bookshelfPlayer1.setVisible(false);
            bookshelfPlayer3.setVisible(false);
            namePlayer1.setVisible(true);
            namePlayer3.setVisible(true);
        }else{
            bookshelfPlayer1.setVisible(true);
            bookshelfPlayer2.setVisible(true);
            bookshelfPlayer3.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer2.setVisible(true);
            namePlayer3.setVisible(true);
        }

    }

    private void tileClicked(MouseEvent event) {
    }

    private void confirmSelectionButtonClicked(MouseEvent event) {
    }

    private void confirmOrderButtonClicked(MouseEvent event) {
    }


    public void updateLivingRoom(LivingRoom livingRoom){

    }

    public void updateBookShelf(Player player){
    }

    public void setCommonGoalCards(Game game){
       int id1 = game.getCommonGoal1().getId();
       int id2 = game.getCommonGoal2().getId();
       String styleClass1 = "generalCommonGoalCard" + id1;
       commonGoalCard1.getStyleClass().clear();
       commonGoalCard1.getStyleClass().add(styleClass1);
       String styleClass2 = "generalCommonGoalCard" + id2;
       commonGoalCard2.getStyleClass().clear();
       commonGoalCard2.getStyleClass().add(styleClass2);
    }

    public void setPersonalGoalCard(Player player) {
       /*int id = player.getPersonalGoalCard().getID();
       String styleClass = "generalPersonalGoalCard" + id;
       personalGoalCardYou.getStyleClass().clear();
       personalGoalCardYou.getStyleClass().add(styleClass);*/
    }

    public void setChair(Player player, Game game) {
        /*chairPlayer1.setVisible(false);
        chairPlayer2.setVisible(false);
        chairPlayer3.setVisible(false);
        chairPlayerYou.setVisible(false);
        if (player.equals(game.getFirstPlayer())) {
            chairPlayerYou.setVisible(true);}
        }
       */
    }
}
