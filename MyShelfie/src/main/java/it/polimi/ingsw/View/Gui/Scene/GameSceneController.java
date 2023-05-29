package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.ViewObservable;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    public void initialize(){

    }
    public void setUpGame(Game game){
        int numOfPlayers = game.getPlayers().size();
        if(numOfPlayers == 2){
            bookshelfPlayer1.setVisible(false);
            namePlayer1.setVisible(false);
            personalGoalCard1.setVisible(false);

            bookshelfPlayer3.setVisible(false);
            namePlayer3.setVisible(false);
            personalGoalCard3.setVisible(false);

        }else if(numOfPlayers == 3){
            bookshelfPlayer2.setVisible(false);
            namePlayer2.setVisible(false);
            personalGoalCard2.setVisible(false);
        }
    }

    public void updateLivingRoom(LivingRoom livingRoom){

    }

    public void updateBookShelf(Player player){

    }

    public void setCommonGoalCards(Game game){

    }

    public void setPersonalGoalCard(Player player){

    }

}
