package it.polimi.ingsw.Network.Server.Persistence;

import it.polimi.ingsw.Controller.GameController;

import java.io.Serializable;

public class Persistence implements Serializable {
    private static final long serialVersionUID = -674292120191950383L;

    private GameController gameController;

    public Persistence(GameController gameController){
        this.gameController=gameController;
    }

    GameController getGameController(){
        return gameController;
    }



}

