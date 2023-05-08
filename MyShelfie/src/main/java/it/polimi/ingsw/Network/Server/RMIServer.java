package it.polimi.ingsw.Network.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public void startRMIServer(){
        try{
            MatchServer obj = new MatchServerImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/MatchServer", obj);
            System.out.println("RMI Server started");
        }catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
