package it.polimi.ingsw.Model;

public class CommonGoalCard1 extends CommonGoalCard {

    private static final long serialVersionUID = -2155701438769337191L;
    private final int id=1;

    public int getId(){return this.id;}

    @Override
    public boolean check(Bookshelf bookshelf) {
        int countGroup=0, row, col;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<6; row++){
            for(col=0; col<4; col++){
                if(!checkTile[row][col]){
                    if(bookshelf.getTile(row,col).getTileType() != TileType.NULL && bookshelf.getTile(row,col+1).getTileType() != TileType.NULL) {
                        if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row, col + 1).getTileType()) {
                            countGroup++;
                            checkTile[row][col] = true;
                            checkTile[row][col + 1] = true;
                        }
                    }
                }
            }
        }

        if(countGroup<6){
            for(row=0; row<5; row++) {
                for (col = 0; col < 5; col++) {
                    if (!checkTile[row][col]) {
                        if(bookshelf.getTile(row,col).getTileType() != TileType.NULL && bookshelf.getTile(row+1,col).getTileType() != TileType.NULL) {
                            if (bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col).getTileType()) {
                                countGroup++;
                                checkTile[row][col] = true;
                                checkTile[row + 1][col] = true;
                            }
                        }
                    }
                }
            }
        }

        if(countGroup>5)
            return true;
        else
            return false;
    }
}
