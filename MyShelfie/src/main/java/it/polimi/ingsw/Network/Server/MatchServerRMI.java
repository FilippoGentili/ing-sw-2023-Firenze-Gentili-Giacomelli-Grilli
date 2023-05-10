package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.RMIClient;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.server.RemoteCall;
import java.rmi.server.RemoteStub;

public class MatchServerRMI extends UnicastRemoteObject implements MatchServer {
    private static final long serialVersionUID = -8871984387622564437L;

    private final transient Server server;
    private boolean connected;

    //private ArrayList<Client> listOfClients = new ArrayList<>();
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private final Object inputLock;
    private final Object outputLock;

    public MatchServerRMI(Server server) throws RemoteException{
        this.server = server;
        this.connected = true;
        this.inputLock = new Object();
        this.outputLock = new Object();
    }


    public void connectClient(Client client) throws RemoteException {
        Server.LOGGER.info("Client connected");

        try{
            Message message = (Message) input.readObject();

            if(message != null){
                if(message.getMessageType() == MessageType.LOGIN_REQUEST){
                    RMIServer.addClient(message.getNickname(),this);
                }else {
                    RMIServer.forwardMessage(message);
                }
            }
        }catch (ClassNotFoundException | IOException e){
            Server.LOGGER.severe("Connection could not be established");
        }
    }

    @Override
    public boolean checkConnection() throws RemoteException {
        return connected;
    }

    @Override
    public void disconnectClient() throws RemoteException {
        if(connected){
            server.clientDisconnection(this);
            connected = false;
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        try{
            synchronized(outputLock){
                output.writeObject(message);
                output.reset();
                Server.LOGGER.info(() -> "Sent: " + message);
            }
        } catch(IOException e) {
            Server.LOGGER.severe(e.getMessage());
        }
    }

}
