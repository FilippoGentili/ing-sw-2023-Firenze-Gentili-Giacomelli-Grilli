package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.Gui;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static it.polimi.ingsw.Model.TileType.NULL;
import static java.lang.Integer.parseInt;

public class GameSceneController extends ViewObservable implements GenericSceneController{
    @FXML
    private AnchorPane bookshelfPlayer1;
    @FXML
    private GridPane bookShelf1;
    @FXML
    private AnchorPane bookshelfPlayer2;
    @FXML
    private GridPane bookShelf2;
    @FXML
    private AnchorPane bookshelfPlayer3;
    @FXML
    private GridPane bookShelf3;
    @FXML
    private AnchorPane bookshelfPlayer4;
    @FXML
    private GridPane bookShelf4;
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
    private Button confirmTileOrderButton;
    @FXML
    private Button confirmTileSelectionButton;
    @FXML
    private Button confirmColumnButton;
    @FXML
    private MenuItem openChatButton;
    @FXML
    private MenuItem quitButton;
    @FXML
    private MenuItem leaderboardButton;
    boolean yourTurn = false;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmTileOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmTileOrderButtonClicked(event, new ArrayList<>()));
        confirmColumnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmColumnButtonClicked(event, new ArrayList<>()));
        confirmTileSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmTileSelectionButtonClicked);
        openChatButton.setOnAction(this::openChatButtonClicked);
        quitButton.setOnAction(this::quitButtonClicked);
        leaderboardButton.setOnAction(this::leaderboardButtonClicked);
    }

    /**
     * This method is called to set up the initial game scene
     * @param game the current game
     */
    public synchronized void setUp(Game game){
        confirmTileOrderButton.setVisible(false);
        confirmTileSelectionButton.setVisible(false);
        confirmColumnButton.setVisible(false);

        bookshelfPlayer1.setVisible(false);
        bookshelfPlayer2.setVisible(false);
        bookshelfPlayer3.setVisible(false);
        bookshelfPlayer4.setVisible(false);
        namePlayer1.setVisible(false);
        namePlayer2.setVisible(false);
        namePlayer3.setVisible(false);
        namePlayer4.setVisible(false);
        commonGoalCard1.setVisible(true);
        commonGoalCard2.setVisible(true);
        personalGoalCardPlayer1.setVisible(false);
        personalGoalCardPlayer2.setVisible(false);
        personalGoalCardPlayer3.setVisible(false);
        personalGoalCardPlayer4.setVisible(false);
        setChair(game);

        if (game.getPlayers().size() == 2) {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            //personalGoalCardPlayer1.setVisible(true);
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(1).getNickname());
            //personalGoalCardPlayer3.setVisible(true);
        } else if (game.getPlayers().size() == 3) {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            bookshelfPlayer2.setVisible(true);
            namePlayer2.setVisible(true);
            namePlayer2.setText(game.getPlayers().get(1).getNickname());
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(2).getNickname());
        } else {
            bookshelfPlayer1.setVisible(true);
            namePlayer1.setVisible(true);
            namePlayer1.setText(game.getPlayers().get(0).getNickname());
            bookshelfPlayer2.setVisible(true);
            namePlayer2.setVisible(true);
            namePlayer2.setText(game.getPlayers().get(1).getNickname());
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(2).getNickname());
            bookshelfPlayer4.setVisible(true);
            namePlayer4.setVisible(true);
            namePlayer4.setText(game.getPlayers().get(3).getNickname());
        }
    }

    public void selectTiles(){
        Platform.runLater(() -> {
            GuiController.showBanner("INFO", "Choose up to 3 tiles from the board");
        });
        yourTurn = true;
    }
    /**
     * This method is called when a tile has been clicked during the current player's turn
     * @param event mouse event
     */
    public void tileClicked(MouseEvent event) {
        ObservableList<Node> children = boardGrid.getChildren();
        for(Node node : children) {
            if(node instanceof ImageView) {
                if(node.getBoundsInParent().contains(event.getSceneX(), event.getSceneY())) {
                    if (yourTurn) {
                        node.setEffect(new Glow(0.5));
                        confirmTileSelectionButton.setVisible(true);
                    }
                }
            }
        }
        /*Node source = (Node) event.getSource();
        Integer columnIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        int i=1;
        boolean valid = true;
        if(yourTurn) {

            while (i < 4 && valid) {
                if (columnIndex > 3 && columnIndex < 6 && rowIndex == 1) {        //first row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 3 && columnIndex < 7 && rowIndex == 2) { //second row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 2 && columnIndex < 8 && rowIndex == 3) { //third row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 1 && columnIndex < 10 && rowIndex == 4) { //fourth row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 0 && columnIndex < 10 && rowIndex == 5) { //fifth row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 0 && columnIndex < 9 && rowIndex == 6) { //sixth row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 2 && columnIndex < 8 && rowIndex == 7) { //seventh row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 3 && columnIndex < 7 && rowIndex == 8) { //eighth row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                } else if (columnIndex > 4 && columnIndex < 7 && rowIndex == 9) { //ninth row
                    i++;
                    confirmTileSelectionButton.setVisible(true);
                }

                confirmTileSelectionButton.setVisible(false);
            }
        }*/
    }

    public void confirmTileSelectionButtonClicked(MouseEvent event){

    }

    /**
     * Tjis is method is called when the player has to choose the column to put the tiles in
     */
    public void selectColumn(){

    }

    public void confirmColumnButtonClicked(MouseEvent event, ArrayList<Integer> AvailableColumns) {


    }

    /**
     * This method is called when the player has to choose the order of the tiles to put in the bookshelf
     */
    public void tileOrder() {
    }

    /**
     * This method is called when the confirm button is clicked for the chosen tiles and also for the order for those tiles
     * @param event mouse event
     */
    private void confirmTileOrderButtonClicked(MouseEvent event, ArrayList<Tile> chosenTiles) {

    }

    /**
     * This method is called to update the tiles on the living room board
     * @param livingRoom of the current game
     */
    public synchronized void updateLivingRoom(LivingRoom livingRoom){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(isCellValid(livingRoom.getTile(i,j))){
                    if(livingRoom.getTile(i,j).getTileType() != NULL) {
                        boardGrid.add(setTiles(livingRoom.getTile(i, j).getTileType()), j + 1, i + 1);
                    }
                }
            }
        }
    }

    /**
     * This method is called to update the tiles on the bookshelf
     * @param player of the bookshelf
     */
    public synchronized void updateBookShelf(Player player){
       /* Game game = player.getGame();
        int index = game.getPlayers().indexOf(player);
        if (game.getPlayers().size() == 2) {
            switch (index) {
                case 0 -> {
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 1 ->{
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
            }
        }else if(game.getPlayers().size()==3){
            switch (index) {
                case 0 -> {
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 1 ->{
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 2 ->{
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
            }
        }else if(game.getPlayers().size()==4){
            switch (index) {
                case 0 -> {
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf1.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 1 ->{
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf2.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 2 ->{
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf3.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
                case 3 ->{
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(0, 0).getTileType()),1,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(0, 1).getTileType()),1,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(0, 2).getTileType()),1,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(0, 3).getTileType()),1,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(0, 4).getTileType()),1,5);

                    bookShelf4.add(setTiles(player.getBookshelf().getTile(1, 0).getTileType()),2,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(1, 1).getTileType()),2,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(1, 2).getTileType()),2,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(1, 3).getTileType()),2,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(1, 4).getTileType()),2,5);

                    bookShelf4.add(setTiles(player.getBookshelf().getTile(2, 0).getTileType()),3,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(2, 1).getTileType()),3,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(2, 2).getTileType()),3,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(2, 3).getTileType()),3,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(2, 4).getTileType()),3,5);

                    bookShelf4.add(setTiles(player.getBookshelf().getTile(3, 0).getTileType()),4,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(3, 1).getTileType()),4,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(3, 2).getTileType()),4,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(3, 3).getTileType()),4,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(3, 4).getTileType()),4,5);

                    bookShelf4.add(setTiles(player.getBookshelf().getTile(4, 0).getTileType()),5,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(4, 1).getTileType()),5,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(4, 2).getTileType()),5,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(4, 3).getTileType()),5,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(4, 4).getTileType()),5,5);

                    bookShelf4.add(setTiles(player.getBookshelf().getTile(5, 0).getTileType()),6,1);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(5, 1).getTileType()),6,2);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(5, 2).getTileType()),6,3);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(5, 3).getTileType()),6,4);
                    bookShelf4.add(setTiles(player.getBookshelf().getTile(5, 4).getTileType()),6,5);
                }
            }
        }*/
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
                default -> {
                }
            }

            personalGoalCardPlayer1.setVisible(true);
            personalGoalCardPlayer3.setVisible(true);

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
                default -> {
                }
            }

            personalGoalCardPlayer1.setVisible(true);
            personalGoalCardPlayer2.setVisible(true);
            personalGoalCardPlayer3.setVisible(true);

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
                default -> {
                }
            }

            personalGoalCardPlayer1.setVisible(true);
            personalGoalCardPlayer2.setVisible(true);
            personalGoalCardPlayer3.setVisible(true);
            personalGoalCardPlayer4.setVisible(true);

        }
    }

    /**
     * This method is called  set the chair of the first player
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
                        case 2 -> chairPlayer3.setVisible(true);
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

    /**
     * This method is called to convert the tile type into an image
     * @param tileType the type of the tile
     * @return the image of the tile
     */
    public ImageView setTiles(TileType tileType) {

        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String imageName = null;

        switch (tileType) {
            case CAT:
                switch (randomNumber) {
                    case 0 -> imageName = "Gatti1.png";
                    case 1 -> imageName = "Gatti2.png";
                    case 2 -> imageName = "Gatti3.png";
                    default -> {
                    }
                }
                break;
            case BOOK:
                switch (randomNumber) {
                    case 0 -> imageName = "Libri1.png";
                    case 1 -> imageName = "Libri2.png";
                    case 2 -> imageName = "Libri3.png";
                    default -> {
                    }
                }
                break;
            case GAME:
                switch (randomNumber) {
                    case 0 -> imageName = "Giochi1.png";
                    case 1 -> imageName = "Giochi2.png";
                    case 2 -> imageName = "Giochi3.png";
                    default -> {
                    }
                }
                break;
            case FRAME:
                switch (randomNumber) {
                    case 0 -> imageName = "Cornici1.png";
                    case 1 -> imageName = "Cornici2.png";
                    case 2 -> imageName = "Cornici3.png";
                    default -> {
                    }
                }
                break;
            case TROPHIE:
                switch (randomNumber) {
                    case 0 -> imageName = "Trofei1.png";
                    case 1 -> imageName = "Trofei2.png";
                    case 2 -> imageName = "Trofei3.png";
                    default -> {
                    }
                }
                break;
            case PLANT:
                switch (randomNumber) {
                    case 0 -> imageName = "Piante1.png";
                    case 1 -> imageName = "Piante2.png";
                    case 2 -> imageName = "Piante3.png";
                    default -> {
                    }
                }
                break;
        }

        Image image =  new Image("images/itemTiles/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(48);
        imageView.setFitWidth(48);
        return imageView;
    }

    public ImageView getTiles(ImageView imageName){
       /* if (imageName != null) {
            Image image =  new Image(getClass().getResourceAsStream("/resources/images/itemTiles/" + imageName));
            ImageView imageView = new ImageView(image);
            return imageView;
        } else {
            return null;
        }*/
        return null;
    }

    public boolean isCellValid(Tile tile){
        return switch (tile.getRow()) {
            case 0 -> tile.getCol() == 3 || tile.getCol() == 4;
            case 1, 7 -> tile.getCol() == 3 || tile.getCol() == 4 || tile.getCol() == 5;
            case 2, 6 -> tile.getCol() != 0 && tile.getCol() != 1 && tile.getCol() != 7 && tile.getCol() != 8;
            case 3 -> tile.getCol() != 0;
            case 4 -> true;
            case 5 -> tile.getCol() != 8;
            case 8 -> tile.getCol() == 4 || tile.getCol() == 5;
            default -> false;
        };
    }

    public void openChatButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showChat);
    }

    public void quitButtonClicked(ActionEvent event) {
        System.exit(1);
    }

    public void leaderboardButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showLeaderboard);
    }

}