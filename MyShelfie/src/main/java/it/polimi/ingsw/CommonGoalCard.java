package it.polimi.ingsw;

abstract class CommonGoalCard {
    private int id;
    private int value = 8;
    private int delta;

    public abstract boolean check(Player player);

    public int getValue() {
        return this.value;
    }

    public void updateValue(){
        this.value = this.value - this.delta;
    }

    public void setDelta(int NumPlayers){
        if(NumPlayers == 2){
            this.delta = 4;
        }else{
            this.delta = 2;
        }
    }

    public int FindSubmatrix(Tile tile, Player player, boolean[][] checkTile){
        int count=0;
        checkTile[tile.getRow()][tile.getCol()]=true;

        if(tile.getRow()==0){
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()), player);
            }
        }else if(tile.getRow()==6){
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()), player);
            }
        }else{
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()-1,tile.getCol()), player);
            }
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow()+1,tile.getCol()), player);
            }

        }

        if(tile.getCol()==0){
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1), player);
            }
        } else if(tile.getCol()==5){
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1), player);
            }
        }else{
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()+1), player);
            }
            if(tile.getTypeTile().equals(
               player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1).getTypeTile())){
                count++;
                count = count + FindSubmatrix(player.getBookshelf().getTile(tile.getRow(),tile.getCol()-1), player);
            }
        }


        return count;
    }
}

//in player serve il metodo getBookshelf() e in Tile il metodo getTypeTile()

public class CommonGoalCard1 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int count=0, countGroup, row, col;
        boolean[][] checkTile = new boolean[6][5];

        for(row=0; row<6; row++)
            for(col=0; col<5; col++)
                checkTile[row][col]=false;

        for(row=0, countGroup=0; row<6; row++){
            for(col=0; col<5; col++){
                if(checkTile[row][col]==false){
                    count= FindSubmatrix(player.getBookshelf().getTile(row, col), player, checkTile);
                }
                if(count>1)
                    countGroup++;
            }
        }

        if(countGroup>5)
            return true;
        else
            return false;
    }
}


public class CommonGoalCard2 extends CommonGoalCard {
    @Override
    public boolean check(Player player) {
        int row, column;
        boolean verifica = false, trovato = true;

        //cerco una diagonale che rispetti la specifica fra le 4 possibili
        for(row=0, column=0; row<5 && column<5 && trovato; row++, column++){
            if(!player.getBookshelf().getTile(row,column).getTypeTile().equals(
                player.getBookshelf().getTile(row+1,column+1).getTypeTile()))
                trovato=false;
        }
        if(!trovato){
            trovato=true;
            for(row=1, column=0; row<6 && column<5 && trovato; row++, column++){
                if(!player.getBookshelf().getTile(row,column).getTypeTile().equals(
                        player.getBookshelf().getTile(row+1,column+1).getTypeTile()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=0, column=4; row<5 && column>=0 && trovato; row++, column--){
                if(!player.getBookshelf().getTile(row,column).getTypeTile().equals(
                        player.getBookshelf().getTile(row+1,column-1).getTypeTile()))
                    trovato=false;
            }

        }
        if(!trovato){
            trovato=true;
            for(row=1, column=4; row<6 && column>=0 && trovato; row++, column--){
                if(!player.getBookshelf().getTile(row,column).getTypeTile().equals(
                        player.getBookshelf().getTile(row+1,column-1).getTypeTile()))
                    trovato=false;
            }

        }
        if(trovato)
            verifica=true;

        return verifica;
    }
}


public class CommonGoalCard3 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica;

        //confronto direttamente tutti e 4 gli angoli della bookshelf
        if(player.getBookshelf().getTile(0,0).getTypeTile().equals(
           player.getBookshelf().getTile(0,4).getTypeTile()) &&
           player.getBookshelf().getTile(0,0).getTypeTile().equals(
           player.getBookshelf().getTile(5,4).getTypeTile()) &&
           player.getBookshelf().getTile(0,0).getTypeTile().equals(
           player.getBookshelf().getTile(5,0).getTypeTile())){
            verifica = true;
        }else{
            verifica = false;
        }

        return verifica;
    }
}


public class CommonGoalCard4 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, uguale;
        int row, column, k, countTile, countRow=0;

        for(row=0; row<6; row++){
            for(column=1, countTile=1; column<5; column++){
                for(k=0, uguale=false; k<column && !uguale; k++){
                    if(player.getBookshelf().getTile(row,k).getTypeTile().equals(
                       player.getBookshelf().getTile(row,column).getTypeTile()))
                        uguale=true;
                }
                if(!uguale)
                    countTile++;
            }
            if(countTile<=3)
                countRow++;
        }
        if(countRow>3)
            verifica=true;

        return verifica;
    }
}


