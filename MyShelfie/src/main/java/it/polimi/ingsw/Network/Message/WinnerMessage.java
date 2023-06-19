package it.polimi.ingsw.Network.Message;

import it.polimi.ingsw.Model.Game;

public class WinnerMessage extends Message{
    private static final long serialVersionUID = 7515762515979215880L;
    private final String WinnerNickname;
    private final Game game;

    /**
     * Message from the server to the client to communicate the winner
     * @param winner
     */
    public WinnerMessage(String winner, Game game) {
        super(Game.getServerName(), MessageType.WINNER);
        this.WinnerNickname=winner;
        this.game = game;
    }

    public String getWinnerNickname(){
        return WinnerNickname;
    }

    public Game getGame(){
        return game;
    }

    @Override
    public String toString(){
        return "" + getWinnerNickname() + " is the Winner!";
    }

}

