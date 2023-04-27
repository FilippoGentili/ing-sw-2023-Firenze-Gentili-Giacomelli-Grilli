package it.polimi.ingsw.network.client;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;

public class RMIClient {
    Registry registry = LocateRegistry.getRegistry(ip);
    IR stub = (IR) registry.lookup("Nome oggetto");

}
