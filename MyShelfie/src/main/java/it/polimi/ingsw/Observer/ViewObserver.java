package it.polimi.ingsw.Observer;

//qui ci saranno tutti i metodi da chiamare in seguito a cambiamenti nella view
//i metodi manderanno messaggi al server

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Client.Socket.DisconnectionHandler;
import it.polimi.ingsw.Network.Message.ChatMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ViewObserver{

    /**
     * Updates server address and server port, creates socket client and its client updater
     * @param disconnectionHandler
     * @param address
     * @param port
     */
    void updateServerInfoSocket(DisconnectionHandler disconnectionHandler, String address,String port) throws IOException;

    /**
     * Updates server address and server port, creates RMI client and its client updater
     * @param disconnectionHandler
     * @param address
     * @param port
     */
    void updateServerInfoRmi(DisconnectionHandler disconnectionHandler,String address,String port) throws RemoteException;

    /**
     * Sends a chat message to the specified receiver
     * @param receiver selected by the client
     * @param message text the client wants to send
     */
    void sendChatMessage(String receiver, String message);

    /**
     * Updates the nickname of the client with the selected username, sends a request of login to the server
     * @param nickname chosen by the client
     * @throws IOException
     */
    void updateNickname(String nickname) throws IOException;

    /**
     * Sends a message to the server with the number of players for the game
     * @param num number of players selected by the client
     * @throws IOException
     */
    void updateNumOfPlayers(int num) throws IOException;

    /**
     * Sends to the server the tiles chosen from the livingroom
     * @param chosen arraylist of tiles containing the selected tiles
     * @throws IOException
     */
    void updateChosenTiles(ArrayList<Tile> chosen) throws IOException;

    /**
     * Sends to the server the tiles chosen from the livingroom, ordered by the client
     * @param chosen arraylist of tiles containing the ordered tiles
     * @throws IOException
     */
    void updateOrderedTiles(ArrayList<Tile> chosen) throws IOException;

    /**
     * Sends a message to server with the chosen column
     * @param col column in which the client wants to insert the tiles
     * @param availableColumns arraylist containing the columns with enough space for the selected tiles
     * @throws IOException
     */
    void updateChosenColumn(int col,ArrayList<Integer> availableColumns) throws IOException;

    /**
     * Handles disconnection of a client
     * @throws IOException
     */
    void handleDisconnection() throws IOException;

    void updateLivingRoomTiles(ArrayList<Tile> chosen) throws IOException;
}
