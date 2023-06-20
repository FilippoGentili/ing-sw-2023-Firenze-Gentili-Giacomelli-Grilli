package it.polimi.ingsw.Network.Message;

public enum MessageType {
    LOGIN_REQUEST,
    LOGIN_REPLY,
    LOGIN_RESULT,
    NUM_OF_PLAYERS_REQUEST,
    NUM_OF_PLAYERS_REPLY,
    PICK_FIRST_PLAYER, //serve?
    STARTING_CHAT_MESSAGE,
    CHAT_MESSAGE,
    DISCONNECTION_REQUEST,
    DISCONNECTION_REPLY,
    PING,
    ACK,
    CHOSEN_TILES_REQUEST,
    GIVE_POINTS,
    COLUMN_REQUEST,
    COLUMN_REPLY,
    UPDATE_POINTS,
    GENERIC_MESSAGE,
    WINNER_MESSAGE,
    MATCH_INFO,
    LIVING_ROOM,
    SERVER_INFO,
    ORDERED_TILES_REPLY,
    ORDERED_TILES_REQUEST,
    HEARTBEAT,
    BOOKSHELF,
    CHOSEN_TILES_REPLY,
    PLAYER_MESSAGE,
    GAME_STATE,
    WAITING_ROOM,
    INDEX_TILES,
    GAME_STARTED,
    SCOREBOARD_MESSAGE,
    Turn_Message,
    WELCOMEBACK_MESSAGE
}

