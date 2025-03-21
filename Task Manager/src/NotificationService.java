public class NotificationService implements IObserver{
    public String email;

    public NotificationService(String email){
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
