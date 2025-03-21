package org.example;

public class EmailNotifier implements Observer{
    public void pushNotif(String message){
        System.out.println("Email sent: "+message);
    }
}
