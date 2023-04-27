package it.polimi.ingsw.Model;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
public class Start implements State {
    /**
     * The method in the class start sets a timer for an 8 minute turn, when the timer ends it asks the other players
     * if they want to keep playing or if they'd rather quit
     */
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
