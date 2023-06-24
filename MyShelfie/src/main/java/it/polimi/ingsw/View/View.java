package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Network.Message.ChatMessage;

import java.util.ArrayList;

public interface View {

    /**
     * @return chat of the client
     */
    Chat getChat();
    /**
     * @param message shown to the receiver
     */
    void showMessage(String message) ;

    /**
     * If nickname and connection are not valid asks them again
     * @param validNickname true if the nickname is valid, false otherwise
     * @param connection true if the connection is correctly established, false otherwise
     * @param nickname chosen by the client
     */
    void loginResult(boolean validNickname, boolean connection, String nickname);
    /**
     * Asks the client to insert a nickname. In gui changes the scene where the player can choose the nickname
     */
    void nicknameRequest();
    /**
     * Asks the first client connected to decide the number of players of the game. In gui change scene where the player
     * can choose the max number of players in the game.
     */
    void askNumberOfPlayers() ;

    /**
     * Displays a message from the chat
     * @param chat of the client who is receiving messages
     */
    void showChatMessages(Chat chat);

    /**
     * Asks the player in which to put the selected tiles
     * @param AvailableColumns for the specific player that have enough space for the number of tiles selected
     * @param player who is playing
     */
    void columnRequest(ArrayList<Integer> AvailableColumns, Player player);

    /**
     * Asks the player to select the tiles from the livingRoom, asking them again if errors occur
     * @param livingRoom where the player must select the tiles from
     */
    void TilesRequest(LivingRoom livingRoom) ;

    /**
     * Asks the player to order the selected tiles before inserting in the bookshelf
     * @param chosenTiles selected in previous action
     */
    void OrderTiles(ArrayList<Tile> chosenTiles) ;

    /**
     * Displays final scoreboard, ranking the player from first to last
     * @param scoreboard showing each player's points
     */
    void showScoreboard(ArrayList<Player> scoreboard);

    /**
     * Prints a message after a disconnection
     * @param nickname of the disconnected player
     */
    void someoneDisconnected(String nickname) ;

    /**
     * Prints the living room in the current turn
     * @param livingRoom
     */
    void showLivingRoom(LivingRoom livingRoom);

    /**
     * Shows the player's bookshelf
     * @param player whose bookshelf has to be displayed
     */
    void showBookshelf(Player player);

    /**
     * Shows the common goal cards for the current game
     * @param game
     */
    void showCommonGoalCards(Game game);

    /**
     * Shows each player its personal goal card
     * @param player whose personal goal card has to be displayed
     * @throws Exception when a tile can't be shown or the card can't be built correctly
     */
    void showPersonalGoalCard(Player player) throws Exception;

    /**
     * Shows the game state updated every turn
     * @param player whose bookshelf and personal goal card have to be displayed
     * @param game
     * @throws Exception when an error occurs in any of the methods called
     */
    void updateGameState(Player player, Game game) throws Exception;

    /**
     * This method is used to set up the initial game
     * @param game is the game started
     */
    void showGameStarted(Game game);

    /**
     * Shows a message to let the player know how many players are connected
     * @param maxPlayers number of players of the game
     * @param numOfPlayersConnected number of players actually connected
     */
    void showWaitingRoom(int maxPlayers, int numOfPlayersConnected);

    /**
     * Shows the winner of the current game
     * @param winner is the nickname of the winner of the game
     * @param game
     */
    void showWinner(String winner, Game game);

    /**
     * Handles the disconnection of the client notifying the observers
     * @param nickname of the disconnected player
     */
    void handleDisconnection(String nickname);

    /**
     * This method is used to display the current player
     * @param player current player
     */
    void turnDisplay(Player player);

    /**
     * When reloading the game with the same nickname, the players get a message of welcome back
     * @param nickname of the player reconnecting
     */
    void welcomeBack(String nickname);

    /**
     * Updates points of the common goal card after one of the player has reached them
     * @param game
     * @param previousPoints1 points of common goal card 1 before one of the player reaches the goal
     * @param previousPoints2 points of common goal card 2 before one of the player reaches the goal
     */
    void updateGuiCommonGoalCardPoints(Game game, int previousPoints1, int previousPoints2);

    /**
     * Displays the scoreboard, asks the players if they want to leave the game
     * @param scoreboard with the final points
     * @param winner nickname of the winner
     */
    void endGame(ArrayList<Player> scoreboard, String winner);
}
