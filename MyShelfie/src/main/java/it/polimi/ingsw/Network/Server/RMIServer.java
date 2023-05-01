package it.polimi.ingsw.Network.Server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer{

    public static void main(String[] args){
        try{
            MatchServerImpl obj = new MatchServerImpl();
            MatchServer server/*stub*/ = (MatchServer) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("//Localhost/Server", server);



        }catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
