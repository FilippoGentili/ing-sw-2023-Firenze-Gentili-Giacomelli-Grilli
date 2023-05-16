package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIServerHandler;
import it.polimi.ingsw.Network.Message.Message;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClientHandler extends Remote {

    void login(String nickname, RMIServerHandler rmiServerHandler) throws IOException;
    void sendMessage(Message message) throws RemoteException;
    void disconnectClient() throws RemoteException;
}
