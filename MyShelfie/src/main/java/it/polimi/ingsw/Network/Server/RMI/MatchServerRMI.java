package it.polimi.ingsw.Network.Server.RMI;

import it.polimi.ingsw.Network.Client.RMI.RMIServerHandler;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.MatchServer;
import it.polimi.ingsw.Network.Server.Server;

import java.io.IOException;
import java.rmi.RemoteException;

public class MatchServerRMI extends MatchServer {
    private final Server server;
    private final RMIServerHandler client;
    private boolean connection = true;

    MatchServerRMI(Server server,RMIServerHandler rmiServerHandler){
        this.server = server;
        this.client = rmiServerHandler;
    }
    @Override
    public boolean checkConnection() throws RemoteException {
        return connection;
    }

    @Override
    public void disconnectClient() throws IOException {
        if(connection){
            connection = false;

            try{
                client.disconnect();
            }catch (RemoteException e){

            }

            server.removeClient(this);
        }
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        client.sendMessage(message);
    }
}
