package it.polimi.ingsw.Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private Player sender;
    private String message;
    private Player receiver;
    private LocalTime time;

    public Message(Player sender, Player receiver, String message, LocalTime time){
        if(sender.equals(receiver)){
            throw new IllegalArgumentException("You can't send a message to yourself!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.sender = sender;
        this.message = message;
        this.receiver = receiver;
        this.time = time;
    }
    public Message(Player sender, String message, LocalTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.sender = sender;
        this.message = message;
        this.receiver = null;
        this.time = time;
    }

    public  Player getSender(){
        return sender;
    }

    public Player getReceiver(){
        return receiver;
    }

    public String getMessage(){
        return message;
    }

    public LocalTime getTime(){
        return time;
    }
}