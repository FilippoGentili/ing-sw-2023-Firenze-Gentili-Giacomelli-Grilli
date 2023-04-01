package it.polimi.ingsw;

public class CommonGoalCard3 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica;

        //controllo direttamente i quattro angoli della libreria
        if(player.getBookshelf().getTile(0,0).getTileType().equals(
                player.getBookshelf().getTile(0,4).getTileType()) &&
                player.getBookshelf().getTile(0,0).getTileType().equals(
                        player.getBookshelf().getTile(5,4).getTileType()) &&
                player.getBookshelf().getTile(0,0).getTileType().equals(
                        player.getBookshelf().getTile(5,0).getTileType())){
            verifica = true;
        }else{
            verifica = false;
        }

        return verifica;
    }
}
