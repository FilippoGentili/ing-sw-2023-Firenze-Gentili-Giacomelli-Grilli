package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Message.Message;
import it.polimi.ingsw.View.VirtualView;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Server {

    public static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final GameController gameController;
    private final Map<String, MatchServer> matchServerMap;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private final Object lock;

    public Server(GameController gameController){
        this.gameController = gameController;
        this.matchServerMap = new HashMap<>();
        this.lock = new Object();
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

    public void removeClient(String nickname){
        matchServerMap.remove(nickname);
        gameController.removeVirtualView(nickname);
        LOGGER.info(() -> nickname + " was removed from the client list");
    }

    public void clientDisconnection(MatchServer matchServer) throws RemoteException {
        synchronized (lock){
            String nickname = getNickname(matchServer);

            if(nickname != null){
                removeClient(nickname);

                if(!gameController.waitingForPlayers()){
                    gameController.broadcastShowMessage(nickname + " disconnected from the server. Game finished :(");
                    //fine partita, cancella tutto
                }
            }
        }
    }


}
