package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;


public class WaitingRoomMessage extends Message{

    private static final long serialVersionUID = -1926579331538779380L;
    private final int maxPlayers;

    private  int numOfPlayersConnected;


    public WaitingRoomMessage(int maxPlayers, int numOfPlayersConnected) {
        super(Game.getServerName(), MessageType.WAITING_ROOM);
        this.maxPlayers = maxPlayers;
        this.numOfPlayersConnected = numOfPlayersConnected;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getNumOfPlayersConnected() {
        return numOfPlayersConnected;
    }

    @Override
    public String toString() {
        return "Waiting for other players to join: " + numOfPlayersConnected + "/" + maxPlayers + " players connected";
    }

}
