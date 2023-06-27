package it.polimi.ingsw.Network.Server.Persistence;

import it.polimi.ingsw.Controller.GameController;

import java.io.Serializable;

/**
 * Class to save the game controller of the game
 */
public class Persistence implements Serializable {
    private static final long serialVersionUID = -674292120191950383L;

    private GameController gameController;

    /**
     * Sets the game controller of the game to be saved
     * @param gameController to be set for this persistence class
     */
    public Persistence(GameController gameController){
        this.gameController=gameController;
    }

    /**
     * Gets game controller of the game
     * @return the game controller
     */
    GameController getGameController(){
        return gameController;
    }



}

