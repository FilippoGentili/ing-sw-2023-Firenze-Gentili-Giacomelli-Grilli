package it.polimi.ingsw.View.Gui.Scene;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.Observer.ViewObservable;
import it.polimi.ingsw.View.Gui.GuiController;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import javax.swing.text.Position;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    private TextField tilesField;
    @FXML
    private MenuItem openChatButton;
    boolean yourTurn = false;

    @FXML
    public void initialize() {
        boardGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, this::tileClicked);
        confirmTileOrderButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmTileOrderButtonClicked(event, new ArrayList<>()));
        confirmColumnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> confirmColumnButtonClicked(event, new ArrayList<>()));
        confirmTileSelectionButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::confirmTileSelectionButtonClicked);
        openChatButton.setOnAction(this::openChatButtonClicked);
    }

    /**
     * This method is called to set up the initial game scene
     * @param game the current game
     */
    public void setUp(Game game){
        confirmTileOrderButton.setVisible(false);
        confirmTileSelectionButton.setVisible(false);
        confirmColumnButton.setVisible(false);
        tilesField.setVisible(false);

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
        }
    }

    public void confirmTileSelectionButtonClicked(MouseEvent event){

    }

    /**
     * Tjis is method is called when the player has to choose the column to put the tiles in
     */
    public void selectColumn(){
        tilesField.setVisible(true);
        String input = tilesField.getText();
        if (input != null) {
            confirmColumnButton.setVisible(true);
        }
    }

    public void confirmColumnButtonClicked(MouseEvent event, ArrayList<Integer> AvailableColumns) {
        confirmColumnButton.setVisible(false);
        boolean correct = false;
        int col = 0;
        String input;

        do {
             input = tilesField.getText();
            tilesField.setVisible(false);

            if (input.matches("\\d+")) {
                col = parseInt(input);
                correct = AvailableColumns.contains(col - 1);
                if (!correct)
                    Platform.runLater(() -> {
                        GuiController.showBanner("Try again", "The column is full");
                    });
            } else {
                Platform.runLater(() -> {
                    GuiController.showBanner("Error", "Input not valid");
                });
            }
        }while(!correct || !input.matches("\\d+"));

        final int choice = col-1;

        notifyObserver(obs -> {
            try {
                obs.updateChosenColumn(choice, AvailableColumns);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        tilesField.clear();
    }

    /**
     * This method is called when the player has to choose the order of the tiles to put in the bookshelf
     */
    public void tileOrder() {
        tilesField.setVisible(true);
        String tile = tilesField.getText();
        if (tile != null) {
            confirmTileOrderButton.setVisible(true);
        }
    }

    /**
     * This method is called when the confirm button is clicked for the chosen tiles and also for the order for those tiles
     * @param event mouse event
     */
    private void confirmTileOrderButtonClicked(MouseEvent event, ArrayList<Tile> chosenTiles) {
        confirmTileOrderButton.setVisible(false);
        String input;

        ArrayList<Tile> orderedTiles = new ArrayList<>();
        ArrayList<String> tilesTypes = new ArrayList<>();

        if(chosenTiles.size() > 1){
            int i=1;
            do{
                for (Tile tile : chosenTiles){
                    tilesTypes.add(tile.getTileType().toString());
                }
                input = tilesField.getText();

                if(!tilesTypes.contains(input)) {
                    Platform.runLater(() -> {
                        GuiController.showBanner("Try again", "You don't have that tile");
                    });
                }else{
                    for (int x=0; x<chosenTiles.size(); x++) {
                        if (input.equals(chosenTiles.get(x).getTileType().toString())) {
                            orderedTiles.add(chosenTiles.get(x));
                            chosenTiles.remove(x);
                            tilesTypes.remove(x);
                            break;
                        }
                    }
                    i++;
                }

            }while(!chosenTiles.toString().contains(input) && chosenTiles.size()>0);
        }else{
            orderedTiles.add(chosenTiles.get(0));
        }

        notifyObserver(obs -> {
            try {
                obs.updateOrderedTiles(orderedTiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        tilesField.clear();
        yourTurn = false;

    }

    /**
     * This method is called to update the tiles on the living room board
     * @param livingRoom of the current game
     */
    public void updateLivingRoom(LivingRoom livingRoom){

        ObservableList<Node> livingRoomSpaces = boardGrid.getChildren();
        for(Node node : livingRoomSpaces){
            if(isCellValid(node)){

                boardGrid.add(setTiles(livingRoom.getTile(GridPane.getRowIndex(node),GridPane.getColumnIndex(node)).getTileType()), GridPane.getRowIndex(node)+1, GridPane.getColumnIndex(node)+1);
            }
        }
        /*boardGrid.add(setTiles(livingRoom.getTile(0,3).getTileType()),1,4);
        boardGrid.add(setTiles(livingRoom.getTile(0,4).getTileType()),1,5);

        boardGrid.add(setTiles(livingRoom.getTile(1,3).getTileType()),2,4);
        boardGrid.add(setTiles(livingRoom.getTile(1,4).getTileType()),2,5);
        boardGrid.add(setTiles(livingRoom.getTile(1,5).getTileType()),2,6);

        boardGrid.add(setTiles(livingRoom.getTile(2,2).getTileType()),3,3);
        boardGrid.add(setTiles(livingRoom.getTile(2,3).getTileType()),3,4);
        boardGrid.add(setTiles(livingRoom.getTile(2,4).getTileType()),3,5);
        boardGrid.add(setTiles(livingRoom.getTile(2,5).getTileType()),3,6);
        boardGrid.add(setTiles(livingRoom.getTile(2,6).getTileType()),3,7);

        boardGrid.add(setTiles(livingRoom.getTile(3,1).getTileType()),4,2);
        boardGrid.add(setTiles(livingRoom.getTile(3,2).getTileType()),4,3);
        boardGrid.add(setTiles(livingRoom.getTile(3,3).getTileType()),4,4);
        boardGrid.add(setTiles(livingRoom.getTile(3,4).getTileType()),4,5);
        boardGrid.add(setTiles(livingRoom.getTile(3,5).getTileType()),4,6);
        boardGrid.add(setTiles(livingRoom.getTile(3,6).getTileType()),4,7);
        boardGrid.add(setTiles(livingRoom.getTile(3,7).getTileType()),4,8);
        boardGrid.add(setTiles(livingRoom.getTile(3,8).getTileType()),4,9);

        boardGrid.add(setTiles(livingRoom.getTile(4,0).getTileType()),5,1);
        boardGrid.add(setTiles(livingRoom.getTile(4,1).getTileType()),5,2);
        boardGrid.add(setTiles(livingRoom.getTile(4,2).getTileType()),5,3);
        boardGrid.add(setTiles(livingRoom.getTile(4,3).getTileType()),5,4);
        boardGrid.add(setTiles(livingRoom.getTile(4,4).getTileType()),5,5);
        boardGrid.add(setTiles(livingRoom.getTile(4,5).getTileType()),5,6);
        boardGrid.add(setTiles(livingRoom.getTile(4,6).getTileType()),5,7);
        boardGrid.add(setTiles(livingRoom.getTile(4,7).getTileType()),5,8);
        boardGrid.add(setTiles(livingRoom.getTile(4,8).getTileType()),5,9);

        boardGrid.add(setTiles(livingRoom.getTile(5,0).getTileType()),6,1);
        boardGrid.add(setTiles(livingRoom.getTile(5,1).getTileType()),6,2);
        boardGrid.add(setTiles(livingRoom.getTile(5,2).getTileType()),6,3);
        boardGrid.add(setTiles(livingRoom.getTile(5,3).getTileType()),6,4);
        boardGrid.add(setTiles(livingRoom.getTile(5,4).getTileType()),6,5);
        boardGrid.add(setTiles(livingRoom.getTile(5,5).getTileType()),6,6);
        boardGrid.add(setTiles(livingRoom.getTile(5,6).getTileType()),6,7);
        boardGrid.add(setTiles(livingRoom.getTile(5,7).getTileType()),6,8);

        boardGrid.add(setTiles(livingRoom.getTile(6,2).getTileType()),7,3);
        boardGrid.add(setTiles(livingRoom.getTile(6,3).getTileType()),7,4);
        boardGrid.add(setTiles(livingRoom.getTile(6,4).getTileType()),7,5);
        boardGrid.add(setTiles(livingRoom.getTile(6,5).getTileType()),7,6);
        boardGrid.add(setTiles(livingRoom.getTile(6,6).getTileType()),7,7);

        boardGrid.add(setTiles(livingRoom.getTile(7,3).getTileType()),8,4);
        boardGrid.add(setTiles(livingRoom.getTile(7,4).getTileType()),8,5);
        boardGrid.add(setTiles(livingRoom.getTile(7,5).getTileType()),8,6);

        boardGrid.add(setTiles(livingRoom.getTile(8,4).getTileType()),9,5);
        boardGrid.add(setTiles(livingRoom.getTile(8,5).getTileType()),9,6);*/
    }

    /**
     * This method is called to update the tiles on the bookshelf
     * @param player of the bookshelf
     */
    public void updateBookShelf(Player player){
        Game game = player.getGame();
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
                    case 0:
                        imageName = "Gatti1.png";
                    case 1:
                        imageName = "Gatti2.png";
                    case 2:
                        imageName = "Gatti3.png";
                }
                break;
            case BOOK:
                switch (randomNumber) {
                    case 0:
                        imageName = "Libri1.png";
                    case 1:
                        imageName = "Libri2.png";
                    case 2:
                        imageName = "Libri3.png";
                }
                break;
            case GAME:
                switch (randomNumber) {
                    case 0:
                        imageName = "Giochi1.png";
                    case 1:
                        imageName = "Giochi2.png";
                    case 2:
                        imageName = "Giochi3.png";
                }
                break;
            case FRAME:
                switch (randomNumber) {
                    case 0:
                        imageName = "Cornici1.png";
                    case 1:
                        imageName = "Cornici2.png";
                    case 2:
                        imageName = "Cornici3.png";
                }
                break;
            case TROPHIE:
                switch (randomNumber) {
                    case 0:
                        imageName = "Trofei1.png";
                    case 1:
                        imageName = "Trofei2.png";
                    case 2:
                        imageName = "Trofei3.png";
                }
                break;
            case PLANT:
                switch (randomNumber) {
                    case 0:
                        imageName = "Piante1.png";
                    case 1:
                        imageName = "Piante2.png";
                    case 2:
                        imageName = "Piante3.png";
                }
                break;
            case NULL:
                break;
            }

        if (imageName != null) {
            Image image =  new Image(getClass().getResourceAsStream("images/itemTiles/" + imageName));
            ImageView imageView = new ImageView(image);
            return imageView;
        } else {
            return null;
        }
    }

    public ImageView getTiles(ImageView imageName){
        if (imageName != null) {
            Image image =  new Image(getClass().getResourceAsStream("/resources/images/itemTiles/" + imageName));
            ImageView imageView = new ImageView(image);
            return imageView;
        } else {
            return null;
        }
    }

    public boolean isCellValid(Node node){
        switch (GridPane.getRowIndex(node)){
            case 0:
                if(GridPane.getColumnIndex(node) == 3 || GridPane.getColumnIndex(node) == 4) return true;
                else return false;
            case 1,7:
                if(GridPane.getColumnIndex(node) == 3 || GridPane.getColumnIndex(node) == 4 || GridPane.getColumnIndex(node) == 5) return true;
                else return false;
            case 2,6:
                if(GridPane.getColumnIndex(node) == 0 || GridPane.getColumnIndex(node) == 1 || GridPane.getColumnIndex(node) == 7 || GridPane.getColumnIndex(node) == 8) return false;
                else return true;
            case 3:
                if(GridPane.getColumnIndex(node) == 0) return false;
                else return true;
            case 4:
                return true;
            case 5:
                if(GridPane.getColumnIndex(node) == 8) return false;
                else return true;
            case 8:
                if(GridPane.getColumnIndex(node) == 4 || GridPane.getColumnIndex(node) == 5) return true;
                else return false;
            default:
                return false;
        }
    }

    public void enterButtonClicked(KeyEvent keyEvent) {
    }

    public void openChatButtonClicked(ActionEvent event) {
        Platform.runLater(GuiController::showChat);
    }
}
