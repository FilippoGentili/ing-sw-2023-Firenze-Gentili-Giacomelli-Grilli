package it.polimi.ingsw;

public class PersonalGoalCard {

    //private Player player = new Player();
    private int points = 0;
    private int matches;
    private final int ID;

    PersonalGoalCard(int ID){
        this.ID=ID;
    }


    //There are 12 methods that check the number of matches and return it
    public int check1(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,0).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(0,2).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(1,4).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(2,3).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(3,1).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(5,2).getTileType().equals(TileType.TROPHIE))
            matches++;

        return matches;
    }

    public int check2(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(2,0).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(3,4).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(4,3).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(5,4).getTileType().equals(TileType.FRAME))
            matches++;

        return matches;
    }

    public int check3(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(1,0).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(1,3).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(3,1).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(3,4).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(5,0).getTileType().equals(TileType.BOOK))
            matches++;

        return matches;
    }

    public int check4(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,4).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(2,0).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(3,3).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(4,1).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(4,2).getTileType().equals(TileType.CAT))
            matches++;

        return matches;
    }

    public int check5(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(3,1).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(3,2).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(4,4).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(5,0).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(5,3).getTileType().equals(TileType.PLANT))
            matches++;

        return matches;
    }

    public int check6(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,2).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(0,4).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(2,3).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(4,1).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(4,3).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(5,0).getTileType().equals(TileType.PLANT))
            matches++;

        return matches;
    }

    public int check7(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,0).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(1,3).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(2,1).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(3,0).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(4,4).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(5,2).getTileType().equals(TileType.BOOK))
            matches++;

        return matches;
    }

    public int check8(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,4).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(3,0).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(4,3).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(5,3).getTileType().equals(TileType.GAME))
            matches++;

        return matches;
    }

    public int check9(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,2).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(3,4).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(4,1).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(4,4).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(5,0).getTileType().equals(TileType.FRAME))
            matches++;

        return matches;
    }

    public int check10(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,4).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(2,0).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(3,3).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(4,2).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(5,3).getTileType().equals(TileType.PLANT))
            matches++;

        return matches;
    }

    public int check11(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,2).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(2,0).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(3,2).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(4,4).getTileType().equals(TileType.CAT))
            matches++;
        if(player.getBookshelf().getTile(5,3).getTileType().equals(TileType.TROPHIE))
            matches++;

        return matches;
    }

    public int check12(Player player){
        if(player==null)
            throw new IllegalArgumentException("Player can't be null");

        matches = 0;
        if(player.getBookshelf().getTile(0,2).getTileType().equals(TileType.BOOK))
            matches++;
        if(player.getBookshelf().getTile(1,1).getTileType().equals(TileType.PLANT))
            matches++;
        if(player.getBookshelf().getTile(2,2).getTileType().equals(TileType.FRAME))
            matches++;
        if(player.getBookshelf().getTile(3,3).getTileType().equals(TileType.TROPHIE))
            matches++;
        if(player.getBookshelf().getTile(4,4).getTileType().equals(TileType.GAME))
            matches++;
        if(player.getBookshelf().getTile(5,0).getTileType().equals(TileType.CAT))
            matches++;

        return matches;
    }

    //With the method count points, the number of matches is used to decide how many points the player gets
    public int countPoints(int matches){
        switch (matches) {
            case 0 -> points = 0;
            case 1 -> points = 1;
            case 2 -> points = 2;
            case 3 -> points = 4;
            case 4 -> points = 6;
            case 5 -> points = 9;
            case 6 -> points = 12;
        }

        return points;
    }

    //The method gives how many points the player has to get, based on his PersonalGoalCard
    public int assignPoints (int ID){
        switch (ID) {
            case 1 -> {
                matches = check1();
                points = countPoints(matches);
            }
            case 2 -> {
                matches = check2();
                points = countPoints(matches);
            }
            case 3 -> {
                matches = check3();
                points = countPoints(matches);
            }
            case 4 -> {
                matches = check4();
                points = countPoints(matches);
            }
            case 5 -> {
                matches = check5();
                points = countPoints(matches);
            }
            case 6 -> {
                matches = check6();
                points = countPoints(matches);
            }
            case 7 -> {
                matches = check7();
                points = countPoints(matches);
            }
            case 8 -> {
                matches = check8();
                points = countPoints(matches);
            }
            case 9 -> {
                matches = check9();
                points = countPoints(matches);
            }
            case 10 -> {
                matches = check10();
                points = countPoints(matches);
            }
            case 11 -> {
                matches = check11();
                points = countPoints(matches);
            }
            case 12 -> {
                matches = check12();
                points = countPoints(matches);
            }
            default -> throw new IllegalStateException("Unexpected value: " + ID);
        }

        return points;
    }
}
