package it.polimi.ingsw.Network.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface of the client which will be used
 * by server. Methods which are invoked by the client
 */

public interface Match extends Remote {
    void login() throws RemoteException;
    void nicknameRequest() throws RemoteException;
    void ack() throws RemoteException;
    void ping() throws RemoteException;



}
