package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.Network.Server.RMI.RMIServer;
import it.polimi.ingsw.Network.Server.Socket.SocketServer;
import it.polimi.ingsw.View.VirtualView;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

    public static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final GameController gameController;
    private final Map<String, MatchServer> matchServerMap;
    private final Object lock;

    public Server(){
        this.gameController = new GameController(this);
        this.matchServerMap = new HashMap<>();
        this.lock = new Object();
    }

    public void startServers() {
        RMIServer rs = new RMIServer(this);
        rs.run();

        int port = 49674;
        SocketServer ss = new SocketServer(this,port);
        ss.run();
    }

    public void login(String nickname, MatchServer matchServer) throws IOException {
        try{
            addClient(nickname,matchServer);
        }catch (IOException e){
            matchServer.disconnectClient();
        }
    }

    public void addClient(String nickname, MatchServer matchServer) throws RemoteException {
        VirtualView vv = new VirtualView(matchServer);

        if(gameController.waitingForPlayers()){
            matchServerMap.put(nickname, matchServer);
            gameController.handleLogin(nickname, vv);
        }else{
            vv.loginResult(true, false, null);
        }
    }


    public void forwardMessage(Message message) throws RemoteException {
        gameController.forwardMessage(message);
    }

    public String getNickname(MatchServer matchServer){
        for(Map.Entry<String, MatchServer> map : matchServerMap.entrySet()){
            if(map.getValue().equals(matchServer))
                return map.getKey();
        }
        return null;
    }

    public void removeClient(MatchServer matchServer){
        for(Map.Entry<String, MatchServer> map : matchServerMap.entrySet()){
            if(map.getValue().equals(matchServer)) {
                matchServerMap.remove(map.getKey());
                gameController.removeVirtualView(map.getKey());
                LOGGER.info(() -> map.getKey() + " was removed from the client list");
                break;
            }
        }
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        synchronized (lock){

            removeClient(matchServer);

            if(!gameController.waitingForPlayers()){
                for(Map.Entry<String, MatchServer> map : matchServerMap.entrySet()){
                    if(map.getValue().equals(matchServer))
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

    public void SendMessageBroadcast(Message message) throws RemoteException {
        for(Map.Entry<String, MatchServer> map : matchServerMap.entrySet()){
            if(map.getValue()!=null && map.getValue().checkConnection()){
                try{
                    map.getValue().sendMessage(message);
                } catch (IOException e) {
                    LOGGER.severe(e.getMessage());
                }
            }
        }
        LOGGER.log(Level.INFO, "Send to all: {0}", message);
    }

    public void sendMessage(Message message, String nickname) throws RemoteException {
        synchronized(lock){
            for(Map.Entry<String, MatchServer> map : matchServerMap.entrySet()){
                if(map.getKey().equals(nickname) && map.getValue()!=null && map.getValue().checkConnection()){
                    try{
                        map.getValue().sendMessage(message);
                    } catch(IOException e){
                        LOGGER.severe(e.getMessage());
                    }
                    break;
                }
            }
        }
        LOGGER.log(Level.INFO, "Sending to {0}, message '{1}", new Object[]{nickname, message});
    }

    /*@Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            synchronized(lock) {
                for (Map.Entry<String, MatchServer> map : matchServerMap.entrySet()) {
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

     */

}