package it.polimi.ingsw;

import java.util.ArrayList;

public class PersonalGoalCard {

    private Player player;
    private int points = 0;
    private int matches;
    private int ID;

    public void setID(int id){
        this.ID = id;
    }

    public void setPlayer(Player player){
        this.player=player;
    }

    public int getID(){
        return ID;
    }

    public int check(int id){
        switch(id){
            case 1:
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
            case 2:
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
            case 3:
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
            case 4:
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
            case 5:
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
            case 6:
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
            case 7:
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
            case 8:
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
            case 9:
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
            case 10:
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
            case 11:
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
            case 12:
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
            default:
                throw new IllegalArgumentException("id not valid");

        }
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
        matches = check(ID);
        points = countPoints(matches);

        return points;
    }
}
