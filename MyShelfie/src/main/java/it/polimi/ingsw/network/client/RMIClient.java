package it.polimi.ingsw.network.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    Registry registry = LocateRegistry.getRegistry(ip);
    IR stub = (IR) registry.lookup("Nome oggetto");

}
