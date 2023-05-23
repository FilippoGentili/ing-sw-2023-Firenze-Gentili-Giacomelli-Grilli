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
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==0)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==0 && j==2)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==1 && j==4)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==2 && j==3)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==3 && j==1)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==5 && j==2)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 2:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==2 && j==0)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==3 && j==4)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==4 && j==3)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==5 && j==4)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 3:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==1 && j==0)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==1 && j==3)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==3 && j==1)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==3 && j==4)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==5 && j==0)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 4:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==4)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==2 && j==0)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==3 && j==3)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==4 && j==1)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==4 && j==2)
                            goal[i][j]= new Tile(TileType.CAT);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 5:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==3 && j==1)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==3 && j==2)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==4 && j==4)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==5 && j==0)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==5 && j==3)
                            goal[i][j]= new Tile(TileType.CAT);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 6:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==2)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==0 && j==4)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==2 && j==3)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==4 && j==1)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==4 && j==3)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==5 && j==0)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 7:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==0)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==1 && j==3)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==2 && j==1)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==3 && j==0)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==4 && j==4)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==5 && j==2)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 8:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==4)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==3 && j==0)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==4 && j==3)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==5 && j==3)
                            goal[i][j]= new Tile(TileType.GAME);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 9:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==2)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==3 && j==4)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==4 && j==1)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==4 && j==4)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==5 && j==0)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 10:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==4)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==2 && j==0)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==3 && j==3)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==4 && j==2)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==5 && j==3)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 11:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==2)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==2 && j==0)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==3 && j==2)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==4 && j==4)
                            goal[i][j]= new Tile(TileType.CAT);
                        else if(i==5 && j==3)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
                return goal;
            case 12:
                for(int i=0; i<6; i++){
                    for(int j=0; j<5; j++){
                        if(i==0 && j==2)
                            goal[i][j]= new Tile(TileType.BOOK);
                        else if(i==1 && j==1)
                            goal[i][j]= new Tile(TileType.PLANT);
                        else if(i==2 && j==2)
                            goal[i][j]= new Tile(TileType.FRAME);
                        else if(i==3 && j==3)
                            goal[i][j]= new Tile(TileType.TROPHIE);
                        else if(i==4 && j==4)
                            goal[i][j]= new Tile(TileType.GAME);
                        else if(i==5 && j==0)
                            goal[i][j]= new Tile(TileType.CAT);
                        else
                            goal[i][j] = new Tile(TileType.NULL);
                    }
                }
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
