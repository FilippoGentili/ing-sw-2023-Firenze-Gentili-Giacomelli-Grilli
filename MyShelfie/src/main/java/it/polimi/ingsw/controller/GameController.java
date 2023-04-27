package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.observer.Observer;

import java.io.Serializable;

public class GameController implements Observer, Serializable {
    private Game game;
}
