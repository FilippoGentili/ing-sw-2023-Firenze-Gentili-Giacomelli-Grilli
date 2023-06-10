package it.polimi.ingsw.Model;

public class CommonGoalCard8 extends CommonGoalCard {

    private static final long serialVersionUID = -960004755710147528L;
    private final int id=8;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, k, count=0;
        boolean verifica=false, uguali;

        for(row=0; row<6 && count<2; row++){
            uguali=false;
            if(bookshelf.getTile(row,0).getTileType()!=TileType.NULL) {
                for (k = 1; k < 5 && !uguali; k++) {
                    if (bookshelf.getTile(row,0).getTileType() == bookshelf.getTile(row, k).getTileType() ||
                            bookshelf.getTile(row,k).getTileType() == TileType.NULL)
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
