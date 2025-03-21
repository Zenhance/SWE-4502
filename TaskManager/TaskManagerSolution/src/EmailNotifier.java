import java.util.ArrayList;
import java.util.List;

public class EmailNotifier implements Observer{

    private final List<String> notifications = new ArrayList<>();

    @Override
    public void update(Command command) {
        String notification = "Email notification: " + command.getDescription() +
                " at " + command.getTimestamp();
        notifications.add(notification);
        System.out.println(notification);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
}
