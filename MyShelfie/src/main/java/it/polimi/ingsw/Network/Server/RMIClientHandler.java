package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Game;
import it.polimi.ingsw.Model.LivingRoom;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Tile;
import it.polimi.ingsw.Network.Message.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIClientHandler extends Remote {

    void showMessage(String message) throws RemoteException;
    void sendMessage(Message message) throws RemoteException;
    void loginResult(boolean validNickname, boolean connection, String nickname) throws RemoteException;
    void updateNumberOfPlayers(Message message) throws RemoteException;
    void updateChosenTiles(Message message) throws RemoteException;
    void updateChosenColumn(Message message) throws RemoteException;
    void updateOrderedTiles(Message message) throws RemoteException;
    void disconnectClient() throws RemoteException;
}
