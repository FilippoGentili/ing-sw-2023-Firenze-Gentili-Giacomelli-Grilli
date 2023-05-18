package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Client.PingTimer;
import it.polimi.ingsw.Network.Message.LoginReply;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.Socket.SocketServer;
import it.polimi.ingsw.View.VirtualView;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable{

    public static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final GameController gameController;
    private final Map<String, Connection> connectionMap;
    private final Object lock;


    public Server(){
        this.gameController = new GameController(this);
        this.connectionMap = new HashMap<>();
        this.lock = new Object();
    }

    public void startServers() {

        int port = 49674;
        SocketServer ss = new SocketServer(this,port);
        ss.run();
    }

    public void login(String nickname, Connection connection) throws IOException {
        try{
            addClient(nickname,connection);
        }catch (IOException e){
            connection.disconnectClient();
        }
    }

    public void addClient(String nickname, Connection connection) throws RemoteException {
        VirtualView vv = new VirtualView(connection);

        if(gameController.waitingForPlayers()){
            connectionMap.put(nickname, connection);
            gameController.handleLogin(nickname, vv);
        }else{
            vv.loginResult(true, false, null);
        }
    }


    public String getNickname(Connection connection){
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue().equals(connection))
                return map.getKey();
        }
        return null;
    }

    public void removeClient(Connection connection){
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue().equals(connection)) {
                connectionMap.remove(map.getKey());
                gameController.removeVirtualView(map.getKey());
                LOGGER.info(() -> map.getKey() + " was removed from the client list");
                break;
            }
        }
    }

    public void clientDisconnection(Connection connection) throws RemoteException {
        synchronized (lock){

            removeClient(connection);

            if(!gameController.waitingForPlayers()){
                for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
                    if(map.getValue().equals(connection))
                        gameController.broadcastShowMessage(map.getKey() + " disconnected from the server. Game finished :(");
                    break;
                }
                    //fine partita, cancella tutto
                }
            }

    }

    public void receiveMessage(Message message){
        if(message!=null && message.getNickname()!=null){
            String messageContent = message.toString();
            LOGGER.log(Level.INFO, messageContent);
        } else {
            LOGGER.log(Level.INFO, "Received invalid message: {0}", message);
        }
    }

    public void SendMessageBroadcast(Message message) {
        for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
            if(map.getValue()!=null && map.getValue().checkConnection()){
                map.getValue().sendMessage(message);
            }
        }
        LOGGER.log(Level.INFO, "Send to all: {0}", message);
    }

    public void sendMessage(Message message, String nickname) throws RemoteException {
        synchronized(lock){
            for(Map.Entry<String, Connection> map : connectionMap.entrySet()){
                if(map.getKey().equals(nickname) && map.getValue()!=null && map.getValue().checkConnection()){
                    map.getValue().sendMessage(message);
                    break;
                }
            }
        }
        LOGGER.log(Level.INFO, "Sending to {0}, message '{1}", new Object[]{nickname, message});
    }

    public void handleMessage(Message message) throws RemoteException {
        gameController.forwardMessage(message);
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            synchronized(lock) {
                for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                    try {
                        if (map.getValue() != null && map.getValue().checkConnection()) {
                            map.getValue().ping();//da capire come gestire
                        }
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
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

}