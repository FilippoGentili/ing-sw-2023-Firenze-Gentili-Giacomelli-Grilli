package it.polimi.ingsw.Network.Message;


public class NumOfPlayersReply extends Message{

    private static final long serialVersionUID = -4523235241679280076L;

    private final int numOfPlayers;

    /**
     * Message from the Client to the Server to communicate the number of players of the match the user wants to play in,
     * or the match the player wants to create
     * @param username
     * @param num
     */
    public NumOfPlayersReply(String username, int num) {
        super(username, MessageType.NUM_OF_PLAYERS_REPLY);
        this.numOfPlayers=num;
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    @Override
    public String toString(){
        return ""+ getNickname() +" wants to play with " + getNumOfPlayers() + " players";
    }

}
