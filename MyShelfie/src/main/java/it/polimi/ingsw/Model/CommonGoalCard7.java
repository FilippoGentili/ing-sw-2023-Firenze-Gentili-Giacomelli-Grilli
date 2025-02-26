package it.polimi.ingsw.Model;


public class CommonGoalCard7 extends CommonGoalCard {

    private static final long serialVersionUID = -1057863627081928406L;
    private final int id=7;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean[][] checkTile = new boolean[6][5];
        int row, col, i, j, count=0;

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0; row<5; row++){
            for(col=0; col<4; col++){
                if(bookshelf.getTile(row,col).getTileType()!=TileType.NULL && bookshelf.getTile(row,col+1).getTileType()!=TileType.NULL &&
                bookshelf.getTile(row+1,col).getTileType()!=TileType.NULL && bookshelf.getTile(row+1,col+1).getTileType()!=TileType.NULL){
                    if(!checkTile[row][col] && !checkTile[row][col+1] && !checkTile[row+1][col] && !checkTile[row+1][col+1]) {
                        if (bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row,col + 1).getTileType() &&
                        bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col).getTileType() &&
                        bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col + 1).getTileType()) {
                            checkTile[row][col] = true;
                            checkTile[row][col + 1] = true;
                            checkTile[row + 1][col] = true;
                            checkTile[row + 1][col + 1] = true;
                            count++;
                        }
                    }
                }
            }
        }

        if(count>1) return true;
        else return false;
    }
}
