package it.polimi.ingsw.Network.Server;


import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Client.MatchClient;
import it.polimi.ingsw.Network.Client.MatchClientImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServer{

    private List<MatchClient> clients = new ArrayList<>();
    public static void main(String[] args){
        try{
            MatchServerImpl obj = new MatchServerImpl();
            MatchServer server/*stub*/ = (MatchServer) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/MatchServer", server);
        }catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public void connectClient(MatchClientImpl matchClient) {
        clients.add(matchClient);
        System.out.println("A player has been added to the game");
    }

    public void disconnectClient(MatchClientImpl matchClient) {
        clients.remove(matchClient);
        System.out.println("A player has left the game");
    }

    public void sendMessage(Message message) {
        for (MatchClient client : clients) {
            try {
                client.notifyMessageSent(message);
            } catch (RemoteException e) {
                System.err.println("Error sending message to client: " + e.getMessage());
            }
        }
    }

}
