package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class PickFirstPlayer extends Message{
    private static final long serialVersionUID = 1204922671829035642L;
    public String firstPlayer;
    public PickFirstPlayer(String firstPlayerUsername) {
        super(Game.getServerName(), MessageType.PICK_FIRST_PLAYER);
        this.firstPlayer=firstPlayerUsername;
    }

    public String getFirstPlayer(){
        return firstPlayer;
    }
    @Override
    public String toString(){
        return " " + getFirstPlayer() + " is the first player";
    }

}
