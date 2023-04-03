package it.polimi.ingsw;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class Start implements State{
    private Player player;
    private Timer timer;
    @Override
    public void stateAction (){
        Timer timer = new Timer();
        TimerTask turn = new TimerTask() {
            public void run() {
                System.out.println("Time is up!");
                for(Player player : Game.getPlayers()){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Do you want to keep playing?");
                    scanner.nextLine();

                }
            }
        };
        timer.schedule(turn, 48000); //A timer for max 8 minute turn is set
    }
}
