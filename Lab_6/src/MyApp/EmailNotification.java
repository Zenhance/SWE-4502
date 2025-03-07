package MyApp;

public class EmailNotification implements INotify{
    public String userEmailAddress;

    public EmailNotification(String userEmailAddress){
        this.userEmailAddress = userEmailAddress;
    }


    @Override
    public void sendNotification(String message){
        System.out.println("\nSending Local Email " + message);
    }

}