public class CommonGoalCard6 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, column, k, count=0;
        boolean verifica=false, uguali;

        for(column=0; column<5 && count<2; column++){
            for(row=0, uguali=false; row<5 && !uguali; row++){
                for(k=row+1; k<6 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,column).getTypeTile().equals(
                       player.getBookshelf().getTile(k,column).getTypeTile()))
                        uguali=true;
                }
            }
            if(!uguali)
                count++;
        }
        if(count==2)
            verifica=true;

        return verifica;
    }
}


public class CommonGoalCard8 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        int row, column, k, count=0;
        boolean verifica=false, uguali;

        for(row=0; row<6 && count<2; row++){
            for(column=0, uguali=false; column<4 && !uguali; column++){
                for(k=column+1; k<5 && !uguali; k++){
                    if(player.getBookshelf().getTile(row,column).getTypeTile().equals(
                       player.getBookshelf().getTile(row,k).getTypeTile()))
                        uguali=true;
                }
            }
            if(!uguali)
                count++;
        }
        if(count==2)
            verifica=true;

        return verifica;
    }
}


public class CommonGoalCard9 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, uguale;
        int countRow=0, countTile, column, row, k;

        for(column=0; column<5; column++){
            for(row=1, countTile=1; row<6; row++){
                for(k=0, uguale=false; k<row && !uguale; k++){
                    if(player.getBookshelf().getTile(k,column).getTypeTile().equals(
                       player.getBookshelf().getTile(row,column).getTypeTile()))
                        uguale=true;
                }
                if(!uguale)
                    countTile++;
            }
            if(countTile<4)
                countRow++;
        }
        if(countRow>2)
            verifica=true;

        return verifica;
    }
}


public class CommonGoalCard10 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica = false;
        int row, column;

        for(row=0; row<4 && !verifica; row++){
            for(column=0; column<3 && !verifica; column++){
                if(player.getBookshelf().getTile(row,column).getTypeTile().equals(
                   player.getBookshelf().getTile(row,column+2).getTypeTile()) &&
                   player.getBookshelf().getTile(row,column).getTypeTile().equals(
                   player.getBookshelf().getTile(row+2,column).getTypeTile()) &&
                   player.getBookshelf().getTile(row,column).getTypeTile().equals(
                   player.getBookshelf().getTile(row+1,column+1).getTypeTile()) &&
                   player.getBookshelf().getTile(row,column).getTypeTile().equals(
                   player.getBookshelf().getTile(row+2,column+2).getTypeTile()))
                    verifica=true;
            }
        }
        return verifica;
    }
}


public class CommonGoalCard11 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean trovato=false, verifica = false;
        int i, j, k, h, count = 0;

        for(i=0; i<6 && !trovato; i++){
            for(j=0; j<5 && !trovato; j++){
                for(k=0; k<6; k++){
                    for(h=0; h<5; h++){
                        if(player.getBookshelf().getTile(i,j).getTypeTile().equals(
                           player.getBookshelf().getTile(k,h).getTypeTile()))
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

public class CommonGoalCard12 extends CommonGoalCard{
    @Override
    public boolean check(Player player) {
        boolean verifica=false, prova;
        int row, column, count;

        for(row=0, count=0, prova=true; row<5 && prova; row++){
            count++;
            for(column=0; column<count && prova; column++){
                if(player.getBookshelf().getTile(row,column).getTypeTile().equals(null))
                    prova=false;
            }
        }
        if(!prova){
            for(row=1, count=0, prova=true; row<6 && prova; row++){
                count++;
                for(column=0; column<count && prova; column++){
                    if(player.getBookshelf().getTile(row,column).getTypeTile().equals(null))
                        prova=false;
                }
            }
        }
        if(!prova){
            for(row=5, count=0, prova=true; row>0 && prova; row--){
                for(column=4; column>=count && prova; column--){
                    if(player.getBookshelf().getTile(row,column).getTypeTile().equals(null))
                        prova=false;
                }
                count++;
            }
        }
        if(!prova){
            for(row=4, count=0, prova=true; row>=0 && prova; row--){
                for(column=4; column>=count && prova; column--){
                    if(player.getBookshelf().getTile(row,column).getTypeTile().equals(null))
                        prova=false;
                }
                count++;
            }
        }

        if(prova)
            verifica=true;

        return verifica;
    }
}