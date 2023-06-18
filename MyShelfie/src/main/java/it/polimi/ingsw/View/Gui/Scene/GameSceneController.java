package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.animation.PauseTransition;
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
import javafx.util.Duration;

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
    private Button confirmTileSelectionButton;
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
    boolean yourTurn = false;
    private ArrayList<Tile> chosenTiles = new ArrayList<>();
    private ArrayList<Integer> availableColumns = new ArrayList<>();
    private ArrayList<Tile> orderedList = new ArrayList<>();
    private int counter = 0;
    private int numOfPlayers;
    private int numOfSelectedTiles = 0;
    private LivingRoom livingRoom = new LivingRoom();
    private int i = 0;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmTileSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmTileSelectionButtonClicked(event, chosenTiles));
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
        openChatButton.setOnAction(this::openChatButtonClicked);
        quitButton.setOnAction(this::quitButtonClicked);
        leaderboardButton.setOnAction(this::leaderboardButtonClicked);
    }

    /**
     * This method is called to set up the initial game scene
     * @param game the current game
     */
    public synchronized void setUp(Game game){
        confirmTileSelectionButton.setVisible(false);

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

    public void showMessage(String message){
        Platform.runLater(() -> {
            GuiController.showBanner("INFO", message);
        });
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

        Node selection = event.getPickResult().getIntersectedNode();
        Integer row = GridPane.getRowIndex(selection);
        Integer col = GridPane.getColumnIndex(selection);

        if(row != null && col != null && numOfSelectedTiles < 3 && yourTurn){
            Tile selectedTile = this.livingRoom.getTile(row-1,col-1);

            if(validCellForNumOfPlayers(selectedTile)){
                for(Tile tile : chosenTiles){
                    if(tile.equals(selectedTile)){
                        selection.setEffect(null);
                        numOfSelectedTiles--;
                        chosenTiles.remove(tile);
                        return;
                    }
                }

                selection.setEffect(new DropShadow(10, Color.YELLOW));
                numOfSelectedTiles++;
                chosenTiles.add(selectedTile);

                if(numOfSelectedTiles > 0)
                    confirmTileSelectionButton.setVisible(true);
                else
                    confirmTileSelectionButton.setVisible(false);
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
    public void tileOrder(ArrayList<Tile> chosenTiles) {
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
     * This method is used to set the style of the tile
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
        ArrayList<TileType> tmpList = new ArrayList<>();
        setCounter(getCounter()+1);

        //sets the number above the tile to show the order
        if (tile1.equals(tile)) {
            numberOfTile1.getStyleClass().clear();
            numberOfTile1.getStyleClass().add("generalNumber" + getCounter());
        } else if (tile2.equals(tile)) {
            numberOfTile2.getStyleClass().clear();
            numberOfTile2.getStyleClass().add("generalNumber" + getCounter());
        } else if (tile3.equals(tile)) {
            numberOfTile3.getStyleClass().clear();
            numberOfTile3.getStyleClass().add("generalNumber" + getCounter());
        }
        orderedList.add(chosenTiles.get(i));
        i++;

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
            i = 0;
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            tile1.setEffect(null);
            tile1.setVisible(false);
            tile2.setEffect(null);
            tile2.setVisible(false);
            tile3.setEffect(null);
            tile3.setVisible(false);
        });
        pause.play();
    }

    private void setCounter(int counter) {
        this.counter = counter;
    }

    private int getCounter() {
        return counter;
    }

    /**
     * This method shows the banner when the player has to choose the column to put the tiles in and shows the arrows above the available columns
     */
    public void selectColumn(ArrayList<Integer> AvailableColumns, Player player){
        Platform.runLater(() -> GuiController.showBanner("INFO", "Choose the column to put the tiles in"));
        if (player.getGame().getPlayers().size() == 2) {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB1C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB3C5.setVisible(true);
            }
        } else if (player.getGame().getPlayers().size() == 3) {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB1C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB2C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB3C5.setVisible(true);
            }

        } else {
            if(player.getGame().getPlayers().get(0).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB1C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB1C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB1C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB1C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB1C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(1).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB2C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB2C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB2C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB2C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB2C5.setVisible(true);
            }else if(player.getGame().getPlayers().get(2).equals(player)){
                if(AvailableColumns.contains(1))
                    arrowB3C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB3C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB3C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB3C4.setVisible(true);
                if(AvailableColumns.contains(5))
                    arrowB3C5.setVisible(true);
            }else{
                if(AvailableColumns.contains(1))
                    arrowB4C1.setVisible(true);
                if(AvailableColumns.contains(2))
                    arrowB4C2.setVisible(true);
                if(AvailableColumns.contains(3))
                    arrowB4C3.setVisible(true);
                if(AvailableColumns.contains(4))
                    arrowB4C4.setVisible(true);
                if(AvailableColumns.contains(5))
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
                obs.updateChosenColumn(columnNumber, availableColumns);
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
        yourTurn = false;
    }

    /**
     * This method is called to update the tiles on the living room board
     * @param livingRoom of the current game
     */
    public synchronized void updateLivingRoom(LivingRoom livingRoom){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(isCellValid(livingRoom.getTile(i,j))){
                    this.livingRoom.setTile(livingRoom.getTile(i,j),i,j);

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
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
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
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
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
                                bookShelf1.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 1 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf2.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 2 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf3.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
                            }
                        }
                    }
                }
                case 3 ->{
                    for(int i=0; i<6; i++){
                        for(int j=0; j<5; j++){
                            if(player.getBookshelf().getTile(i,j).getTileType() != NULL) {
                                bookShelf4.add(resizeTiles(setTiles(player.getBookshelf().getTile(i, j).getTileType())), j + 1, i + 1);
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
     * This method is called to resize thr tiles for the bookshelf
     * @param imageName od the tile
     * @return the image of the tile
     */
    public ImageView resizeTiles(ImageView imageName){
        imageName.setFitHeight(24);
        imageName.setFitWidth(24);
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

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
}