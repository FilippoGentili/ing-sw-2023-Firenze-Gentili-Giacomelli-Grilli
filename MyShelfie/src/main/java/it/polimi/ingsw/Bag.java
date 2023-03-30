package it.polimi.ingsw;


import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Bag {

    private int numOfTiles;
    private ArrayList<Tile> remainingTiles;

    //estraggo un certo numero di Tiles in base a quanti giocatori ci sono -> aggiungere in game un metodo che restituisca
    //il numero di Tile da estrarre in base al numero di giocatori
    public ArrayList<Tile> extract(int numStartTile){

        ArrayList<Tile> chosen = new ArrayList<Tile>();

        Collections.shuffle(remainingTiles);

        for(int i=0; i<numStartTile; i++){
            chosen.set(i, remainingTiles.get(i));
        }

        return chosen;
    }

}
