package it.polimi.ingsw.Model;

public enum TileType {
    CAT, BOOK, GAME, FRAME, TROPHIE, PLANT

    public String toString(){
        switch(this.ordinal()){
            case 0:
                return "cat";
            case 1:
                return "book";
            case 2:
                return "game";
            case 3:
                return "frame";
            case 4:
                return "trophie";
            case 5:
                return "plant";
            default:
                return null;

        }
    }
}
