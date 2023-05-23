package it.polimi.ingsw.Model;


import static java.util.Objects.isNull;

public class CommonGoalCard12 extends CommonGoalCard {

    private static final long serialVersionUID = -6291490740925204136L;
    private final int id=12;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        boolean prove;
        int row, col, count;

        for(row=0, count=0, prove=true; row<5 && prove; row++){
            count++;
            for(col=0; col<count && prove; col++)
                if(bookshelf.getTile(row,col).getTileType() == TileType.NULL)
                    prove=false;

            if(prove){
                for(col=count; col<5 && prove; col++)
                    if(bookshelf.getTile(row,col).getTileType() != TileType.NULL)
                        prove=false;
            }
        }
        if(!prove){
            for(row=1, count=0, prove=true; row<6 && prove; row++){
                count++;
                for(col=0; col<count && prove; col++)
                    if(bookshelf.getTile(row,col).getTileType() == TileType.NULL)
                        prove=false;

                if(prove){
                    for(col=count; col<5 && prove; col++)
                        if(bookshelf.getTile(row,col).getTileType() != TileType.NULL)
                            prove=false;
                }
            }
        }
        if(!prove){
            for(row=5, count=0, prove=true; row>0 && prove; row--){
                for(col=4; col>=count && prove; col--)
                    if(bookshelf.getTile(row,col).getTileType() == TileType.NULL)
                        prove=false;

                if(prove){
                    for(col=0; col<count && prove; col++)
                        if(bookshelf.getTile(row,col).getTileType() != TileType.NULL)
                            prove=false;
                }
                count++;
            }
        }
        if(!prove){
            for(row=4, count=0, prove=true; row>=0 && prove; row--){
                for(col=4; col>=count && prove; col--)
                    if(bookshelf.getTile(row,col).getTileType() == TileType.NULL)
                        prove=false;

                if(prove){
                    for(col=0; col<count && prove; col++)
                        if(bookshelf.getTile(row,col).getTileType() != TileType.NULL)
                            prove=false;
                }
                count++;
            }
        }

        if(prove) return true;
        else return false;
    }
}
