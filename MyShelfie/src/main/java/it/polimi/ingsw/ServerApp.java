package it.polimi.ingsw;

import it.polimi.ingsw.Network.Server.Server;

import java.rmi.RemoteException;


public class ServerApp {

    public static void main(String[] args) {
        try {
            Server server = new Server();

            server.startServers();
        }catch (RemoteException e){
            //
        }
    }
}
