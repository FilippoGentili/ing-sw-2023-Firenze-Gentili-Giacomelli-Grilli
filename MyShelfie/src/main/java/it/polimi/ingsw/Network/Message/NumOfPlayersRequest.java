package it.polimi.ingsw.Network.Message;

public class NumOfPlayersRequest extends Message{
    private static final long serialVersionUID = -6565070052540678653L;
    private final int numOfPlayers;

    /**
     * Message from the Client to the Server to communicate the number of players of the match the user wants to play in,
     * or the match the player wants to create
     * @param username
     * @param num
     */
    public NumOfPlayersRequest(String username, int num) {
        super(username, MessageType.NUM_OF_PLAYERS_REQUEST);
        this.numOfPlayers=num;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    @Override
    public String toString(){
        return " "+ getNickname() +" wants to play with " + getNumOfPlayers() + " players";
    }

}
