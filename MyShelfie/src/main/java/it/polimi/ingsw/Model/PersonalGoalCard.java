package it.polimi.ingsw.Model;

import java.io.Serializable;

public class PersonalGoalCard implements Serializable {

    private static final long serialVersionUID = 3824493051654631676L;
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

    /**
     * The switch case calls the correct check method, depending on the ID of the Personal Goal Card assigned to
     * the player
     * @param id
     * @return the number of matches for the particular card
     */
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
                if(player.getBookshelf().getTile(5,3).getTileType().equals(TileType.CAT))
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
                throw new IllegalArgumentException("ID not valid");

        }
    }


    /**
     * With the method count points, the number of matches is used to decide how many points the player gets
     * @param matches
     * @return the points that are going ot be assigned
     */
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

    public Tile[][] buildPersonalGoalCard() throws Exception {
        Tile[][] goal = new Tile[6][5];

        switch(getID()){
            case 1:
                goal[0][0] = new Tile(TileType.PLANT);
                goal[0][2] = new Tile(TileType.FRAME);
                goal[1][4] = new Tile(TileType.CAT);
                goal[2][3] = new Tile(TileType.BOOK);
                goal[3][1] = new Tile(TileType.GAME);
                goal[5][2] = new Tile(TileType.TROPHIE);
                return goal;
            case 2:
                goal[1][1] = new Tile(TileType.PLANT);
                goal[2][0] = new Tile(TileType.CAT);
                goal[2][2] = new Tile(TileType.GAME);
                goal[3][4] = new Tile(TileType.BOOK);
                goal[4][3] = new Tile(TileType.TROPHIE);
                goal[5][4] = new Tile(TileType.FRAME);
                return goal;
            case 3:
                goal[1][0] = new Tile(TileType.FRAME);
                goal[1][3] = new Tile(TileType.GAME);
                goal[2][2] = new Tile(TileType.PLANT);
                goal[3][1] = new Tile(TileType.CAT);
                goal[3][4] = new Tile(TileType.TROPHIE);
                goal[5][0] = new Tile(TileType.BOOK);
                return goal;
            case 4:
                goal[0][4] = new Tile(TileType.GAME);
                goal[2][0] = new Tile(TileType.TROPHIE);
                goal[2][2] = new Tile(TileType.FRAME);
                goal[3][3] = new Tile(TileType.PLANT);
                goal[4][1] = new Tile(TileType.BOOK);
                goal[4][2] = new Tile(TileType.CAT);
                return goal;
            case 5:
                goal[1][1] = new Tile(TileType.TROPHIE);
                goal[3][1] = new Tile(TileType.FRAME);
                goal[3][2] = new Tile(TileType.BOOK);
                goal[4][4] = new Tile(TileType.PLANT);
                goal[5][0] = new Tile(TileType.GAME);
                goal[5][3] = new Tile(TileType.CAT);
                return goal;
            case 6:
                goal[0][2] = new Tile(TileType.TROPHIE);
                goal[0][4] = new Tile(TileType.CAT);
                goal[2][3] = new Tile(TileType.BOOK);
                goal[4][1] = new Tile(TileType.GAME);
                goal[4][3] = new Tile(TileType.FRAME);
                goal[5][0] = new Tile(TileType.PLANT);
                return goal;
            case 7:
                goal[0][0] = new Tile(TileType.CAT);
                goal[1][3] = new Tile(TileType.FRAME);
                goal[2][1] = new Tile(TileType.PLANT);
                goal[3][0] = new Tile(TileType.TROPHIE);
                goal[4][4] = new Tile(TileType.GAME);
                goal[5][2] = new Tile(TileType.BOOK);
                return goal;
            case 8:
                goal[0][4] = new Tile(TileType.FRAME);
                goal[1][1] = new Tile(TileType.CAT);
                goal[2][2] = new Tile(TileType.TROPHIE);
                goal[3][0] = new Tile(TileType.PLANT);
                goal[4][3] = new Tile(TileType.BOOK);
                goal[5][3] = new Tile(TileType.GAME);
                return goal;
            case 9:
                goal[0][2] = new Tile(TileType.GAME);
                goal[2][2] = new Tile(TileType.CAT);
                goal[3][4] = new Tile(TileType.BOOK);
                goal[4][1] = new Tile(TileType.TROPHIE);
                goal[4][4] = new Tile(TileType.PLANT);
                goal[5][0] = new Tile(TileType.FRAME);
                return goal;
            case 10:
                goal[0][4] = new Tile(TileType.TROPHIE);
                goal[1][1] = new Tile(TileType.GAME);
                goal[2][0] = new Tile(TileType.BOOK);
                goal[3][3] = new Tile(TileType.CAT);
                goal[4][2] = new Tile(TileType.FRAME);
                goal[5][3] = new Tile(TileType.PLANT);
                return goal;
            case 11:
                goal[0][2] = new Tile(TileType.PLANT);
                goal[1][1] = new Tile(TileType.BOOK);
                goal[2][0] = new Tile(TileType.GAME);
                goal[3][2] = new Tile(TileType.FRAME);
                goal[4][4] = new Tile(TileType.CAT);
                goal[5][3] = new Tile(TileType.TROPHIE);
                return goal;
            case 12:
                goal[0][2] = new Tile(TileType.BOOK);
                goal[1][1] = new Tile(TileType.PLANT);
                goal[2][2] = new Tile(TileType.FRAME);
                goal[3][3] = new Tile(TileType.TROPHIE);
                goal[4][4] = new Tile(TileType.GAME);
                goal[5][0] = new Tile(TileType.CAT);
                return goal;
            default:
                throw new Exception("An error occured");
        }
    }

    /**
     * The method gives how many points the player has to get, based on his PersonalGoalCard
     * @param ID
     * @return points given to the player depending on the number of matches
     */
    public int assignPoints (int ID){
        int x;
        x = check(ID);
        points = countPoints(x);

        return points;
    }
}
