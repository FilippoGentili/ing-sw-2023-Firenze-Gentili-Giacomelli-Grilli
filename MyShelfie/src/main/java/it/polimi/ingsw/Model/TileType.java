package it.polimi.ingsw.Model;


public enum TileType {
    CAT, BOOK, GAME, FRAME, TROPHIE, PLANT;

    public String toString(){
        return switch (this.ordinal()) {
            case 0 -> "cat";
            case 1 -> "book";
            case 2 -> "game";
            case 3 -> "frame";
            case 4 -> "trophie";
            case 5 -> "plant";
            default -> null;
        };
    }

    public String toCliString(){
        return switch (this.ordinal()) {
            case 0 -> "  cat  ";
            case 1 -> "  book ";
            case 2 -> "  game ";
            case 3 -> " frame ";
            case 4 -> "trophie";
            case 5 -> " plant ";
            default -> "       ";
        };
    }
}
