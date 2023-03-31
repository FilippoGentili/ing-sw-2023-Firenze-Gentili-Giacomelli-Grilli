package it.polimi.ingsw;

public class CommonGoalCard11 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean trovato=false, verifica = false;
        int i, j, k, h, count = 0;

        for(i=0; i<6 && !trovato; i++){
            for(j=0; j<5 && !trovato; j++){
                for(k=0; k<6; k++){
                    for(h=0; h<5; h++){
                        if(player.getBookshelf().getTile(i,j).getTileType().equals(
                                player.getBookshelf().getTile(k,h).getTileType()))
                            count++;
                    }
                }
                count--;

                if(count>=8){
                    trovato=true;
                    verifica=true;
                }else{
                    count=0;
                }
            }
        }

        return verifica;
    }
}
