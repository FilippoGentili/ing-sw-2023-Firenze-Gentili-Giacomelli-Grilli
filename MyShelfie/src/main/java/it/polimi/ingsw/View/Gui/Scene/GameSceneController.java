package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static it.polimi.ingsw.Model.TileType.NULL;
import static it.polimi.ingsw.View.Gui.GuiController.*;

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
    private Button confirmTileSelectionButton;
    @FXML
    private MenuItem openChatButton;
    @FXML
    private MenuItem quitButton;
    @FXML
    private MenuItem leaderboardButton;
    @FXML
    private MenuItem rulebookButton;
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
    @FXML
    private AnchorPane tile1;
    @FXML
    private AnchorPane tile2;
    @FXML
    private AnchorPane tile3;
    @FXML
    private AnchorPane numberOfTile1;
    @FXML
    private AnchorPane numberOfTile2;
    @FXML
    private AnchorPane numberOfTile3;
    @FXML
    private AnchorPane endGameToken;
    @FXML
    private AnchorPane endGameP1;
    @FXML
    private AnchorPane endGameP2;
    @FXML
    private AnchorPane endGameP3;
    @FXML
    private AnchorPane endGameP4;
    @FXML
    private AnchorPane commonGoalP1C1;
    @FXML
    private AnchorPane commonGoalP1C2;
    @FXML
    private AnchorPane commonGoalP2C1;
    @FXML
    private AnchorPane commonGoalP2C2;
    @FXML
    private AnchorPane commonGoalP3C1;
    @FXML
    private AnchorPane commonGoalP3C2;
    @FXML
    private AnchorPane commonGoalP4C1;
    @FXML
    private AnchorPane commonGoalP4C2;
    @FXML
    private AnchorPane commonPoints1;
    @FXML
    private AnchorPane commonPoints2;
    boolean yourTurn = false;
    private ArrayList<Tile> chosenTiles = new ArrayList<>();
    private ArrayList<Integer> availableColumns = new ArrayList<>();
    private ArrayList<Tile> orderedList = new ArrayList<>();
    private int counter = 0;
    private int numOfPlayers;
    private int numOfSelectedTiles = 0;
    private boolean tile1Clicked = false;
    private boolean tile2Clicked = false;
    private boolean tile3Clicked = false;
    private boolean firstPlayerFullBookshelf = true;
    private boolean firstTime = true;
    private LivingRoom livingRoom = new LivingRoom();
    private Game gamePassed;

    /**
     * Initializes all the fields of the main game scene
     */
    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmTileSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmTileSelectionButtonClicked);
        tile1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> orderClicked(tile1, chosenTiles));
        tile2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> orderClicked(tile2, chosenTiles));
        tile3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> orderClicked(tile3, chosenTiles));
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
        commonGoalCard1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> commonGoalCardClicked(commonGoalCard1));
        commonGoalCard2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> commonGoalCardClicked(commonGoalCard2));
        openChatButton.setOnAction(event -> openChatButtonClicked(gamePassed));
        quitButton.setOnAction(this::quitButtonClicked);
        leaderboardButton.setOnAction(event -> leaderboardButtonClicked(gamePassed));
        rulebookButton.setOnAction(this::rulebookButtonClicked);
    }

    /**
     * Sets up the initial game scene
     * @param game the current game
     */
    public synchronized void setUp(Game game){
        confirmTileSelectionButton.setVisible(false);

        commonPoints1.setVisible(true);
        commonPoints2.setVisible(true);

        endGameToken.setVisible(true);
        endGameP1.setVisible(false);
        endGameP2.setVisible(false);
        endGameP3.setVisible(false);
        endGameP4.setVisible(false);

        commonGoalP1C1.setVisible(false);
        commonGoalP1C2.setVisible(false);
        commonGoalP2C1.setVisible(false);
        commonGoalP2C2.setVisible(false);
        commonGoalP3C1.setVisible(false);
        commonGoalP3C2.setVisible(false);
        commonGoalP4C1.setVisible(false);
        commonGoalP4C2.setVisible(false);

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

        tile1.setVisible(false);
        numberOfTile1.setVisible(false);
        tile2.setVisible(false);
        numberOfTile2.setVisible(false);
        tile3.setVisible(false);
        numberOfTile3.setVisible(false);

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
            bookshelfPlayer3.setVisible(true);
            namePlayer3.setVisible(true);
            namePlayer3.setText(game.getPlayers().get(1).getNickname());
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

    public void showMessage(String message){
        Platform.runLater(() -> {
            GuiController.showBanner("INFO", message);
        });
    }

    /**
     * Displays the current player in yellow
     * @param player current player
     */
    public void setVisualNames(Player player){
        if(namePlayer1.getText().equals(player.getNickname())){
            namePlayer1.setFill(Color.YELLOW);
            namePlayer2.setFill(Color.WHITE);
            namePlayer3.setFill(Color.WHITE);
            namePlayer4.setFill(Color.WHITE);
        }else if(namePlayer2.getText().equals(player.getNickname())){
            namePlayer1.setFill(Color.WHITE);
            namePlayer2.setFill(Color.YELLOW);
            namePlayer3.setFill(Color.WHITE);
            namePlayer4.setFill(Color.WHITE);
        }else if(namePlayer3.getText().equals(player.getNickname())){
            namePlayer1.setFill(Color.WHITE);
            namePlayer2.setFill(Color.WHITE);
            namePlayer3.setFill(Color.YELLOW);
            namePlayer4.setFill(Color.WHITE);
        } else if (namePlayer4.getText().equals(player.getNickname())) {
            namePlayer1.setFill(Color.WHITE);
            namePlayer2.setFill(Color.WHITE);
            namePlayer3.setFill(Color.WHITE);
            namePlayer4.setFill(Color.YELLOW);
        }
    }

    /**
     * Shows thw banner when the player has to choose the tiles from the board
     */
    public void selectTiles(){
        if(firstTime) {
            Platform.runLater(() -> {
                GuiController.showBanner("INFO", "Choose up to 3 tiles from the board");
            });
            yourTurn = true;
            firstTime = false;
        }else{
            Platform.runLater(() -> {
                GuiController.showBanner("INFO", "Invalid tiles, try again!");
            });
        }
    }

    /**
     * Handles the event of a tile being clicked during the current player's turn
     * @param event mouse event
     */
    public void tileClicked(MouseEvent event) {

        Node selection = event.getPickResult().getIntersectedNode();
        Integer row = GridPane.getRowIndex(selection);
        Integer col = GridPane.getColumnIndex(selection);

        if(row != null && col != null && yourTurn){
            if(numOfSelectedTiles < 3) {
                Tile selectedTile = this.livingRoom.getTile(row - 1, col - 1);

                if(selectedTile.getTileType() != TileType.NULL){
                    if (validCellForNumOfPlayers(selectedTile)) {
                        for (Tile tile : chosenTiles) {
                            if (tile.equals(selectedTile)) {
                                selection.setEffect(null);
                                numOfSelectedTiles--;
                                chosenTiles.remove(tile);

                                if (numOfSelectedTiles > 0)
                                    confirmTileSelectionButton.setVisible(true);
                                else
                                    confirmTileSelectionButton.setVisible(false);

                                return;
                            }
                        }

                        selection.setEffect(new DropShadow(10, Color.YELLOW));
                        InnerShadow innerShadow = new InnerShadow();
                        innerShadow.setChoke(0.5); // Imposta il grado di sfocatura dell'effetto
                        innerShadow.setColor(Color.YELLOW);
                        selection.setEffect(innerShadow);
                        numOfSelectedTiles++;
                        chosenTiles.add(selectedTile);

                        if (numOfSelectedTiles > 0)
                            confirmTileSelectionButton.setVisible(true);
                        else
                            confirmTileSelectionButton.setVisible(false);
                    }
                }
            }else{
                Tile selectedTile = this.livingRoom.getTile(row - 1, col - 1);

                if(selectedTile.getTileType() != TileType.NULL){
                    if (validCellForNumOfPlayers(selectedTile)) {

                        for(int i=0; i<chosenTiles.size(); i++){
                            if (chosenTiles.get(i).equals(selectedTile)) {
                                selection.setEffect(null);
                                numOfSelectedTiles--;
                                chosenTiles.remove(chosenTiles.get(i));
                            }
                        }
                    }

                    if (numOfSelectedTiles > 0)
                        confirmTileSelectionButton.setVisible(true);
                    else
                        confirmTileSelectionButton.setVisible(false);
                }
            }
        }
    }

    /**
     * Handles the confirm button being clicked for the chosen tiles
     * @param event mouse event
     */
    public void confirmTileSelectionButtonClicked(MouseEvent event){
        confirmTileSelectionButton.setVisible(false);

        if(yourTurn && !chosenTiles.isEmpty()) {
            notifyObserver(obs -> {
                try {
                    obs.updateChosenTiles(chosenTiles);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }

    /**
     * Shows the banner when the player has to choose the order for the tiles
     */
    public void tileOrder(ArrayList<Tile> chosenTiles) {

        if(this.chosenTiles.isEmpty()){
            this.chosenTiles.addAll(chosenTiles);
        }

        Platform.runLater(() -> GuiController.showBanner("INFO", "Choose the order of the tiles"));
        switch (chosenTiles.size()) {
            case 1 -> {
                tile2.setVisible(true);
                tile2.getStyleClass().clear();
                tile2.getStyleClass().add(setStyleTile(chosenTiles.get(0).getTileType()));
            }
            case 2 -> {
                tile1.setVisible(true);
                tile1.getStyleClass().clear();
                tile1.getStyleClass().add(setStyleTile(chosenTiles.get(0).getTileType()));
                tile3.setVisible(true);
                tile3.getStyleClass().clear();
                tile3.getStyleClass().add(setStyleTile(chosenTiles.get(1).getTileType()));
            }
            case 3 -> {
                tile1.setVisible(true);
                tile1.getStyleClass().clear();
                tile1.getStyleClass().add(setStyleTile(chosenTiles.get(0).getTileType()));
                tile2.setVisible(true);
                tile2.getStyleClass().clear();
                tile2.getStyleClass().add(setStyleTile(chosenTiles.get(1).getTileType()));
                tile3.setVisible(true);
                tile3.getStyleClass().clear();
                tile3.getStyleClass().add(setStyleTile(chosenTiles.get(2).getTileType()));
            }
            default -> {
            }
        }
    }

    /**
     * Sets the style of the tile
     * @param tileType of the chosen tile
     * @return the style of the tile
     */
    public String setStyleTile(TileType tileType){
        return switch (tileType) {
            case PLANT -> "generalPlants1";
            case BOOK -> "generalBooks1";
            case TROPHIE -> "generalTrophies1";
            case CAT -> "generalCats1";
            case FRAME -> "generalFrames1";
            case GAME -> "generalGames1";
            default -> "";
        };
    }

    /**
     * This method is used to select the order of the tiles
     */
    public void orderClicked(AnchorPane tile, ArrayList<Tile> chosenTiles){

        if (tile1.equals(tile) && !tile1Clicked) {
            setCounter(getCounter()+1);
            tile1Clicked = true;
            numberOfTile1.setVisible(true);
            numberOfTile1.getStyleClass().clear();
            numberOfTile1.getStyleClass().add("generalNumber" + getCounter());
            orderedList.add(chosenTiles.get(0));
        } else if (tile2.equals(tile) && !tile2Clicked) {
            setCounter(getCounter()+1);
            tile2Clicked = true;
            numberOfTile2.setVisible(true);
            numberOfTile2.getStyleClass().clear();
            numberOfTile2.getStyleClass().add("generalNumber" + getCounter());
            if(chosenTiles.size() == 1) {
                orderedList.add(chosenTiles.get(0));
            }else if(chosenTiles.size() == 3) {
                orderedList.add(chosenTiles.get(1));
            }
        } else if (tile3.equals(tile) && !tile3Clicked) {
            setCounter(getCounter()+1);
            tile3Clicked = true;
            numberOfTile3.setVisible(true);
            numberOfTile3.getStyleClass().clear();
            numberOfTile3.getStyleClass().add("generalNumber" + getCounter());
            if (chosenTiles.size() == 2) {
                orderedList.add(chosenTiles.get(1));
            }else if (chosenTiles.size() == 3) {
                orderedList.add(chosenTiles.get(2));
            }
        }

        if (orderedList.size() == chosenTiles.size()) {
            notifyObserver(obs -> {
                try {
                    obs.updateOrderedTiles(orderedList);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            orderedList.clear();
            setCounter(0);
            tile1Clicked = false;
            tile2Clicked = false;
            tile3Clicked = false;
            chosenTiles.clear();
            numOfSelectedTiles = 0;
            yourTurn = false;

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                tile1.setEffect(null);
                tile1.setVisible(false);
                numberOfTile1.setVisible(false);
                tile2.setEffect(null);
                tile2.setVisible(false);
                numberOfTile2.setVisible(false);
                tile3.setEffect(null);
                tile3.setVisible(false);
                numberOfTile3.setVisible(false);
            });
            pause.play();
        }
    }

    /**
     * @param counter to be set
     */
    private void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return the counter
     */
    private int getCounter() {
        return counter;
    }

    /**
     * Shows the banner when the player has to choose the column to put the tiles in and shows the arrows above the
     * available columns
     */
    public void selectColumn(ArrayList<Integer> AvailableColumns, Player player){
        Platform.runLater(() -> GuiController.showBanner("INFO", "Choose the column to put the tiles in"));
        firstTime = true;
        if (player.getGame().getPlayers().size() == 2) {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(0))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C5.setVisible(true);
            }
        } else if (player.getGame().getPlayers().size() == 3) {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(0))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C5.setVisible(true);
            }

        } else {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(2).equals(player)){
                if(AvailableColumns.contains(0))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(0))
                    arrowB4C1.setVisible(true);
                if(AvailableColumns.contains(1))
                    arrowB4C2.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB4C3.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB4C4.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB4C5.setVisible(true);
            }

        }
        setAvailableColumns(AvailableColumns);
    }

    /**
     * Setter of the available columns
     * @param availableColumns of a bookshelf
     */
    public void setAvailableColumns(ArrayList<Integer> availableColumns) {
        this.availableColumns = availableColumns;
    }

    /**
     * Getter of the available columns
     * @return available columns of a bookshelf
     */
    public ArrayList<Integer> getAvailableColumns() {
        return availableColumns;
    }

    /**
     * This is method is called when the arrow above the column is clicked
     */
    public void arrowClicked(int bookshelfNumber, int columnNumber, AnchorPane arrow){
        arrow.setEffect(new DropShadow(10, Color.YELLOW));
        ArrayList<Integer> availableColumns = getAvailableColumns();

        notifyObserver(obs -> {
            try {
                obs.updateChosenColumn(columnNumber-1, availableColumns);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            arrow.setEffect(null);
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
        });
        pause.play();
    }

    /**
     * Updates the tiles on the living room board
     * @param livingRoom of the current game
     */
    public synchronized void updateLivingRoom(LivingRoom livingRoom){
        boardGrid.getChildren().clear();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(isCellValid(livingRoom.getTile(i,j))){
                    this.livingRoom.setTile(livingRoom.getTile(i,j),i,j);
                    boardGrid.add(setTiles(livingRoom.getTile(i, j).getTileType()), j + 1, i + 1);
                }
            }
        }
    }

    /**
     * Updates the tiles on the bookshelf
     * @param player of the bookshelf
     */
    public synchronized void updateBookShelf(Player player){
        Game game = player.getGame();
        this.gamePassed = game;
        int index = game.getPlayers().indexOf(player);
        if (game.getPlayers().size() == 2) {
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf1);
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf3);
                }
            }
        }else if(game.getPlayers().size()==3){
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf1);
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf2);
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf3);
                }
            }
        }else if(game.getPlayers().size()==4){
            switch (index) {
                case 0 -> {
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf1);
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf2);
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf3);
                }
                case 3 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf4.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }

                    alignCenter(bookShelf4);
                }
            }
        }
    }

    /**
     * Sets the common goal cards of the game
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
     * Sets the personal goal cards of the players
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
     * Sets the chair of the first player
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
     * Converts the tile type into an image
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
            default:
                imageName = "Empty.png";
        }

        Image image =  new Image("images/itemTiles/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(48);
        imageView.setFitWidth(48);
        return imageView;
    }

    /**
     * Resizes the tiles for the bookshelf
     * @param imageName od the tile
     * @return the image of the tile
     */
    public ImageView resizeTiles(ImageView imageName){
        imageName.setFitHeight(25);
        imageName.setFitWidth(25);
        return imageName;
    }

    /**
     * Checks if the cell of the living room is valid
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
     * Checks if the selected tile is valid depending on the number of players
     * @param tile selected
     * @return true if is valid, false otherwise
     */
    public boolean validCellForNumOfPlayers(Tile tile){

        if(numOfPlayers == 2){
            return switch (tile.getRow()) {
                case 0,8 -> false;
                case 1 -> tile.getCol() == 3 || tile.getCol() == 4;
                case 2, 6 -> tile.getCol() == 3 || tile.getCol() == 4 || tile.getCol() == 5;
                case 3 -> tile.getCol() != 0 && tile.getCol() != 1 && tile.getCol() != 8;
                case 4 -> tile.getCol() != 0 && tile.getCol() != 8;
                case 5 -> tile.getCol() != 0 && tile.getCol() != 8 && tile.getCol() != 7;
                case 7 -> tile.getCol() == 4 || tile.getCol() == 5;
                default -> false;
            };
        }else if (numOfPlayers == 3){
            return switch (tile.getRow()) {
                case 0 -> tile.getCol() == 3;
                case 1 -> tile.getCol() == 3 || tile.getCol() == 4;
                case 2, 6 -> tile.getCol() != 0 && tile.getCol() != 1 && tile.getCol() != 7 && tile.getCol() != 8;
                case 3 -> tile.getCol() != 0 && tile.getCol() != 1;
                case 4 -> tile.getCol() != 0 && tile.getCol() != 8;
                case 5 -> tile.getCol() != 8 && tile.getCol() != 7;
                case 7 -> tile.getCol() == 4 || tile.getCol() == 5;
                case 8 -> tile.getCol() == 5;
                default -> false;
            };
        }else{
            return isCellValid(tile);
        }
    }

    /**
     * Opens the chat from the menu bar
     * @param game current game
     */
    public void openChatButtonClicked(Game game) {
        Platform.runLater(() -> showChat(game));
    }

    /**
     * Quits the game from the menu bar
     * @param event mouse click
     */
    public void quitButtonClicked(ActionEvent event) {
        notifyObserver(obs -> {
            try {
                obs.handleDisconnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Opens the leaderboard from the menu bar
     * @param game current game
     */
    public void leaderboardButtonClicked(Game game) {
        Platform.runLater(() -> showLeaderboard(game));
    }

    /**
     * Shows rulebook from the menu bar
     * @param event of type mouse clicked
     */
    public void rulebookButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showRulebook);
    }

    /**
     * Shows common goal card
     * @param commonGoal selected
     */
    public void commonGoalCardClicked(AnchorPane commonGoal) {
        String styleName = commonGoal.getStyleClass().get(0);
        Integer id = switch (styleName) {
            case "generalCommonGoalCard1" -> 1;
            case "generalCommonGoalCard2" -> 2;
            case "generalCommonGoalCard3" -> 3;
            case "generalCommonGoalCard4" -> 4;
            case "generalCommonGoalCard5" -> 5;
            case "generalCommonGoalCard6" -> 6;
            case "generalCommonGoalCard7" -> 7;
            case "generalCommonGoalCard8" -> 8;
            case "generalCommonGoalCard9" -> 9;
            case "generalCommonGoalCard10" -> 10;
            case "generalCommonGoalCard11" -> 11;
            case "generalCommonGoalCard12" -> 12;
            default -> 0;
        };

        Platform.runLater(() -> showCommonGoalCardInfo(id));
    }

    /**
     * Sets number of player
     * @param numOfPlayers to be set
     */
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    /**
     * Aligns center of gridPane
     * @param gridPane to be aligned
     */
    public void alignCenter(GridPane gridPane){
        ObservableList<Node> cells = gridPane.getChildren();

        for(Node node : cells){
            gridPane.setHalignment(node, HPos.CENTER);
            gridPane.setValignment(node, VPos.CENTER);
        }
    }

    /**
     * Updates the common goal card points
     * @param game current game
     */
    public void updateVisualCommonGoalCardPoints(Game game, int previousPointCGC1, int previousPointCGC2) {
        int currentPointCGC1 = game.getCommonGoal1().getValue();
        int currentPointCGC2 = game.getCommonGoal2().getValue();

        for (Player player : game.getPlayers()) {
            if (game.getCommonGoal1().check(player.getBookshelf()) && !player.getPointscg1()) {
                switch (game.getPlayers().size()) {
                    case 2 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C1.setVisible(true);
                            commonGoalP1C1.getStyleClass().clear();
                            commonGoalP1C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        } else {
                            commonGoalP3C1.setVisible(true);
                            commonGoalP3C1.getStyleClass().clear();
                            commonGoalP3C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        }
                    }
                    case 3 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C1.setVisible(true);
                            commonGoalP1C1.getStyleClass().clear();
                            commonGoalP1C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                            commonPoints1.getStyleClass().clear();
                        } else if (game.getPlayers().get(1).equals(player)) {
                            commonGoalP2C1.setVisible(true);
                            commonGoalP2C1.getStyleClass().clear();
                            commonGoalP2C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        } else {
                            commonGoalP3C1.setVisible(true);
                            commonGoalP3C1.getStyleClass().clear();
                            commonGoalP3C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        }
                    }
                    case 4 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C1.setVisible(true);
                            commonGoalP1C1.getStyleClass().clear();
                            commonGoalP1C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        } else if (game.getPlayers().get(1).equals(player)) {
                            commonGoalP2C1.setVisible(true);
                            commonGoalP2C1.getStyleClass().clear();
                            commonGoalP2C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        } else if (game.getPlayers().get(2).equals(player)) {
                            commonGoalP3C1.setVisible(true);
                            commonGoalP3C1.getStyleClass().clear();
                            commonGoalP3C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        } else {
                            commonGoalP4C1.setVisible(true);
                            commonGoalP4C1.getStyleClass().clear();
                            commonGoalP4C1.getStyleClass().add("generalScoring" + previousPointCGC1);
                        }
                    }
                    default -> {
                    }
                }
                commonPoints1.getStyleClass().clear();
                if (currentPointCGC1 == 0) {
                    commonPoints1.setVisible(false);
                } else {
                    commonPoints1.getStyleClass().add("generalScoring" + currentPointCGC1);
                }
            }

            if (game.getCommonGoal2().check(player.getBookshelf()) && !player.getPointscg2()) {
                switch (game.getPlayers().size()) {
                    case 2 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C2.setVisible(true);
                            commonGoalP1C2.getStyleClass().clear();
                            commonGoalP1C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        } else {
                            commonGoalP3C2.setVisible(true);
                            commonGoalP3C2.getStyleClass().clear();
                            commonGoalP3C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        }
                    }
                    case 3 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C2.setVisible(true);
                            commonGoalP1C2.getStyleClass().clear();
                            commonGoalP1C2.getStyleClass().add("generalScoring" + previousPointCGC2);

                        } else if (game.getPlayers().get(1).equals(player)) {
                            commonGoalP2C2.setVisible(true);
                            commonGoalP2C2.getStyleClass().clear();
                            commonGoalP2C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        } else {
                            commonGoalP3C2.setVisible(true);
                            commonGoalP3C2.getStyleClass().clear();
                            commonGoalP3C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        }
                    }
                    case 4 -> {
                        if (game.getPlayers().get(0).equals(player)) {
                            commonGoalP1C2.setVisible(true);
                            commonGoalP1C2.getStyleClass().clear();
                            commonGoalP1C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        } else if (game.getPlayers().get(1).equals(player)) {
                            commonGoalP2C2.setVisible(true);
                            commonGoalP2C2.getStyleClass().clear();
                            commonGoalP2C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        } else if (game.getPlayers().get(2).equals(player)) {
                            commonGoalP3C2.setVisible(true);
                            commonGoalP3C2.getStyleClass().clear();
                            commonGoalP3C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        } else {
                            commonGoalP4C2.setVisible(true);
                            commonGoalP4C2.getStyleClass().clear();
                            commonGoalP4C2.getStyleClass().add("generalScoring" + previousPointCGC2);
                        }
                    }
                    default -> {

                    }
                }
                commonPoints2.getStyleClass().clear();
                if (currentPointCGC2 == 0) {
                    commonPoints2.setVisible(false);
                } else {
                    commonPoints2.getStyleClass().add("generalScoring" + currentPointCGC2);
                }
            }
        }
    }


    /**
     * Updates the end game token
     * @param game of the player
     */
    public void updateVisualEndGameToken(Game game) {
        for (Player player : game.getPlayers()){
            if (player.getBookshelf().fullBookshelf() && firstPlayerFullBookshelf) {
                switch (player.getGame().getPlayers().size()) {
                    case 2 -> {
                        if (player.getGame().getPlayers().get(0).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP1.setVisible(true);
                            endGameToken.setVisible(false);
                        } else {
                            firstPlayerFullBookshelf = false;
                            endGameP3.setVisible(true);
                            endGameToken.setVisible(false);
                        }
                    }
                    case 3 -> {
                        if (player.getGame().getPlayers().get(0).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP1.setVisible(true);
                            endGameToken.setVisible(false);
                        } else if (player.getGame().getPlayers().get(1).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP2.setVisible(true);
                            endGameToken.setVisible(false);
                        } else {
                            firstPlayerFullBookshelf = false;
                            endGameP3.setVisible(true);
                            endGameToken.setVisible(false);
                        }
                    }
                    case 4 -> {
                        if (player.getGame().getPlayers().get(0).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP1.setVisible(true);
                            endGameToken.setVisible(false);
                        } else if (player.getGame().getPlayers().get(1).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP2.setVisible(true);
                            endGameToken.setVisible(false);
                        } else if (player.getGame().getPlayers().get(2).equals(player)) {
                            firstPlayerFullBookshelf = false;
                            endGameP3.setVisible(true);
                            endGameToken.setVisible(false);
                        } else {
                            firstPlayerFullBookshelf = false;
                            endGameP4.setVisible(true);
                            endGameToken.setVisible(false);
                        }
                    }
                    default -> {
                    }
                }

            }
        }
    }
}