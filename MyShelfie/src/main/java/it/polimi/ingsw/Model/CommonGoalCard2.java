package it.polimi.ingsw.Model;

public class CommonGoalCard2 extends CommonGoalCard {

    private static final long serialVersionUID = -7708799244357708421L;
    private final int id=2;

    public int getId(){return this.id;}
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col;
        boolean trovato = true;

        //nella libreria è possibile creare quattro diagonali: le ispeziono singolarmente finché non ne trovo una che
        //rispetti la specifica

        for(row=0, col=0; row<4 && col<4 && trovato; row++, col++){
            if(bookshelf.getTile(row,col).getTileType() == TileType.NULL){
                trovato = false;
            }else {
                if (!(bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col + 1).getTileType()))
                    trovato = false;
            }
        }
        if(!trovato){
            trovato=true;
            for(row=1, col=0; row<5 && col<4 && trovato; row++, col++){
                if(bookshelf.getTile(row,col).getTileType() == TileType.NULL){
                    trovato = false;
                }else {
                    if (!(bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col + 1).getTileType()))
                        trovato = false;
                }
            }

        }
        if(!trovato){
            trovato=true;
            for(row=0, col=4; row<4 && col>0 && trovato; row++, col--){
                if(bookshelf.getTile(row,col).getTileType() == TileType.NULL){
                    trovato = false;
                }else {
                    if (!(bookshelf.getTile(row,col).getTileType() == bookshelf.getTile(row + 1,col - 1).getTileType()))
                        trovato = false;
                }
            }

        }
        if(!trovato){
            trovato=true;
            for(row=1, col=4; row<5 && col>0 && trovato; row++, col--){
                if(bookshelf.getTile(row,col).getTileType() == TileType.NULL){
                    trovato = false;
                }else {
                    if (!(bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col - 1).getTileType()))
                        trovato = false;
                }
            }

        }
        if(trovato)
            return true;
        else
            return false;
    }
}
