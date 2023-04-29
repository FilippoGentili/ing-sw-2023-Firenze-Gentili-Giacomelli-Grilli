package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class PickFirstPlayer extends Message{
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
