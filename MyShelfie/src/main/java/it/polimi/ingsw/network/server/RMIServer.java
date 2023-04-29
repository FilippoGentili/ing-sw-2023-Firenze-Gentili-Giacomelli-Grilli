package it.polimi.ingsw.Network.Server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends MatchImpl {

    public static void main(String args[]){
        try{
            MatchImpl obj = new MatchImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            MatchImpl server = (MatchImpl) UnicastRemoteObject.exportObject(obj, 0);
            Naming.rebind("//Localhost/Server", server);



        }catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
