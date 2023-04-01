package it.polimi.ingsw;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> listOfPlayers;

    public Game() {
        this.listOfPlayers = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return this.listOfPlayers;
    }

    public void addPlayer(Player player) {
        this.listOfPlayers.add(player);
    }

    public void removePlayer(Player player) {
        this.listOfPlayers.remove(player);
    }

    public int numberOfTiles() {
        int numberOfTiles;

        switch (listOfPlayers.size()) {
            case 2:
                numberOfTiles = 29;
                break;
            case 3:
                numberOfTiles = 37;
                break;
            case 4:
                numberOfTiles = 45;
                break;
            default:
                throw new IllegalArgumentException("Invalid number of players");
        }

        return numberOfTiles;
    }

    public void endGameTrigger() {
        // Implementazione del metodo
    }

    public void assignPoints(Player player, int score){
        // Implementazione del metodo
    }
}
