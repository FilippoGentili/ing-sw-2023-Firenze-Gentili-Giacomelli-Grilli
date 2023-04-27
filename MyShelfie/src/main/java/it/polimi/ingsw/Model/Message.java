package it.polimi.ingsw.Model;

import java.util.Date;

public class Message {

    private Player sender;
    private String message;
    private Date time;

    public Message(Player sender, String message){
        this.sender = sender;
        this.message = message;
        this.time = new Date();
    }

    public  Player getSender(){
        return sender;
    }

    public String getMessage(){
        return message;
    }

    public Date getTime(){
        return time;
    }
}