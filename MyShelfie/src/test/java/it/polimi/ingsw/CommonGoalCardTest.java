package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCardTest {

    @Test
    void Colonna(){
        Bookshelf bookshelf = new Bookshelf();
        LivingRoom livingRoom = LivingRoom.getInstance();
        Tile cat = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile cat1 = new Tile(TileType.CAT, Location.BOOKSHELF);
        Tile book = new Tile(TileType.BOOK, Location.BOOKSHELF);
        Tile trophie = new Tile(TileType.TROPHIE, Location.BOOKSHELF);
        Tile game = new Tile(TileType.GAME, Location.BOOKSHELF);
        Tile plant = new Tile(TileType.PLANT, Location.BOOKSHELF);
        Tile frame = new Tile(TileType.FRAME, Location.BOOKSHELF);

        ArrayList<Tile> TileCat = new ArrayList<>();
        ArrayList<Tile> TileCat1 = new ArrayList<>();
        ArrayList<Tile> TileBook = new ArrayList<>();
        ArrayList<Tile> TileTrophie = new ArrayList<>();
        ArrayList<Tile> TileGame = new ArrayList<>();
        ArrayList<Tile> TilePlant = new ArrayList<>();
        ArrayList<Tile> TileFrame = new ArrayList<>();

        TileCat.add(cat);
        TileBook.add(book);
        TileTrophie.add(trophie);
        TileGame.add(game);
        TilePlant.add(plant);
        TileFrame.add(frame);
        TileCat1.add(cat1);

        livingRoom.setValid(0,0,true);
        livingRoom.setValid(0,1,true);

        livingRoom.insertTiles(TileCat);
        livingRoom.insertTiles(TileCat1);

        System.out.println(livingRoom.getTile(0,0).getRow());
        System.out.println(livingRoom.getTile(0,1).getRow());
        System.out.println(livingRoom.getTile(0,1).getCol());

    }

}