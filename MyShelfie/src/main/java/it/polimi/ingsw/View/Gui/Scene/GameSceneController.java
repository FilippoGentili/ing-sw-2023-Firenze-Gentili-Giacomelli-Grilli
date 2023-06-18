package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static it.polimi.ingsw.Model.TileType.NULL;

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
    @FXML
    private AnchorPane arrowB1C1;
    @FXML
    private AnchorPane arrowB1C2;
    @FXML
    private AnchorPane arrowB1C3;
    @FXML
    private AnchorPane arrowB1C4;
    @FXML
    private AnchorPane arrowB1C5;
    @FXML
    private AnchorPane arrowB2C1;
    @FXML
    private AnchorPane arrowB2C2;
    @FXML
    private AnchorPane arrowB2C3;
    @FXML
    private AnchorPane arrowB2C4;
    @FXML
    private AnchorPane arrowB2C5;
    @FXML
    private AnchorPane arrowB3C1;
    @FXML
    private AnchorPane arrowB3C2;
    @FXML
    private AnchorPane arrowB3C3;
    @FXML
    private AnchorPane arrowB3C4;
    @FXML
    private AnchorPane arrowB3C5;
    @FXML
    private AnchorPane arrowB4C1;
    @FXML
    private AnchorPane arrowB4C2;
    @FXML
    private AnchorPane arrowB4C3;
    @FXML
    private AnchorPane arrowB4C4;
    @FXML
    private AnchorPane arrowB4C5;
    boolean yourTurn = false;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmTileOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmTileOrderButtonClicked(event, new ArrayList<>()));
        confirmTileSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmTileSelectionButtonClicked(event, new ArrayList<>()));
        arrowB1C1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(1,1, arrowB1C1));
        arrowB1C2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(1,2, arrowB1C2));
        arrowB1C3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(1,3, arrowB1C3));
        arrowB1C4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(1,4, arrowB1C4));
        arrowB1C5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(1,5, arrowB1C5));
        arrowB2C1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(2,1, arrowB2C1));
        arrowB2C2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(2,2, arrowB2C2));
        arrowB2C3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(2,3, arrowB2C3));
        arrowB2C4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(2,4, arrowB2C4));
        arrowB2C5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(2,5, arrowB2C5));
        arrowB3C1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(3,1, arrowB3C1));
        arrowB3C2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(3,2, arrowB3C2));
        arrowB3C3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(3,3, arrowB3C3));
        arrowB3C4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(3,4, arrowB3C4));
        arrowB3C5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(3,5, arrowB3C5));
        arrowB4C1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(4,1, arrowB4C1));
        arrowB4C2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(4,2, arrowB4C2));
        arrowB4C3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(4,3, arrowB4C3));
        arrowB4C4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(4,4, arrowB4C4));
        arrowB4C5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> arrowClicked(4,5, arrowB4C5));
        confirmColumnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmColumnButtonClicked(event, 0,  new ArrayList<>()));
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

        arrowB1C1.setVisible(false);
        arrowB1C2.setVisible(false);
        arrowB1C3.setVisible(false);
        arrowB1C4.setVisible(false);
        arrowB1C5.setVisible(false);

        arrowB2C1.setVisible(false);
        arrowB2C2.setVisible(false);
        arrowB2C3.setVisible(false);
        arrowB2C4.setVisible(false);
        arrowB2C5.setVisible(false);

        arrowB3C1.setVisible(false);
        arrowB3C2.setVisible(false);
        arrowB3C3.setVisible(false);
        arrowB3C4.setVisible(false);
        arrowB3C5.setVisible(false);

        arrowB4C1.setVisible(false);
        arrowB4C2.setVisible(false);
        arrowB4C3.setVisible(false);
        arrowB4C4.setVisible(false);
        arrowB4C5.setVisible(false);

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

    /**
     * This method shows thw banner when the player has to choose the tiles from the board
     */
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
        Node source = (Node) event.getSource();
        Integer columnIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        int numberOfTiles = 0;
        ObservableList<Node> children = boardGrid.getChildren();
        for(Node node : children) {
            if(node instanceof ImageView) {
                if(node.getBoundsInParent().contains(event.getSceneX(), event.getSceneY())) {
                    if (yourTurn) {
                        node.setEffect(new DropShadow(10, Color.YELLOW));
                        numberOfTiles++;
                        //se cliccato di nuovo sopra
                        //numberOfTiles--;
                        //add tiles to chosen tiles
                        if(numberOfTiles>1) {
                            confirmTileSelectionButton.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called when the confirm button is clicked for the chosen tiles
     * @param event mouse event
     */
    public void confirmTileSelectionButtonClicked(MouseEvent event, ArrayList<Tile> chosenTiles){
        confirmTileSelectionButton.setVisible(false);

        notifyObserver(obs -> {
            try {
                obs.updateChosenTiles(chosenTiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    /**
     * This method shows thw banner when the player has to choose the order for the tiles
     */
    public void tileOrder() {
        Platform.runLater(() -> {
            GuiController.showBanner("INFO", "Choose the order of the tiles");
        });
    }

    /**
     * This method is used to select the order of the tiles
     */
    public void oderClicked(){

    }

    /**
     * This method is called when the confirm button is clicked for the chosen tiles
     * @param event mouse event
     */
    private void confirmTileOrderButtonClicked(MouseEvent event, ArrayList<Tile> orderedTiles) {
        confirmTileOrderButton.setVisible(false);

        notifyObserver(obs -> {
            try {
                obs.updateOrderedTiles(orderedTiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * This method shows the banner when the player has to choose the column to put the tiles in and shows the arrows above the available columns
     */
    public void selectColumn(Game game, Player player, ArrayList<Integer> AvailableColumns){
        Platform.runLater(() -> GuiController.showBanner("INFO", "Choose the column to put the tiles in"));
        if (game.getPlayers().size() == 2) {
            if(game.getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
            }
        } else if (game.getPlayers().size() == 3) {
            if(game.getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
            }else if(game.getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C4.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
            }

        } else {
            if(game.getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
            }else if(game.getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C4.setVisible(true);
            }else if(game.getPlayers().get(2).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB4C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB4C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB4C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB4C4.setVisible(true);
            }

        }

    }

    /**
     * This is method is called when the arrow above the column is clicked
     */
    public int arrowClicked(int bookshelfNumber, int columnNumber, AnchorPane arrow){
        confirmColumnButton.setVisible(true);
        arrow.setEffect(new DropShadow(10, Color.YELLOW));

        return columnNumber;
    }


    /**
     * This method is called when the confirm button is clicked for the chosen column
     * @param event mouse event
     */
    public void confirmColumnButtonClicked(MouseEvent event, int column, ArrayList<Integer> AvailableColumns) {
        confirmColumnButton.setVisible(false);

        arrowB1C1.setVisible(false);
        arrowB1C2.setVisible(false);
        arrowB1C3.setVisible(false);
        arrowB1C4.setVisible(false);
        arrowB1C5.setVisible(false);

        arrowB2C1.setVisible(false);
        arrowB2C2.setVisible(false);
        arrowB2C3.setVisible(false);
        arrowB2C4.setVisible(false);
        arrowB2C5.setVisible(false);

        arrowB3C1.setVisible(false);
        arrowB3C2.setVisible(false);
        arrowB3C3.setVisible(false);
        arrowB3C4.setVisible(false);
        arrowB3C5.setVisible(false);

        arrowB4C1.setVisible(false);
        arrowB4C2.setVisible(false);
        arrowB4C3.setVisible(false);
        arrowB4C4.setVisible(false);
        arrowB4C5.setVisible(false);

        notifyObserver(obs -> {
            try {
                obs.updateChosenColumn(column, AvailableColumns);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
       Game game = player.getGame();
        int index = game.getPlayers().indexOf(player);
        if (game.getPlayers().size() == 2) {
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
            }
        }else if(game.getPlayers().size()==3){
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
            }
        }else if(game.getPlayers().size()==4){
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 3 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf4.add(setTiles(player.getBookshelf().getTile(i, j).getTileType()), j + 1, i + 1);
                            }
                        }
                    }
                }
            }
        }
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

    /**
     * This method isa called to get the correct image of the tile form the board
     * @param imageName od the tile
     * @return the image of the tile
     */
    public ImageView getTiles(ImageView imageName){
        return imageName;
    }

    /**
     * This method is called to check if the cell of the living room is valid
     * @param tile of the cell
     * @return true if the cell is valid, false otherwise
     */
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

    /**
     * This method is called to open the chat from the menu bar
     * @param event mouse click
     */
    public void openChatButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showChat);
    }

    /**
     * This method is called to quit the game from the menu bar
     * @param event mouse click
     */
    public void quitButtonClicked(ActionEvent event) {
        System.exit(1);
    }

    /**
     * This method is called to open the leaderboard from the menu bar
     * @param event mouse click
     */
    public void leaderboardButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showLeaderboard);
    }

}