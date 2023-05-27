package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;


public class WaitingRoomMessageGui extends Message{


    private static final long serialVersionUID = 5626083275365376694L;
    private final int maxPlayers;

    private  int numOfPlayersConnected;


    public WaitingRoomMessageGui(int maxPlayers, int numOfPlayersConnected) {
        super(Game.getServerName(), MessageType.WAITING_ROOM_GUI);
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
