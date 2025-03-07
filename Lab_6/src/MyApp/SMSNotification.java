package MyApp;

public class SMSNotification implements INotify{
    public String userMobileNumber;

    public SMSNotification(String userMobileNumber){
        this.userMobileNumber = userMobileNumber;
    }

    @Override
    public void sendNotification(String message){
        System.out.println("\nSending Local SMS " + message);
    }
}
