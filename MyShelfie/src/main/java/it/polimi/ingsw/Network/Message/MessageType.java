package it.polimi.ingsw.Network.Message;

public enum MessageType {
    LOGIN_REQUEST,
    LOGIN_REPLY,
    NUM_OF_PLAYERS_REQUEST, //serve?
    NUM_OF_PLAYERS_REPLY, //serve?
    PICK_FIRST_PLAYER, //serve?
    DISCONNECTION_REQUEST,
    DISCONNECTION_REPLY,
    PING,
    ACK,
    CHOSEN_TILES_REQUEST,
    INSERT_TILES,
    COLUMN_REQUEST,
    COLUMN,
    UPDATE_POINTS,
    GENERIC_MESSAGE,
    WINNER

}
