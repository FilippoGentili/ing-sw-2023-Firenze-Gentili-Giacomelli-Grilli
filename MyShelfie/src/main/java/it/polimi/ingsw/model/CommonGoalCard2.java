package it.polimi.ingsw.model;
import it.polimi.ingsw.model.Bookshelf;
import it.polimi.ingsw.model.CommonGoalCard;

import static java.util.Objects.isNull;

public class CommonGoalCard2 extends CommonGoalCard {
    @Override
    public boolean check(Bookshelf bookshelf) {
        int row, col;
        boolean trovato = true;

        //nella libreria è possibile creare quattro diagonali: le ispeziono singolarmente finché non ne trovo una che
        //rispetti la specifica

        for(row=0, col=0; row<4 && col<4 && trovato; row++, col++){
            if(isNull(bookshelf.getTile(row,col))){
                trovato = false;
            }else {
                if (!(bookshelf.getTile(row, col).getTileType() == bookshelf.getTile(row + 1, col + 1).getTileType()))
                    trovato = false;
            }
        }
        if(!trovato){
            trovato=true;
            for(row=1, col=0; row<5 && col<4 && trovato; row++, col++){
                if(isNull(bookshelf.getTile(row,col))){
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
                if(isNull(bookshelf.getTile(row,col))){
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
                if(isNull(bookshelf.getTile(row,col))){
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
