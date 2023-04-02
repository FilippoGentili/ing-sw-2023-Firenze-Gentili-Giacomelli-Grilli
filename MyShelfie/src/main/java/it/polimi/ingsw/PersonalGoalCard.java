package it.polimi.ingsw;

public class PersonalGoalCard {
    private Player player;
    private int points = 0;
    private int matches = 0;
    private final int ID;

    PersonalGoalCard(int ID){
        this.ID=ID;
    }

    public int getID(){
        return ID;
    }

    //Each personal Goal Card has an ID
    PersonalGoalCard pGoal1 = new PersonalGoalCard(1);
    PersonalGoalCard pGoal2 = new PersonalGoalCard(2);
    PersonalGoalCard pGoal3 = new PersonalGoalCard(3);
    PersonalGoalCard pGoal4 = new PersonalGoalCard(4);
    PersonalGoalCard pGoal5 = new PersonalGoalCard(5);
    PersonalGoalCard pGoal6 = new PersonalGoalCard(6);
    PersonalGoalCard pGoal7 = new PersonalGoalCard(7);
    PersonalGoalCard pGoal8 = new PersonalGoalCard(8);
    PersonalGoalCard pGoal9 = new PersonalGoalCard(9);
    PersonalGoalCard pGoal10 = new PersonalGoalCard(10);
    PersonalGoalCard pGoal11 = new PersonalGoalCard(11);
    PersonalGoalCard pGoal12 = new PersonalGoalCard(12);

    //There are 12 methods that check the number of matches and return it
    public int check1(){
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

    public int check2(){
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

    public int check3(){
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

    public int check4(){
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

    public int check5(){
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

    public int check6(){
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

    public int check7(){
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

    public int check8(){
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

    public int check9(){
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

    public int check10(){
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

    public int check11(){
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

    public int check12(){
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
                matches = pGoal1.check1();
                points = pGoal1.countPoints(matches);
            }
            case 2 -> {
                matches = pGoal2.check2();
                points = pGoal2.countPoints(matches);
            }
            case 3 -> {
                matches = pGoal3.check3();
                points = pGoal3.countPoints(matches);
            }
            case 4 -> {
                matches = pGoal4.check4();
                points = pGoal4.countPoints(matches);
            }
            case 5 -> {
                matches = pGoal5.check5();
                points = pGoal5.countPoints(matches);
            }
            case 6 -> {
                matches = pGoal6.check6();
                points = pGoal6.countPoints(matches);
            }
            case 7 -> {
                matches = pGoal7.check7();
                points = pGoal7.countPoints(matches);
            }
            case 8 -> {
                matches = pGoal8.check8();
                points = pGoal8.countPoints(matches);
            }
            case 9 -> {
                matches = pGoal9.check9();
                points = pGoal9.countPoints(matches);
            }
            case 10 -> {
                matches = pGoal10.check10();
                points = pGoal10.countPoints(matches);
            }
            case 11 -> {
                matches = pGoal11.check11();
                points = pGoal11.countPoints(matches);
            }
            case 12 -> {
                matches = pGoal12.check12();
                points = pGoal1.countPoints(matches);
            }
        }

        return points;
    }
}
