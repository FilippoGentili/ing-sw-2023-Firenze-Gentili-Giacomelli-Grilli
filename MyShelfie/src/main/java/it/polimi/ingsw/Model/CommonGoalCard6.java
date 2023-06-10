package it.polimi.ingsw.Model;


public class CommonGoalCard6 extends CommonGoalCard {

    private static final long serialVersionUID = -4387837490485654750L;
    private final int id=6;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int col, k, count=0;
        boolean verifica=false, uguali;

        for(col=0; col<5 && count<2; col++){
            uguali=false;
            if(bookshelf.getTile(0,col).getTileType() != TileType.NULL) {
                for (k = 1; k < 6 && !uguali; k++) {
                    if (bookshelf.getTile(0, col).getTileType() == bookshelf.getTile(k, col).getTileType() ||
                    bookshelf.getTile(k,col).getTileType()==TileType.NULL)
                        uguali = true;
                }
            }else{
                uguali=true;
            }
            if(!uguali)
                count++;
        }
        if(count==2)
            verifica=true;

        return verifica;
    }
}
