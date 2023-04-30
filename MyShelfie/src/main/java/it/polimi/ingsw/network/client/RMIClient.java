package it.polimi.ingsw.Network.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.Network.Message.Message;

public class RMIClient implements MatchClient {

    public RMIClient() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        MatchClient client = new RMIClient();
        registry.rebind("client", client);
    }

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        // implementazione del metodo per ricevere i messaggi dal server
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        // implementazione del metodo per inviare i messaggi al server
    }
}
