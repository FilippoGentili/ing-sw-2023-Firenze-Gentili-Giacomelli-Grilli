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
import java.io.IOException;

public class GameSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private AnchorPane bookshelfPlayer1;
    @FXML
    private AnchorPane bookshelfPlayer2;
    @FXML
    private AnchorPane bookshelfPlayer3;
    @FXML
    private AnchorPane bookshelfPlayer4;
    @FXML
    private Text namePlayer1;
    @FXML
    private Text namePlayer2;
    @FXML
    private Text namePlayer3;
    @FXML
    private Text namePlayer4;
    @FXML
    private AnchorPane personalGoalCardPlayer1;
    @FXML
    private AnchorPane personalGoalCardPlayer2;
    @FXML
    private AnchorPane personalGoalCardPlayer3;
    @FXML
    private AnchorPane personalGoalCardPlayer4;
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
    private AnchorPane chairPlayer4;
    @FXML
    private GridPane boardGrid;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField tileTypeField;
    boolean firstClick = true;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmButtonClicked);
    }
    /**
     * This method is called to set up the initial game scene
     * @param game the current game
     */
    public void setUp(Game game){
        confirmButton.setVisible(false);

        bookshelfPlayer1.setVisible(false);
        bookshelfPlayer2.setVisible(false);
        bookshelfPlayer3.setVisible(false);
        bookshelfPlayer4.setVisible(false);
        namePlayer1.setVisible(false);
        namePlayer2.setVisible(false);
        namePlayer3.setVisible(false);
        namePlayer4.setVisible(false);
        personalGoalCardPlayer1.setVisible(false);
        personalGoalCardPlayer2.setVisible(false);
        personalGoalCardPlayer3.setVisible(false);
        personalGoalCardPlayer4.setVisible(false);
        setChair(game);

        if (game.getPlayers().size() == 2) {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            personalGoalCardPlayer1.setVisible(true);
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(1).getNickname());
            personalGoalCardPlayer3.setVisible(true);
        } else if (game.getPlayers().size() == 3) {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            personalGoalCardPlayer1.setVisible(true);
            bookshelfPlayer2.setVisible(true);
            namePlayer2.setVisible(true);
            namePlayer2.setText(game.getPlayers().get(1).getNickname());
            personalGoalCardPlayer2.setVisible(true);
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(2).getNickname());
            personalGoalCardPlayer3.setVisible(true);
        } else {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            personalGoalCardPlayer1.setVisible(true);
            bookshelfPlayer2.setVisible(true);
            namePlayer2.setVisible(true);
            namePlayer2.setText(game.getPlayers().get(1).getNickname());
            personalGoalCardPlayer2.setVisible(true);
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(2).getNickname());
            personalGoalCardPlayer3.setVisible(true);
            bookshelfPlayer4.setVisible(true);
            namePlayer4.setVisible(true);
            namePlayer4.setText(game.getPlayers().get(3).getNickname());
            personalGoalCardPlayer4.setVisible(true);
        }
}

    public void tileClicked(MouseEvent event) {
        confirmButton.setVisible(true);
    }

    public void tileOrder() {
        confirmButton.setVisible(true);
    }

    /**
     * This method is called when the confirm button is clicked for the chosen tiles and also for the order for those tiles
     * @param event mouse event
     */
    private void confirmButtonClicked(MouseEvent event) {
        confirmButton.setVisible(false);
        if(firstClick){
            firstClick = false;
            new Thread(() -> notifyObserver(obs -> {
                //obs.updateChosenTiles(chosenTiles);
            })).start();
        } else {
            new Thread(() -> notifyObserver(obs -> {
                //obs.updateOrderedTiles(orderedTiles);
            })).start();
            firstClick = true;
        }

    }


    public void updateLivingRoom(LivingRoom livingRoom){

    }

    public void updateBookShelf(Player player){
    }

    /**
     * This method is called to set the common goal cards of the game
     * @param game the current game
     */
    public void setCommonGoalCards(Game game){
       int id1 = game.getCommonGoal1().getId();
       int id2 = game.getCommonGoal2().getId();
       String styleCommonGoalCard1 = "generalCommonGoalCard" + id1;
       commonGoalCard1.getStyleClass().clear();
       commonGoalCard1.getStyleClass().add(styleCommonGoalCard1);
       String styleCommonGoalCard2 = "generalCommonGoalCard" + id2;
       commonGoalCard2.getStyleClass().clear();
       commonGoalCard2.getStyleClass().add(styleCommonGoalCard2);
    }

    /**
     * This method is called to set the personal goal cards of the players
     * @param player the current player
     */
    public void setPersonalGoalCard(Player player) {
        Game game = player.getGame();
        int index = game.getPlayers().indexOf(player);
        int id = player.getPersonalGoalCard().getID();
        String stylePersonalGoalCard = "generalPersonalGoalCard" + id;
        if (game.getPlayers().size() == 2) {
            switch (index) {
                case 0 -> {
                    personalGoalCardPlayer1.getStyleClass().clear();
                    personalGoalCardPlayer1.getStyleClass().add(stylePersonalGoalCard);
                }
                case 1 -> {
                    personalGoalCardPlayer3.getStyleClass().clear();
                    personalGoalCardPlayer3.getStyleClass().add(stylePersonalGoalCard);
                }
            }
        } else if (game.getPlayers().size() == 3) {
            switch (index) {
                case 0 -> {
                    personalGoalCardPlayer1.getStyleClass().clear();
                    personalGoalCardPlayer1.getStyleClass().add(stylePersonalGoalCard);
                }
                case 1 -> {
                    personalGoalCardPlayer2.getStyleClass().clear();
                    personalGoalCardPlayer2.getStyleClass().add(stylePersonalGoalCard);
                }
                case 2 -> {
                    personalGoalCardPlayer3.getStyleClass().clear();
                    personalGoalCardPlayer3.getStyleClass().add(stylePersonalGoalCard);
                }
            }
        } else if (game.getPlayers().size() == 4) {
            switch (index) {
                case 0 -> {
                    personalGoalCardPlayer1.getStyleClass().clear();
                    personalGoalCardPlayer1.getStyleClass().add(stylePersonalGoalCard);
                }
                case 1 -> {
                    personalGoalCardPlayer2.getStyleClass().clear();
                    personalGoalCardPlayer2.getStyleClass().add(stylePersonalGoalCard);
                }
                case 2 -> {
                    personalGoalCardPlayer3.getStyleClass().clear();
                    personalGoalCardPlayer3.getStyleClass().add(stylePersonalGoalCard);
                }
                case 3 -> {
                    personalGoalCardPlayer4.getStyleClass().clear();
                    personalGoalCardPlayer4.getStyleClass().add(stylePersonalGoalCard);
                }
            }
        }
    }

    /**
     * This method is called to set the chair of the first player
     * @param game the current game
     */
    public void setChair(Game game) {
        chairPlayer1.setVisible(false);
        chairPlayer2.setVisible(false);
        chairPlayer3.setVisible(false);
        chairPlayer4.setVisible(false);
        for (Player player : game.getPlayers()) {
            int index = game.getPlayers().indexOf(player);
            if (player.equals(game.getFirstPlayer())) {
                int chairIndex = index + 1;
                if (game.getPlayers().size() == 2) {
                    switch (chairIndex) {
                        case 1 -> chairPlayer1.setVisible(true);
                        case 2 -> chairPlayer2.setVisible(true);
                        default -> {
                        }
                    }
                    break;
                } else if (game.getPlayers().size() == 3) {
                    switch (chairIndex) {
                        case 1 -> chairPlayer1.setVisible(true);
                        case 2 -> chairPlayer2.setVisible(true);
                        case 3 -> chairPlayer3.setVisible(true);
                        default -> {
                        }
                    }
                    break;
                } else if (game.getPlayers().size() == 4) {
                    switch (chairIndex) {
                        case 1 -> chairPlayer1.setVisible(true);
                        case 2 -> chairPlayer2.setVisible(true);
                        case 3 -> chairPlayer3.setVisible(true);
                        case 4 -> chairPlayer4.setVisible(true);
                        default -> {
                        }
                    }
                    break;
                }
            }

        }
    }
}
