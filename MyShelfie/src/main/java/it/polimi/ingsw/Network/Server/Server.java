package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Message.*;
import it.polimi.ingsw.Network.Server.Persistence.GameSaved;
import it.polimi.ingsw.Network.Server.RMI.RMIServer;
import it.polimi.ingsw.Network.Server.Socket.SocketServer;
import it.polimi.ingsw.View.VirtualView;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.net.InetAddress.getLocalHost;

public class Server implements Runnable{

    public static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private GameController gameController;
    private Map<String, Connection> connectionMap;
    private Object lock;
    private boolean reloadedGame = false;

    /**
     * Constructor for Server when a new game is created
     */
    public Server() {
        this.gameController = new GameController(this);
        this.connectionMap = new HashMap<>();
        this.lock = new Object();
        Thread ping = new Thread(this);
        ping.start();
    }

    /**
     * Constructor for server when a game is reloaded
     * @param b
     */
    public Server(Boolean b) {
        reloadedGame = b;
        this.gameController = GameSaved.loadGame(this);
        this.connectionMap = new HashMap<>();
        this.lock = new Object();
        Thread ping = new Thread(this);
        ping.start();

        LOGGER.log(Level.INFO, "Game loaded successfully.");
    }

    /**
     * Method that starts both servers, so that clients can connect with different technologies
     */
    public void startServers() {
        int Socketport = 1098;
        SocketServer ss = new SocketServer(this, Socketport);
        ss.startSocketServer();

       int rmiPort = 1099;
        RMIServer rs = new RMIServer(this,rmiPort);
        rs.startRMIServer();

        /*int socketChat = 49671;
        SocketChat sc = new SocketChat(this,socketChat);
        sc.startSocketChat();*/
        try {
            String address;
            address=getLocalHost().toString();
            address=address.substring(address.indexOf("/1")+1);
            Server.LOGGER.log(Level.INFO,"Server IP Address is: {0} - Have the players type the address when prompted.", address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used to log the client
     * @param nickname
     * @param connection
     * @throws IOException
     * @throws InterruptedException
     */
    public synchronized void login(String nickname, Connection connection) throws IOException, InterruptedException {

        if(nickname.equals("")){
            wrongNickname(nickname,connection);
            return;
        }
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(nickname.equals(map.getKey())){
                wrongNickname(nickname,connection);
                return;
            }
        }

        if (nickname != null || !nickname.isEmpty()) {
            addClient(nickname, connection);
        }
    }

    public synchronized void wrongNickname(String nickname, Connection connection){
        if(nickname.equals("")){
            connection.sendMessage(new GenericMessage("'null' is not a valid nickname"));
        }else {
            connection.sendMessage(new GenericMessage("This nickname is already used. Please, choose another one"));
        }
        connection.sendMessage(new LoginResult(nickname,false,true));
    }

    /**
     * Adds client through its nickname and connection type
     */
    public synchronized void addClient(String nickname, Connection connection) throws InterruptedException {
        VirtualView vv = new VirtualView(connection);

        if(!reloadedGame){
            if (gameController.waitingForPlayers()) {
                connectionMap.put(nickname, connection);
                gameController.handleLogin(nickname, vv);
            } else {
                sendMessage(new GenericMessage("We are sorry, the game already started :( ... you have to wait until the end of the match"),nickname);
                sendMessage(new DisconnectionReply(nickname),nickname);
            }
        }else{
            for(Player p : gameController.getPlayers()){
                if(p.getNickname().equals(nickname) && !gameController.getReturnPlayers().contains(nickname)){
                    connectionMap.put(nickname, connection);
                    sendMessage(new WelcomeBackMessage(nickname), nickname);
                    gameController.addingPlayersAgain(nickname);
                    break;
                }else{
                    sendMessage(new GenericMessage("You cannot play this game... you have to wait until the end of the match"),nickname);
                    sendMessage(new DisconnectionReply(nickname),nickname);
                }
            }
        }
    }

    /**
     * Gets the nickname through the connection map
     * @param connection
     * @return
     */
    public String getNickname(Connection connection){
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue().equals(connection))
                return map.getKey();
        }
        return null;
    }

    /**
     * Removes client from the connectionMap
     * @param connection
     */
    public void removeClient(Connection connection) {
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue().equals(connection)) {
                connection.setIsConnected();
                connectionMap.remove(map.getKey(), map.getValue());

                closeServer();
                LOGGER.info(() -> map.getKey() + " was removed from the client list");
                break;
            }
        }
    }

    /**
     * Disconnects client, sending a broadcast message that a specific client has been disconnected
     * @param connection
     */
    public void clientDisconnection(Connection connection) {
        synchronized (lock){

            String app = "Server";

            for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
                if(map.getValue().equals(connection)) {
                    app = map.getKey();
                    break;
                }
            }

            if(app != "Server") {
                for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                    if (!map.getKey().equals(app))
                        sendMessage(new GenericMessage(app + " disconnected from the server. Game finished :("), map.getKey());
                }
            }
            removeClient(connection);
        }

    }

    /**
     * Sends a message to all clients
     * @param message
     */
    public void broadcastMessage(Message message){
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue()!=null && map.getValue().checkConnection()){
                map.getValue().sendMessage(message);
            }
        }
        LOGGER.log(Level.INFO, "Send to all: {0}", message);
    }

    /**
     * Sends message to the player corresponding to nickname
     * @param message
     * @param nickname
     */
    public void sendMessage(Message message, String nickname) {
        synchronized(lock){
            for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
                if(map.getKey().equals(nickname) && map.getValue()!=null && map.getValue().checkConnection()){
                    if(message.getMessageType() == MessageType.DISCONNECTION_REPLY){
                        clientDisconnection(map.getValue());
                    }else{
                        map.getValue().sendMessage(message);
                    }
                    break;
                }
            }
        }
        LOGGER.log(Level.INFO, "Sending to {0}, {1}", new Object[]{nickname, message});
    }

    /**
     * Handles the message depending on its type
     * @param message
     * @throws InterruptedException
     */
    public void handleMessage(Message message) throws InterruptedException {
        synchronized (lock) {
            if(message.getMessageType() == MessageType.CHAT_MESSAGE){
                broadcastMessage(message);
            }else {
                gameController.forwardMessage(message);
            }
        }
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            synchronized(lock) {
                for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                    if (map.getValue() != null && map.getValue().checkConnection()) {
                        try {
                            map.getValue().ping();
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.severe(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public void closeServer(){
        if(connectionMap.size()==0){
            System.exit(1);
        }
    }
}