package it.polimi.ingsw.Network.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import it.polimi.ingsw.Model.State;
import it.polimi.ingsw.Network.Message.Message;

public class RMIClient implements MatchClient {

    public RMIClient() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        MatchClient client = new RMIClient();
        registry.rebind("client", client);
    }


    public void receiveMessage(Message message) throws RemoteException {
        // implementazione del metodo per ricevere i messaggi dal server
    }


    public void sendMessage(Message message) throws RemoteException {
        // implementazione del metodo per inviare i messaggi al server
    }

    public void update(Message message) throws RemoteException{
    }

    public void updateState(State state) throws RemoteException{
    }

    public void notifyDisconnection() throws RemoteException{
    }
}
