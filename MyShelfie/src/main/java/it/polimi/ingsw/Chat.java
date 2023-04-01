package it.polimi.ingsw;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    private int numberOfMessages;
    private int numberOfParticipants;
    private String Nickname;
    private ObjectInputStream messageIn;
    private ObjectOutputStream messageOut;

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getNumberOfMessages(){
        return numberOfMessages;
    }



    public void viewMessage(){
        System.out.println(message);
    }

    public void recieveMessage(){

    }
}
