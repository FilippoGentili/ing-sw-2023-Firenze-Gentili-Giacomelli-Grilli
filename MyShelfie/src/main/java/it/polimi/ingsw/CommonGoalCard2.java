package it.polimi.ingsw;

public class CommonGoalCard2 extends CommonGoalCard {
    @Override
    public boolean check(Player player) {
        int row, column;
        boolean verifica = false, trovato = true;

        //cerco una diagonale che rispetti la specifica fra le 4 possibili
        for(row=0, column=0; row<5 && column<5 && trovato; row++, column++){
            if(!player.getBookshelf().getTile(row,column).getTileType().equals(
                    player.getBookshelf().getTile(row+1,column+1).getTileType()))
                trovato=false;
        }
        if(!trovato){
            trovato=true;
            for(row=1, column=0; row<6 && column<5 && trovato; row++, column++){
                if(!player.getBookshelf().getTile(row,column).getTileType().equals(
                        player.getBookshelf().getTile(row+1,column+1).getTileType()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=0, column=4; row<5 && column>=0 && trovato; row++, column--){
                if(!player.getBookshelf().getTile(row,column).getTileType().equals(
                        player.getBookshelf().getTile(row+1,column-1).getTileType()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=1, column=4; row<6 && column>=0 && trovato; row++, column--){
                if(!player.getBookshelf().getTile(row,column).getTileType().equals(
                        player.getBookshelf().getTile(row+1,column-1).getTileType()))
                    trovato=false;
            }

        }
        if(trovato)
            verifica=true;

        return verifica;
    }
}
