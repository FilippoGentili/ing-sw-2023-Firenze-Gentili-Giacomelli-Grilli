package it.polimi.ingsw.network.Message;

public class NumOfPlayersRequest extends Message{
    private final int numOfPlayers;

    /**
     * Message from the client to the server to communicate the number of players of the match the user wants to play in,
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
