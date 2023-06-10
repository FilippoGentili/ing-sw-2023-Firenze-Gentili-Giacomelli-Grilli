package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

public class GameSceneController extends ViewObservable implements GenericSceneController{
   /* @FXML
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
    private TextField tileTypeField;*/

    @FXML
    public void initialize(){
       /* boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmSelectionButtonClicked);
        confirmOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmOrderButtonClicked);
*/
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
       // CommonGoalCard id1 = game.getCommonGoal1();
        //CommonGoalCard id2 = game.getCommonGoal1();
       // commonGoalCard1.setStyle("-fx-background-image: url('/images/commonGoalCards/" + id1 + ".jpg')");
        //commonGoalCard2.setStyle("-fx-background-image: url('/images/commonGoalCards/" + id2 + ".jpg')");

    }

    public void setPersonalGoalCard(Player player) {
       // PersonalGoalCard id = player.getPersonalGoalCard();
        //personalGoalCardYou.setStyle("-fx-background-image: url('/images/personalGoalCards/Personal_Goals" + id + ".png')");
    }

}
