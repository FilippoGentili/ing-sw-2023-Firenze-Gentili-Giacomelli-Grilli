package it.polimi.ingsw;

public class CommonGoalCard2 extends CommonGoalCard {
    @Override
    public boolean check(Player player) {
        int row, col;
        boolean verifica = false, trovato = true;

        //nella libreria è possibile creare quattro diagonali: le ispeziono singolarmente finché non ne trovo una che
        //rispetti la specifica

        for(row=0, col=0; row<5 && col<5 && trovato; row++, col++){
            if(!player.getBookshelf().getTile(row,col).getTileType().equals(
                    player.getBookshelf().getTile(row+1,col+1).getTileType()))
                trovato=false;
        }
        if(!trovato){
            trovato=true;
            for(row=1, col=0; row<6 && col<5 && trovato; row++, col++){
                if(!player.getBookshelf().getTile(row,col).getTileType().equals(
                        player.getBookshelf().getTile(row+1,col+1).getTileType()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=0, col=4; row<5 && col>=0 && trovato; row++, col--){
                if(!player.getBookshelf().getTile(row,col).getTileType().equals(
                        player.getBookshelf().getTile(row+1,col-1).getTileType()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=1, col=4; row<6 && col>=0 && trovato; row++, col--){
                if(!player.getBookshelf().getTile(row,col).getTileType().equals(
                        player.getBookshelf().getTile(row+1,col-1).getTileType()))
                    trovato=false;
            }

        }
        if(trovato)
            verifica=true;

        return verifica;
    }
}
