package it.polimi.ingsw.Model;



public enum TileType {
    CAT, BOOK, GAME, FRAME, TROPHIE, PLANT, NULL;

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\033[0m";

    public String toString(){
        return switch (this.ordinal()) {
            case 0 -> "cat";
            case 1 -> "book";
            case 2 -> "game";
            case 3 -> "frame";
            case 4 -> "trophie";
            case 5 -> "plant";
            case 6 -> "null";
            default -> null;
        };
    }

    public String toCliString(){
        return switch (this.ordinal()) {
            case 0 -> ANSI_GREEN_BACKGROUND + "  cat  " + RESET;
            case 1 -> ANSI_WHITE_BACKGROUND + "  book " + RESET;
            case 2 -> ANSI_YELLOW_BACKGROUND + "  game " + RESET;
            case 3 -> ANSI_BLUE_BACKGROUND + " frame " + RESET;
            case 4 -> ANSI_CYAN_BACKGROUND + "trophie" + RESET;
            case 5 -> ANSI_PURPLE_BACKGROUND + " plant " + RESET;
            case 6 -> RESET+ "       "+RESET;
            default -> RESET+"       "+RESET;
        };
    }
}
